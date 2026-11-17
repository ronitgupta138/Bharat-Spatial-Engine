package com.bharatspatial.search;

import java.text.Normalizer;

/**
 * Normalizer for Devanagari Unicode script to standardize fuzzy search toponyms.
 */
public class DevanagariNormalizer {
    public static String normalize(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        // Normalize Unicode canonical decomposition (NFD)
        String decomposed = Normalizer.normalize(input.trim(), Normalizer.Form.NFD);
        // Strip non-spacing marks (accents / nukta)
        String stripped = decomposed.replaceAll("\\p{M}", "");
        return stripped.toLowerCase();
    }
}
