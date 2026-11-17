package com.bharatspatial.spatial;

/**
 * Vincenty inverse geodesic distance calculation on WGS-84 ellipsoid.
 */
public class VincentyDistance {
    private static final double A = 6378137.0; // WGS-84 semi-major axis
    private static final double B = 6356752.314245; // WGS-84 semi-minor axis
    private static final double F = 1 / 298.257223563; // flattening

    public static double compute(double lat1, double lon1, double lat2, double lon2) {
        if (lat1 == lat2 && lon1 == lon2) {
            return 0.0;
        }
        double L = Math.toRadians(lon2 - lon1);
        double U1 = Math.atan((1 - F) * Math.tan(Math.toRadians(lat1)));
        double U2 = Math.atan((1 - F) * Math.tan(Math.toRadians(lat2)));
        double sinU1 = Math.sin(U1), cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2), cosU2 = Math.cos(U2);

        double lambda = L, lambdaP;
        double sinSigma, cosSigma, sigma, sinAlpha, cosSqAlpha, cos2SigmaM;
        int iterLimit = 100;

        do {
            double sinLambda = Math.sin(lambda), cosLambda = Math.cos(lambda);
            sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda) +
                    (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda) * (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
            if (sinSigma == 0) return 0; // coincident points
            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
            cosSqAlpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = (cosSqAlpha != 0) ? (cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha) : 0;
            double C = F / 16 * cosSqAlpha * (4 + F * (4 - 3 * cosSqAlpha));
            lambdaP = lambda;
            lambda = L + (1 - C) * F * sinAlpha *
                    (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)));
        } while (Math.abs(lambda - lambdaP) > 1e-12 && --iterLimit > 0);

        double uSq = cosSqAlpha * (A * A - B * B) / (B * B);
        double A_coeff = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B_coeff = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double deltaSigma = B_coeff * sinSigma * (cos2SigmaM + B_coeff / 4 * (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) -
                B_coeff / 6 * cos2SigmaM * (-3 + 4 * sinSigma * sinSigma) * (-3 + 4 * cos2SigmaM * cos2SigmaM)));

        return B * A_coeff * (sigma - deltaSigma);
    }
}
