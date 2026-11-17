package com.bharatspatial.spatial;

/**
 * Fast equirectangular flat-surface distance approximation for near-equatorial pairs (< 50 km).
 */
public class FastEquirectangularDistance {
    private static final double EARTH_RADIUS_METERS = 6371008.8;

    public static double compute(double lat1, double lon1, double lat2, double lon2) {
        double latRad1 = Math.toRadians(lat1);
        double latRad2 = Math.toRadians(lat2);
        double deltaLon = Math.toRadians(lon2 - lon1);
        double deltaLat = Math.toRadians(lat2 - lat1);

        double meanLat = (latRad1 + latRad2) / 2.0;
        double x = deltaLon * Math.cos(meanLat);
        double y = deltaLat;

        return Math.sqrt(x * x + y * y) * EARTH_RADIUS_METERS;
    }
}
