package com.bharatspatial.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CensusEntityRecordTest {
    @Test
    void testEntityRecordCreation() {
        CensusEntityRecord rec = new CensusEntityRecord("1001", "Salt Lake", 22.58, 88.42, "19", "North 24 Parganas");
        assertEquals("Salt Lake", rec.name());
        assertEquals(22.58, rec.latitude(), 1e-4);
        assertEquals("19", rec.stateCode());
    }

    @Test
    void testNullChecks() {
        assertThrows(NullPointerException.class, () -> new CensusEntityRecord(null, "Test", 0, 0, "01", "Dist"));
    }
}
