package org.wahlzeit.model;

/** 
 * Card / CardType Collaboration (Type Object)
 * Provides information common to all instances of a type
 * Role types: Client, Card (Base Object), FlowerType (Type Object) 
 */

public class Card {

    private CardType cardType = null;
    private Location location;
    private String cardName;

    public Card(CardType ct, String name) {

        this.cardType = ct;
        this.cardName = name;
    }

    public Card(CardType ct, String name, Location location) {

        this.cardType = ct;
        this.cardName = name;
        this.location = location;
    }

    public String getCardName() {
        return this.cardName;
    }

    public CardType getType() {
        return this.cardType;
    }


    
}
