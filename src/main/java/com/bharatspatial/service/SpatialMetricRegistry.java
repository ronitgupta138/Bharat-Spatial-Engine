package com.bharatspatial.service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory lightweight latency and QPS counter for spatial queries.
 */
public class SpatialMetricRegistry {
    private final AtomicLong queryCount = new AtomicLong(0);
    private final AtomicLong totalDurationNanos = new AtomicLong(0);

    public void recordQuery(long durationNanos) {
        queryCount.incrementAndGet();
        totalDurationNanos.addAndGet(durationNanos);
    }

    public long getQueryCount() {
        return queryCount.get();
    }

    public double getAverageLatencyMs() {
        long count = queryCount.get();
        if (count == 0) return 0.0;
        return (totalDurationNanos.get() / (double) count) / 1_000_000.0;
    }

    public void reset() {
        queryCount.set(0);
        totalDurationNanos.set(0);
    }
}
