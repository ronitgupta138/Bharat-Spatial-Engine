package com.bharatspatial.search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DevanagariNormalizerTest {
    @Test
    void testNormalizeAscii() {
        assertEquals("delhi", DevanagariNormalizer.normalize("Delhi"));
        assertEquals("mumbai", DevanagariNormalizer.normalize(" MUMBAI "));
    }

    @Test
    void testNormalizeEmpty() {
        assertEquals("", DevanagariNormalizer.normalize(null));
        assertEquals("", DevanagariNormalizer.normalize("   "));
    }
}
