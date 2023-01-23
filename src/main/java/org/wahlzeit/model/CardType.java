package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CardType {

    protected String name;
    protected CardType superType = null;
    protected Set<CardType> subTypes = new HashSet<CardType>();

    public CardType(String name) {
        this.name = name;
    }

    public CardType getSuperType() {
        return superType;
    }

    private void setSuperType(CardType cardType) {
        this.superType = cardType;
    }

    public Iterator<CardType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(CardType ct) {
        assert (ct != null) : "tried to set null subtype";
        ct.setSuperType(this);
        this.subTypes.add(ct);
    }

    public boolean isSubType() {

        return (this.superType != null);
            
    }

    public boolean hasInstance(Card card) {
        assert (card != null) : "asked about null objects";

        if (card.getType() == this) {
            return true;
        
        }

        for (CardType type : subTypes) {
            if (type.hasInstance(card)) {
                return true;
            }
        }

        return false;

    }

    //** Domain-Sequence 02b: */
    public Card createInstance(String cardName) {

        return new Card(this, cardName);
        
    }
    
}
