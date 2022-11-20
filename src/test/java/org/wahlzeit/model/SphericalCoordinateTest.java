package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SphericalCoordinateTest {

    @Test
    public void testAsCartesianCoordinate() {

        Coordinate testcoord1 = new SphericCoordinate(5, 60, 30);

        assertEquals(-0.2350974012, testcoord1.asCartesianCoordinate().getX(), 0.0001);
        assertEquals(1.505812665, testcoord1.asCartesianCoordinate().getY(), 0.0001);
        assertEquals(-4.762064902, testcoord1.asCartesianCoordinate().getZ(), 0.0001);

    }

    @Test
    public void testGetCartesianDistance() {

        Coordinate testcoord1 = new SphericCoordinate(5, 30, 30);
        Coordinate testcoord2 = new SphericCoordinate(5, 60, 60);

        assertEquals(4.7333512934254935, testcoord1.asCartesianCoordinate().getCartesianDistance(testcoord2.asCartesianCoordinate()), 0.0001);

    }

    
    
}
