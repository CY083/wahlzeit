package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class CartesianCoordinateTest {

    @Test
    public void testDistance() {

        CartesianCoordinate testcoord1 = new CartesianCoordinate(1, 1, 1);
        CartesianCoordinate testcoord2 = new CartesianCoordinate(3, 3, 3);

        assertEquals(3.4641016151377544, testcoord1.getDistance(testcoord2), 0.0001);

        assertEquals(3.4641016151377544, testcoord1.asSphericCoordinate().getCartesianDistance(testcoord2.asSphericCoordinate()), 0.0001);

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
