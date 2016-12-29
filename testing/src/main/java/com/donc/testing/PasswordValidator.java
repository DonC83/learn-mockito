package com.donc.testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by donovan on 31/10/16.
 */
public class PasswordValidator {


    private final String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

//    public boolean validatePassword(String password) {
//
//    }

    public boolean validateLength() {
        return password.length()>=8;
    }

    public boolean validateAlphanumeric() {
        Pattern p = Pattern.compile("[a-zA-Z0-9]+$");
        Matcher m = p.matcher(password);
        return m.find();
    }
}
