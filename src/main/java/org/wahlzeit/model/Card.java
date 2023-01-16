package org.wahlzeit.model;

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
