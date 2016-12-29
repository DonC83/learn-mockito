package com.donc.testing;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by donovan on 26/10/16.
 */
@RunWith(JUnitParamsRunner.class)
public class StringUtilityTest {

    public static Object[] getStrings() {
        return new Object[] {
                new Object[] {"abcde", "edcba"},
                new Object[] {"wxyz", "zyxw"}
        };
    }

    public static Object[] getNullStrings() {
        return new Object[] {
                new Object[] {null, ""},
                new Object[] {null, null},
        };
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Parameters(method = "getStrings")
    public void expectStringToReverse(String original, String expected) throws Exception {
        assertEquals(expected, StringUtility.reverse(original));
    }

    @Test(expected = NullPointerException.class)
    @Parameters(method = "getNullStrings")
    public void shouldThrowNPE(String original, String expected) throws NullPointerException {
        assertEquals(expected, StringUtility.reverse(original));

    }

    @Test
    public void shouldReturnBlankString() throws Exception {
        assertEquals("", StringUtility.reverse(""));

    }
}
