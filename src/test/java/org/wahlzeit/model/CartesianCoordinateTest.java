package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class CartesianCoordinateTest {

    @Test
    public void testAsSphericCoordinate() {

        Coordinate testcoord1 = CartesianCoordinate.getOrCreateCartesianCoordinate(1, 1, 1);
        SphericCoordinate sphericTestCoord = testcoord1.asSphericCoordinate();

        assertEquals(1.7320508075689, sphericTestCoord.getRho(), 0.0001);
        assertEquals(0.95531661812451, sphericTestCoord.getTheta(), 0.0001);
        assertEquals(0.78539816339745, sphericTestCoord.getPhi(), 0.0001);
    }

    

    @Test
    public void testEquals() {

        Coordinate testcoord1 = CartesianCoordinate.getOrCreateCartesianCoordinate(1, 1, 1);
        Coordinate testcoord2 = CartesianCoordinate.getOrCreateCartesianCoordinate(0, 0, 0);
        Coordinate testcoord3 = CartesianCoordinate.getOrCreateCartesianCoordinate(1, 1, 1);
        Coordinate testcoord4 = CartesianCoordinate.getOrCreateCartesianCoordinate(1, 1, 2);

        assertEquals(true, testcoord1.isEqual(testcoord1));
        assertEquals(false, testcoord1.isEqual(testcoord2));
        assertEquals(true, testcoord1.isEqual(testcoord3));
        assertEquals(false, testcoord1.isEqual(testcoord4));

        assertEquals(true, testcoord1.equals(testcoord1));
        assertEquals(false, testcoord1.equals(testcoord2));
        assertEquals(true, testcoord1.equals(testcoord3));
        assertEquals(false, testcoord1.equals(testcoord4));


    }

}
