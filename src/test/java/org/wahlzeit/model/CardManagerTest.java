package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardManagerTest {

    @Test
    public void testCreateCard() {

        CardManager cm = CardManager.getInstance();

        Card c1 = cm.createCard("Mountain", "Permanent");

        assertEquals("Mountain", c1.getCardName());
        assertEquals(true, cm.getCardType("Permanent").hasInstance(c1));
 
    }
    
}
