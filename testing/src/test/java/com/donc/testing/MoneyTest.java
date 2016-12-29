package com.donc.testing;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by donovan on 25/10/16.
 */
@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public static Object[] getMoney() {
        return new Object[] {
                new Object[] {10, "USD"},
                new Object[] {20, "EUR"}
        };
    }

    public static Object[] getBadMoney() {
        return new Object[] {
                new Object[] {-1, "USD"},
                new Object[] {10, null},
                new Object[] {-29930, null}
        };
    }

    public static Object[] getNegativeMoney() {
        return new Object[] {
                new Object[] {-1, "USD"},
                new Object[] {-29930, null}
        };
    }

    public static Object[] getInvalidCurrency() {
        return new Object[] {
                new Object[] {100, ""},
                new Object[] {200, null}
        };
    }


    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(int amount, String currency) throws Exception {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getBadMoney")
    public void constructorShouldThrowIllegalArgumentException(int amount, String currency) {
        new Money(amount, currency);
    }

    @Test
    @Parameters(method = "getNegativeMoney")
    public void shouldThrowIAEForNegativeMoney(int amount, String currency) throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Amount can't be less than 0");
        new Money(amount, currency);
    }

    @Test
    @Parameters(method = "getInvalidCurrency")
    public void shouldThrowIAEForInvalidCurrency(int amount, String currency) throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(containsString("invalid currency"));
        new Money(amount, currency);

    }
}
