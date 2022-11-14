package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class CartesianCoordinateTest {

    @Test
    public void testDistance() {

        CartesianCoordinate testcoord1 = new CartesianCoordinate(1, 1, 1);
        CartesianCoordinate testcoord2 = new CartesianCoordinate(0, 0, 0);

        assertEquals(1.7320508075688772, testcoord1.getDistance(testcoord2), 0);

    }

    @Test
    public void testEquals() {

        CartesianCoordinate testcoord1 = new CartesianCoordinate(1, 1, 1);
        CartesianCoordinate testcoord2 = new CartesianCoordinate(0, 0, 0);
        CartesianCoordinate testcoord3 = new CartesianCoordinate(1, 1, 1);
        CartesianCoordinate testcoord4 = new CartesianCoordinate(1, 1, 2);

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
