package com.example.bank.service.account;

import com.example.bank.dto.AccountSendRequestDto;
import com.example.bank.entity.Account;
import com.example.bank.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.bank.service.user.UserService.userDB;

@Slf4j
@Service
public class AccountEventService {

    private final WebClient webClient;
    public static final ConcurrentHashMap<UUID, Account> accountDB = new ConcurrentHashMap<>();
    private static final String EVENT_ACCOUNT_NAME = "행복 저축 계좌";

    public AccountEventService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Account createAccount(String accountNumber, String userId){
        if(accountDB.values().stream().anyMatch(account -> Objects.equals(account.getUserid(), userId))){
            throw new RuntimeException("The user already has the account.");
        }
        User user = userDB.get(UUID.fromString(userId));
        Account account = new Account(UUID.fromString(userId), accountNumber,EVENT_ACCOUNT_NAME + " - " + user.getUsername() );
        accountDB.put(account.getId(), account);

        AccountSendRequestDto accountSendRequestDto = new AccountSendRequestDto(accountNumber, account.getName(), user.getUsername());

        log.info("new Account Created");
        log.info(accountSendRequestDto.getAccountName());
        webClient.post()
                .uri("http://localhost:9000/accounts")
                .bodyValue(accountSendRequestDto)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("Error response from other server")))
                .bodyToMono(Void.class)
                .block();
        return account;
    }

    public Account getAccount(String accountId){
        return accountDB.get(UUID.fromString(accountId));
    }


    public void deleteAll(){
        accountDB.clear();
    }
}
