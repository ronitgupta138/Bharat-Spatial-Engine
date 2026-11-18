package com.bharatspatial.spatial;

import java.util.List;

/**
 * 2D Polygon point-in-polygon containment tester using the ray-casting algorithm.
 */
public class SpatialPolygon {
    public record Vertex(double lat, double lon) {}

    private final List<Vertex> vertices;

    public SpatialPolygon(List<Vertex> vertices) {
        if (vertices == null || vertices.size() < 3) {
            throw new IllegalArgumentException("A polygon requires at least 3 vertices");
        }
        this.vertices = List.copyOf(vertices);
    }

    public boolean contains(double lat, double lon) {
        int n = vertices.size();
        boolean inside = false;

        for (int i = 0, j = n - 1; i < n; j = i++) {
            Vertex vi = vertices.get(i);
            Vertex vj = vertices.get(j);

            boolean intersect = ((vi.lon() > lon) != (vj.lon() > lon)) &&
                (lat < (vj.lat() - vi.lat()) * (lon - vi.lon()) / (vj.lon() - vi.lon()) + vi.lat());
            if (intersect) {
                inside = !inside;
            }
        }
        return inside;
    }
}
