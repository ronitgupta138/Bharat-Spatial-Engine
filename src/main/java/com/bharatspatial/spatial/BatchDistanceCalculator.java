package com.bharatspatial.spatial;

/**
 * Vectorized batch distance calculator computing distances from a query origin to point arrays.
 */
public class BatchDistanceCalculator {
    public static double[] computeDistances(double originLat, double originLon, double[] lats, double[] lons) {
        if (lats == null || lons == null || lats.length != lons.length) {
            throw new IllegalArgumentException("Coordinate arrays must be non-null and equal length");
        }
        double[] results = new double[lats.length];
        for (int i = 0; i < lats.length; i++) {
            results[i] = FastEquirectangularDistance.compute(originLat, originLon, lats[i], lons[i]);
        }
        return results;
    }
}
