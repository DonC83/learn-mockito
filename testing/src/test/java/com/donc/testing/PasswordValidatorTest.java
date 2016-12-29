package com.donc.testing;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by donovan on 31/10/16.
 */
@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    static Object[] getValidPasswords() {
        return new Object[]{
                new Object[]{"Stringsldkfkf"}
        };
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Parameters(method = "getValidPasswords")
    public void passwordShouldBeAtLeast8CharactersLong(String password) throws Exception {
        PasswordValidator validator = new PasswordValidator(password);
        assertTrue("Password needs to be minimum of 8 character", validator.validateLength());
    }

    @Test
    @Parameters(method = "getValidPasswords")
    public void passwordShouldContainAlphanumericCharacters(String password) throws Exception {
        PasswordValidator validator = new PasswordValidator(password);
        assertTrue("Password needs to be alphanumeric", validator.validateAlphanumeric());
    }
}
