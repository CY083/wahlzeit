package org.wahlzeit.model;

import org.junit.Test;

public class LocationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testLocationException() {

        Location testlocation = new Location(null);
       
    }
    
}
