package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.SysLog;

public class CardPhotoFactory extends PhotoFactory{

    protected CardPhotoFactory() {

    }

    private static CardPhotoFactory instance = null;


    public static synchronized CardPhotoFactory getInstance() {
		if (instance == null) {
			SysLog.logSysInfo("setting generic CardPhotoFactory");
			setInstance(new CardPhotoFactory());
		}
		
		return instance;
	}

    protected static synchronized void setInstance(CardPhotoFactory cardPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize PhotoFactory twice");
		}
		
		instance = cardPhotoFactory;
	}

    public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

    
    public CardPhoto createCardPhoto() {
        return new CardPhoto();
    }

    
    public CardPhoto createCardPhoto(PhotoId id) throws IllegalArgumentException {

        if (id == null) throw new NullPointerException("Resultset is null.");
        return new CardPhoto(id);
    }

    
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
