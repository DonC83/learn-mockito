package com.donc.testing;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by donovan on 26/10/16.
 */
@RunWith(JUnitParamsRunner.class)
public class HashMapTest {

    static Object[] getObjects() {
        return new Object[] {
                new Object[] {"key1", "Object 1"},
                new Object[] {"key2", "Object 2"},
                new Object[] {"key1", "Replaced Object"}
        };
    }

    private Map<String, Object> map;

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>();
    }

    @Test
    @Parameters(method = "getObjects")
    public void shouldRetrieveStoredObject(String key, Object value) throws Exception {
        map.put(key, value);
        assertEquals(value, map.get(key));
    }

    @Test
    public void shouldOverrideExistingValueWithSameKey() throws Exception {
        map.put("key1", "Object1");
        assertEquals("Object1", map.get("key1"));
        map.put("key1", "Objectblahblah");
        assertEquals("Objectblahblah", map.get("key1"));
    }

    @Test
    public void clearShouldRemoveAllObjectsFromMap() throws Exception {
        map.put("key1", "Object1");
        map.put("key2", "Object2");
        map.put("key3", "Object3");
        assertTrue(map.size()==3);
        map.clear();
        assertTrue(map.size()==0);
    }

    @Test
    public void nullCanBeUsedAsAKey() throws Exception {
        map.put(null, "Object1");
        assertEquals("Object1", map.get(null));

    }
}
