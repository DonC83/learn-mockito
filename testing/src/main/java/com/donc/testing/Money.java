package com.donc.testing;

import static com.google.common.base.Preconditions.*;

/**
 * Created by donovan on 25/10/16.
 */
public class Money {

    private final int amount;
    private final String currency;

    public Money(int amount, String currency) throws IllegalArgumentException {
        checkArgument(amount>0, "Amount can't be less than 0");
        if (currency==null || currency.isEmpty())
            throw new IllegalArgumentException(currency + " is an invalid currency");
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Money) {
            Money money = (Money)o;
            return money.getCurrency().equals(getCurrency()) && money.getAmount()==getAmount();
        }
        return false;
    }
}
