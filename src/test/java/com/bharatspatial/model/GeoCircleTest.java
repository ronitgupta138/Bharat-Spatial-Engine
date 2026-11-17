package com.bharatspatial.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeoCircleTest {
    @Test
    void testCircleCreation() {
        GeoCircle circle = new GeoCircle(28.6139, 77.2090, 5000.0);
        assertEquals(5000.0, circle.radiusMeters());
        assertTrue(circle.contains(28.6139, 77.2090, 1000.0));
        assertFalse(circle.contains(28.6139, 77.2090, 6000.0));
    }

    @Test
    void testNegativeRadiusThrows() {
        assertThrows(IllegalArgumentException.class, () -> new GeoCircle(28.0, 77.0, -10.0));
    }
}
