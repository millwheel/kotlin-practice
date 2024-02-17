package entity;

import org.jetbrains.annotations.NotNull;

public class Money implements Comparable<Money>{

    private final long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(@NotNull Money o) {
        return Long.compare(this.amount, o.amount);
    }
}
