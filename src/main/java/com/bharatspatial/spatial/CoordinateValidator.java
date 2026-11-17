package com.bharatspatial.spatial;

/**
 * Validates geographic coordinate bounds for the Indian subcontinent.
 */
public class CoordinateValidator {
    public static final double MIN_LAT = 6.0;
    public static final double MAX_LAT = 38.0;
    public static final double MIN_LON = 68.0;
    public static final double MAX_LON = 98.0;

    public static boolean isInIndianBounds(double lat, double lon) {
        return lat >= MIN_LAT && lat <= MAX_LAT && lon >= MIN_LON && lon <= MAX_LON;
    }

    public static boolean isValidGlobal(double lat, double lon) {
        return lat >= -90.0 && lat <= 90.0 && lon >= -180.0 && lon <= 180.0;
    }
}
