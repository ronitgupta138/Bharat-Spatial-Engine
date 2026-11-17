package com.bharatspatial.spatial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FastEquirectangularDistanceTest {
    @Test
    void testShortDistanceAccuracy() {
        // CP to India Gate (~2.5 km)
        double lat1 = 28.6315, lon1 = 77.2167;
        double lat2 = 28.6129, lon2 = 77.2295;
        double dist = FastEquirectangularDistance.compute(lat1, lon1, lat2, lon2);
        assertTrue(dist > 2300 && dist < 2600);
    }
}
