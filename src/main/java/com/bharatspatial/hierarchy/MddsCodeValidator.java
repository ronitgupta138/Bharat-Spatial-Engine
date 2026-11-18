package com.bharatspatial.hierarchy;

/**
 * Validates Census of India MDDS (Metadata and Data Standards) 6-digit village/town codes.
 */
public class MddsCodeValidator {
    public static boolean isValidTownCode(String mddsCode) {
        if (mddsCode == null) return false;
        String trimmed = mddsCode.trim();
        // 6 digits, numeric only
        return trimmed.length() == 6 && trimmed.matches("\\d{6}");
    }

    public static String extractStateCode(String mddsCode) {
        if (!isValidTownCode(mddsCode)) {
            throw new IllegalArgumentException("Invalid MDDS code: " + mddsCode);
        }
        return mddsCode.trim().substring(0, 2);
    }
}
