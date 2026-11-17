package com.bharatspatial.model;

/**
 * Geometric circle model for radial range queries.
 */
public record GeoCircle(double centerLat, double centerLon, double radiusMeters) {
    public GeoCircle {
        if (radiusMeters < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
    }

    public boolean contains(double lat, double lon, double distanceMeters) {
        return distanceMeters <= radiusMeters;
    }
}
