package com.donc.mockito;

import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by donovan on 24/10/16.
 */
public class TestAuthenticatorInterface {

    @Test
    public void testAuthenticate() throws Exception {
        AuthenticatorInterface authenticatorMock;
        AuthenticateApplication authenticator;
        String username = "username";
        String password = "password";

        authenticatorMock = mock(AuthenticatorInterface.class);
        authenticator = new AuthenticateApplication(authenticatorMock);
        when(authenticator.authenticate(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);
        assertFalse(actual);

//        verify(authenticatorMock).authenticateUser(username, password);
//        verify(authenticatorMock, times(1)).authenticateUser(username, password);
//        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, zpassword);
//        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
//        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);

        InOrder inOrder = inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).foo();
        inOrder.verify(authenticatorMock).authenticateUser(username, password);

    }

    @Test (expected = EmptyCredentialsException.class)
    public void testThrowsEmptyCredentialsException() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock = mock(AuthenticatorInterface.class);
        AuthenticateApplication authenticator = new AuthenticateApplication(authenticatorMock);
        when(authenticator.authenticate("","")).thenThrow(EmptyCredentialsException.class);

        authenticator.authenticate("", "");

    }
}
