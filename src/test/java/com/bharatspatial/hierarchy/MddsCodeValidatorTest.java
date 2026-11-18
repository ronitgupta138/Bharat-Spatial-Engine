package com.bharatspatial.hierarchy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MddsCodeValidatorTest {
    @Test
    void testMddsValidation() {
        assertTrue(MddsCodeValidator.isValidTownCode("190203"));
        assertTrue(MddsCodeValidator.isValidTownCode("070001"));
        assertFalse(MddsCodeValidator.isValidTownCode("12345")); // too short
        assertFalse(MddsCodeValidator.isValidTownCode("1234567")); // too long
        assertFalse(MddsCodeValidator.isValidTownCode("12A456")); // non-numeric
    }

    @Test
    void testStateCodeExtraction() {
        assertEquals("19", MddsCodeValidator.extractStateCode("190203"));
        assertEquals("07", MddsCodeValidator.extractStateCode("070001"));
    }
}
