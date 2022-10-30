package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class CoordinateTest {

    @Test
    public void testDistance() {

        Coordinate testcoord1 = new Coordinate(1, 1, 1);
        Coordinate testcoord2 = new Coordinate(0, 0, 0);

        assertEquals(1.7320508075688772, testcoord1.getDistance(testcoord2), 0);

    }

    @Test
    public void testEquals() {

        Coordinate testcoord1 = new Coordinate(1, 1, 1);
        Coordinate testcoord2 = new Coordinate(0, 0, 0);
        Coordinate testcoord3 = new Coordinate(1, 1, 1);
        Coordinate testcoord4 = new Coordinate(1, 1, 2);

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
