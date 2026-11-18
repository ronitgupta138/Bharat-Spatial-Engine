package com.bharatspatial.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpatialQueryCacheTest {
    @Test
    void testLruEviction() {
        SpatialQueryCache<String, String> cache = new SpatialQueryCache<>(2);
        cache.put("k1", "v1");
        cache.put("k2", "v2");
        assertEquals("v1", cache.get("k1"));

        // Insert 3rd item, k2 should be evicted because k1 was accessed
        cache.put("k3", "v3");
        assertEquals("v1", cache.get("k1"));
        assertNull(cache.get("k2"));
        assertEquals("v3", cache.get("k3"));
    }
}
