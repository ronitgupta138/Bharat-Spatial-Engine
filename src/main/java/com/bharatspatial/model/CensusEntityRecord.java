package com.bharatspatial.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Immutable administrative census entity record.
 */
public record CensusEntityRecord(
    String id,
    String name,
    double latitude,
    double longitude,
    String stateCode,
    String districtName
) implements Serializable {
    public CensusEntityRecord {
        Objects.requireNonNull(id, "ID cannot be null");
        Objects.requireNonNull(name, "Name cannot be null");
    }
}
