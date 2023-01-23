package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.SysLog;

@PatternInstance(
    patternName = "Singleton",
    participants = {
        "CardPhotoFactory"
    }
)
public class CardPhotoFactory extends PhotoFactory{

    protected CardPhotoFactory() {

    }

    private static CardPhotoFactory instance = null;


    //** Photo-Sequence 01b: */
    public static synchronized CardPhotoFactory getInstance() {
		if (instance == null) {
			SysLog.logSysInfo("setting generic CardPhotoFactory");
			setInstance(new CardPhotoFactory());
		}
		
		return instance;
	}

    //** Photo-Sequence 01c: */
    protected static synchronized void setInstance(CardPhotoFactory cardPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize PhotoFactory twice");
		}
		
		instance = cardPhotoFactory;
	}

    public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

    //** Photo-Sequence 03: */
    public CardPhoto createCardPhoto() {
        return new CardPhoto();
    }

    
    //** Photo-Sequence 03: */
    public CardPhoto createCardPhoto(PhotoId id) throws IllegalArgumentException {

        if (id == null) throw new NullPointerException("Resultset is null.");
        return new CardPhoto(id);
    }

    //** Photo-Sequence 03: */
    public CardPhoto createCardPhoto(ResultSet rset) throws SQLException, NullPointerException {

        if (rset == null) throw new NullPointerException("Resultset is null.");
        return new CardPhoto(rset);
    }

    
    public PhotoFilter createPhotoFilter() {
        return new PhotoFilter();
    }

    
    public PhotoTagCollector createPhotoTagCollector() {
        return new PhotoTagCollector();
    }
    
}
