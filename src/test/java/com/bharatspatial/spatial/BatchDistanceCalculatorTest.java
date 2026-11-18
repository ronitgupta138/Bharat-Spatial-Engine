package com.bharatspatial.spatial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BatchDistanceCalculatorTest {
    @Test
    void testBatchComputation() {
        double[] lats = {28.6139, 28.6140};
        double[] lons = {77.2090, 77.2091};
        double[] dists = BatchDistanceCalculator.computeDistances(28.6139, 77.2090, lats, lons);

        assertEquals(2, dists.length);
        assertEquals(0.0, dists[0], 1e-4);
        assertTrue(dists[1] > 0.0);
    }
}
