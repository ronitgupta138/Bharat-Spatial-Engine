package com.bharatspatial.spatial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateValidatorTest {
    @Test
    void testIndianCoordinates() {
        assertTrue(CoordinateValidator.isInIndianBounds(28.6139, 77.2090)); // Delhi
        assertTrue(CoordinateValidator.isInIndianBounds(19.0760, 72.8777)); // Mumbai
        assertFalse(CoordinateValidator.isInIndianBounds(51.5074, -0.1278)); // London
    }

    @Test
    void testGlobalCoordinates() {
        assertTrue(CoordinateValidator.isValidGlobal(0.0, 0.0));
        assertFalse(CoordinateValidator.isValidGlobal(95.0, 0.0));
        assertFalse(CoordinateValidator.isValidGlobal(0.0, 200.0));
    }
}
