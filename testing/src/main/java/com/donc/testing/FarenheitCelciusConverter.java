package com.donc.testing;

/**
 * Created by donovan on 26/10/16.
 */
public class FarenheitCelciusConverter {

    public static long toFarenheit(double celcius) {
        return (long)((celcius-32) * 5) / 9;
    }

    public static long toCelcius(double farenheit) {
        return Math.round((farenheit * 9)/5 + 32);
    }
}
