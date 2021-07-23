package io.github.joealisson.primitive.test;

import io.github.joealisson.primitive.CHashLongMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CHashLongMapTest {

    @Test
    public void testPut() {
        var map = new CHashLongMap<String>();

        assertTrue(map.isEmpty());

        map.put(1, "1");

        assertFalse(map.isEmpty());
        assertTrue(map.containsKey(1));
        assertEquals("1", map.get(1));
    }

    @Test
    public void testRemove() {
        var map = new CHashLongMap<String>();

        assertTrue(map.isEmpty());

        map.put(1, "1");

        assertTrue(map.containsKey(1));
        assertEquals("1", map.remove(1));
        assertTrue(map.isEmpty());
    }
}
