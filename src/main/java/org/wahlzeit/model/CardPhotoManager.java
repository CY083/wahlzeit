package org.wahlzeit.model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardPhotoManager extends PhotoManager {

	//** Photo-Sequence 02: */
    protected final CardPhotoManager instance = new CardPhotoManager();


    public CardPhotoManager() {
        super();
    }
    
	//** Photo-Sequence 03a: */
    protected CardPhoto createObject(ResultSet rset) throws SQLException, NullPointerException {

		if (rset == null) throw new NullPointerException("Resultset is null.");
		return CardPhotoFactory.getInstance().createCardPhoto(rset);
	}

    public CardPhoto createCardPhoto(File file) throws Exception, NullPointerException {

		if (file == null) throw new NullPointerException("Resultset is null.");
		PhotoId id = PhotoId.getNextId();
		CardPhoto result = (CardPhoto) PhotoUtil.createPhoto(file, id);
		addPhoto(result);
		return result;
	}
}
