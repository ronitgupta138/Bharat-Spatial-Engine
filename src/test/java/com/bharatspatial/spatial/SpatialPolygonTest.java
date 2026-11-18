package com.bharatspatial.spatial;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SpatialPolygonTest {
    @Test
    void testPointInPolygon() {
        // Simple bounding triangle
        List<SpatialPolygon.Vertex> triangle = List.of(
            new SpatialPolygon.Vertex(0.0, 0.0),
            new SpatialPolygon.Vertex(10.0, 0.0),
            new SpatialPolygon.Vertex(5.0, 10.0)
        );
        SpatialPolygon poly = new SpatialPolygon(triangle);

        assertTrue(poly.contains(4.0, 2.0));
        assertFalse(poly.contains(12.0, 5.0));
        assertFalse(poly.contains(-1.0, 2.0));
    }

    @Test
    void testInvalidVerticesCount() {
        assertThrows(IllegalArgumentException.class, () -> new SpatialPolygon(List.of()));
    }
}
