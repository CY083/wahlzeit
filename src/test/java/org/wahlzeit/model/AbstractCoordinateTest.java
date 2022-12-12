package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class AbstractCoordinateTest {

    @Test
    public void testCartesianDistance() {

        CartesianCoordinate testcoord1 = CartesianCoordinate.getOrCreateCartesianCoordinate(1, 1, 1);
        CartesianCoordinate testcoord2 = CartesianCoordinate.getOrCreateCartesianCoordinate(3, 3, 3);

        assertEquals(3.4641016151377544, testcoord1.getCartesianDistance(testcoord2), 0.0001);
        assertEquals(3.4641016151377544, testcoord1.asSphericCoordinate().getCartesianDistance(testcoord2.asSphericCoordinate()), 0.0001);

        Coordinate testcoord3 = SphericCoordinate.getOrCreateSphericCoordinate(1, 1, 1);
        Coordinate testcoord4 = SphericCoordinate.getOrCreateSphericCoordinate(3, 3, 3);

        assertEquals(1.718879621809099, testcoord4.getCartesianDistance(testcoord3), 0.0001);
        assertEquals(1.718879621809099, testcoord4.asCartesianCoordinate().getCartesianDistance(testcoord3.asSphericCoordinate()), 0.0001);

    }

    @Test
    public void testGetCentralAngle() {

        Coordinate testcoord1 = SphericCoordinate.getOrCreateSphericCoordinate(5, Math.toRadians(30), Math.toRadians(30));
        Coordinate testcoord2 = SphericCoordinate.getOrCreateSphericCoordinate(5, Math.toRadians(60), Math.toRadians(60));

        assertEquals(0.6300251316243757, testcoord1.getCentralAngle(testcoord2), 0.0001);

        Coordinate testcoord3 = CartesianCoordinate.getOrCreateCartesianCoordinate(1, 0, 0);
        Coordinate testcoord4 = CartesianCoordinate.getOrCreateCartesianCoordinate(0, 1, 0);

        assertEquals(90, Math.toDegrees(testcoord3.getCentralAngle(testcoord4)), 0.0001);

    }

    @Test
    public void testIsEqual() {

        Coordinate cartTestCoord = CartesianCoordinate.getOrCreateCartesianCoordinate(2.165063509, 1.25, 4.330127019);
        Coordinate sphericTestCoord = SphericCoordinate.getOrCreateSphericCoordinate(4.9999999998677,0.52359877552135, 0.52359877569052);

        assertEquals(true, cartTestCoord.isEqual(cartTestCoord.asSphericCoordinate()));
        assertEquals(true, cartTestCoord.isEqual(sphericTestCoord));

        assertEquals(true, cartTestCoord.isEqual(cartTestCoord));

    }

    @Test
    public void testEquals() {

        Coordinate testCoord1 = CartesianCoordinate.getOrCreateCartesianCoordinate(0, 0, 0);
        Coordinate testCoord2 = testCoord1;

        assertEquals(true, testCoord1.equals(testCoord2));

    }


    @Test(expected = NullPointerException.class)
    public void testNullPointerException() {

        Coordinate testcoord4 = CartesianCoordinate.getOrCreateCartesianCoordinate(0, 1, 0);
        Coordinate testcoord5 = null;

        testcoord4.getCentralAngle(testcoord5);
       
    }

    /* 
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {

        CartesianCoordinate testcoord4 = CartesianCoordinate.getOrCreateCartesianCoordinate(0, 1, 0);
        
        testcoord4.setX(Double.NaN);

        testcoord4.asSphericCoordinate();


    }
    */

}

    

