package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardPhoto extends Photo {

    protected Card card;


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CardPhoto(ResultSet rset) throws SQLException, NullPointerException {
        super(rset);

        if (rset == null) throw new NullPointerException("Resultset is null.");
        
    }

    public CardPhoto() {
        super();

    }

    public CardPhoto(PhotoId myId) {
        super(myId);
    }

}
