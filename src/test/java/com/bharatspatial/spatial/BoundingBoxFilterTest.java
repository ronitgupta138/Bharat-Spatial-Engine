package com.bharatspatial.spatial;

import com.bharatspatial.model.GeoPoint;
import com.bharatspatial.model.SpatialBoundingBox;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoundingBoxFilterTest {
    @Test
    void testContainsPoint() {
        SpatialBoundingBox box = new SpatialBoundingBox(10.0, 70.0, 20.0, 80.0);
        BoundingBoxFilter filter = new BoundingBoxFilter(box);

        assertTrue(filter.contains(15.0, 75.0));
        assertFalse(filter.contains(5.0, 75.0));
        assertFalse(filter.contains(15.0, 85.0));

        GeoPoint inside = new GeoPoint(15.0, 75.0);
        assertTrue(filter.contains(inside));
    }
}
