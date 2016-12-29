package com.donc.testing;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by donovan on 26/10/16.
 */
@RunWith(JUnitParamsRunner.class)
public class FarenheitCelciusConverterTest {

    static Object[] getTemperatures() {
        return new Object[] {
                new Object[] {32, 0},
                new Object[] {99, 37},
                new Object[] {212, 100}
        };
    }

    @Test
    @Parameters(method = "getTemperatures")
    public void shouldConvertCelciusToFarenheit(int celcius, int farenheit) throws Exception {
        assertEquals(farenheit, FarenheitCelciusConverter.toFarenheit(celcius));
    }

    @Test
    @Parameters(method = "getTemperatures")
    public void shouldConvertFarenheitToCelcius(int celcius, int farenheit) throws Exception {
        assertEquals(celcius, FarenheitCelciusConverter.toCelcius(farenheit));
    }
}
