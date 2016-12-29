package com.donc.mockito;

/**
 * Created by donovan on 24/10/16.
 */
public class AuthenticateApplication {

    private AuthenticatorInterface authenticator;

    public AuthenticateApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    boolean authenticate(String username, String password) throws EmptyCredentialsException {

        this.authenticator.foo();
        return authenticator.authenticateUser(username, password);
    }
}
