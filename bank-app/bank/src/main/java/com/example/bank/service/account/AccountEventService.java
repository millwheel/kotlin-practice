package com.example.bank.service.account;

import com.example.bank.dto.AccountSendRequestDto;
import com.example.bank.entity.Account;
import com.example.bank.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.bank.service.user.UserService.userDB;

@Service
public class AccountEventService {

    @Value("${other.bank.url}")
    public static String OTHER_BANK_URL;
    private final WebClient webClient;
    public static final ConcurrentHashMap<UUID, Account> accountDB = new ConcurrentHashMap<>();
    private static final String EVENT_ACCOUNT_NAME = "행복 저축 계좌";

    public AccountEventService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(OTHER_BANK_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Account createAccount(String accountNumber, String userId){
        if(accountDB.values().stream().anyMatch(account -> Objects.equals(account.getUserid(), userId))){
            throw new RuntimeException("The user already has the account.");
        }
        User user = userDB.get(UUID.fromString(userId));
        Account account = new Account(UUID.fromString(userId), accountNumber,EVENT_ACCOUNT_NAME + user.getUsername() );
        accountDB.put(account.getId(), account);

        AccountSendRequestDto accountSendRequestDto = new AccountSendRequestDto(accountNumber, account.getName(), user.getUsername());

        webClient.post()
                .uri("/account")
                .bodyValue(accountSendRequestDto)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("Error response from other server")))
                .bodyToMono(Void.class);
        return account;
    }

    public Account getAccount(String accountId){
        return accountDB.get(UUID.fromString(accountId));
    }


    public void deleteAll(){
        accountDB.clear();
    }
}
