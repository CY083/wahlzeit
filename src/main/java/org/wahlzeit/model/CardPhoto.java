package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardPhoto extends Photo {

    

    public CardPhoto(ResultSet rset) throws SQLException {
        super(rset);
        
    }

    public CardPhoto() {
        super();
    }

    public CardPhoto(PhotoId myId) {
        super(myId);
    }

}
