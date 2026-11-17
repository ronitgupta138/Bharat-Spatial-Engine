package com.bharatspatial.spatial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VincentyDistanceTest {
    @Test
    void testCoincidentPoints() {
        assertEquals(0.0, VincentyDistance.compute(28.6139, 77.2090, 28.6139, 77.2090), 1e-6);
    }

    @Test
    void testDelhiToMumbaiDistance() {
        // New Delhi to Mumbai ~ 1,148 km
        double dist = VincentyDistance.compute(28.6139, 77.2090, 19.0760, 72.8777);
        assertTrue(dist > 1_140_000 && dist < 1_160_000, "Distance should be ~1,148 km");
    }
}
