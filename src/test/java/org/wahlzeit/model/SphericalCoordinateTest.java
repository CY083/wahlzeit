package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SphericalCoordinateTest {

    @Test
    public void testAsCartesianCoordinate() {

        Coordinate testcoord1 = new SphericCoordinate(5, Math.toRadians(60), Math.toRadians(30));

        assertEquals(3.75, testcoord1.asCartesianCoordinate().getX(), 0.0001);
        assertEquals(2.165063509461096, testcoord1.asCartesianCoordinate().getY(), 0.0001);
        assertEquals(2.5, testcoord1.asCartesianCoordinate().getZ(), 0.0001);

    }

    @Test
    public void testGetCartesianDistance() {

        Coordinate testcoord1 = new SphericCoordinate(5, Math.toRadians(30), Math.toRadians(30));
        Coordinate testcoord2 = new SphericCoordinate(5, Math.toRadians(60), Math.toRadians(60));

        assertEquals(1.6199401630110577, testcoord1.asCartesianCoordinate().getCartesianDistance(testcoord2.asCartesianCoordinate()), 0.0001);

    }

    
    
}
