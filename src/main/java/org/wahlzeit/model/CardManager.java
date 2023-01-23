package org.wahlzeit.model;

import java.util.HashMap;

public class CardManager {

    private static CardManager instance = null;

    private HashMap<String, Card> cards = new HashMap<>();
    private HashMap<String, CardType> cardTypes = new HashMap<>();


    //** Domain-Sequence 01b: */
    public static synchronized CardManager getInstance() {
		if (instance == null) {
			setInstance(new CardManager());
		}
		
		return instance;
	}
	
    //** Domain-Sequence 01c: */
	protected static synchronized void setInstance(CardManager cardManager) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize CardManager twice");
		}
		
		instance = cardManager;
	}
	
    //** Domain-Sequence 01a: */
	public static void initialize() {
		getInstance(); 
	}

    //** Domain-Sequence 02a: */
    public Card createCard(String cardName, String typeName) {

        CardType ct = getCardType(typeName);

        Card result = ct.createInstance(cardName);

        cards.put(result.getCardName(), result);

        return result;
    }

    protected CardType getCardType(String typeName) {

        CardType ct = new CardType(typeName);

        if (cardTypes.containsKey(typeName)) {

            return cardTypes.get(typeName);

        } else { 
            
            cardTypes.put(typeName, ct);

            return ct;

        }
            
    }

}