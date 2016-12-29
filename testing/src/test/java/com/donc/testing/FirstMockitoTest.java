package com.donc.testing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
/**
 * Created by donovan on 14/11/16.
 */
public class FirstMockitoTest {

    private Car myFerrari = mock(Car.class);

    @Test
    public void testIfCarIsACar() throws Exception {
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void testDefaultBehaviourOfTestDouble() throws Exception {
        assertFalse("new test double should return false as boolean", myFerrari.needsFuel());
        assertEquals("new test double should return 0 as double", 0.0, myFerrari.getEngineTemperature(), 0);
    }

    @Test
    public void testStubbing() throws Exception {
        assertFalse("new test double should return false as boolean", myFerrari.needsFuel());
        when(myFerrari.needsFuel()).thenReturn(true);
        assertTrue("after instructed test double should return what we want", myFerrari.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void throwsException() throws Exception {
        when(myFerrari.needsFuel()).thenThrow(new RuntimeException());
        myFerrari.needsFuel();
    }

    @Test
    public void testVerification() throws Exception {
        myFerrari.driveTo("Sweet home Alabama");
        myFerrari.needsFuel();

        verify(myFerrari).driveTo("Sweet home Alabama");
        verify(myFerrari).needsFuel();
    }

    @Test
    public void testVerificationFailure() throws Exception {
        myFerrari.needsFuel();

        verify(myFerrari).getEngineTemperature();
    }
}
