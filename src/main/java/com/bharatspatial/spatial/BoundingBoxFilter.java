package com.bharatspatial.spatial;

import com.bharatspatial.model.GeoPoint;
import com.bharatspatial.model.SpatialBoundingBox;

/**
 * Filter testing whether spatial coordinates fall strictly within a geographic bounding window.
 */
public class BoundingBoxFilter {
    private final SpatialBoundingBox bounds;

    public BoundingBoxFilter(SpatialBoundingBox bounds) {
        this.bounds = bounds;
    }

    public boolean contains(double lat, double lon) {
        return lat >= bounds.getMinLat() && lat <= bounds.getMaxLat()
            && lon >= bounds.getMinLon() && lon <= bounds.getMaxLon();
    }

    public boolean contains(GeoPoint point) {
        return point != null && contains(point.getLatitude(), point.getLongitude());
    }
}
