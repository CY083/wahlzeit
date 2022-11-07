package org.wahlzeit.model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardPhotoManager extends PhotoManager {

    protected final CardPhotoManager instance = new CardPhotoManager();


    public CardPhotoManager() {
        super();
    }
    
    protected CardPhoto createObject(ResultSet rset) throws SQLException {
		return CardPhotoFactory.getInstance().createCardPhoto(rset);
	}

    public CardPhoto createCardPhoto(File file) throws Exception {
		PhotoId id = PhotoId.getNextId();
		CardPhoto result = (CardPhoto) PhotoUtil.createPhoto(file, id);
		addPhoto(result);
		return result;
	}
}
