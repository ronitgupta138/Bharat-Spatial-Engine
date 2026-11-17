package com.bharatspatial.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpatialMetricRegistryTest {
    @Test
    void testMetricRecording() {
        SpatialMetricRegistry registry = new SpatialMetricRegistry();
        registry.recordQuery(1_000_000L); // 1ms
        registry.recordQuery(3_000_000L); // 3ms

        assertEquals(2, registry.getQueryCount());
        assertEquals(2.0, registry.getAverageLatencyMs(), 1e-4);
    }
}
