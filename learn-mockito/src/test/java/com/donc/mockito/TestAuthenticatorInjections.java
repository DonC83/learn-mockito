package com.donc.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by donovan on 24/10/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAuthenticatorInjections {

    @Mock
    private AuthenticatorInterface authenticatorMock;

    @InjectMocks
    private AuthenticateApplication authenticator;

    @Test
    public void testAuthenticate() throws Exception {
        String username = "username";
        String password = "password";

        when(authenticator.authenticate(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);
        assertFalse(actual);

        verify(authenticatorMock).authenticateUser(username, password);
        verify(authenticatorMock, times(1)).authenticateUser(username, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);

    }

    @Test (expected = EmptyCredentialsException.class)
    public void testThrowsEmptyCredentialsException() throws EmptyCredentialsException {
        when(authenticator.authenticate("","")).thenThrow(EmptyCredentialsException.class);
        authenticator.authenticate("", "");
        verify(authenticatorMock).authenticateUser("","");

    }
}
