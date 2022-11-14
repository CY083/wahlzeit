package org.wahlzeit.model;

public class Location {
    
    private CartesianCoordinate coordinate;

    public Location(CartesianCoordinate coordinate) {

        if (coordinate == null) throw new IllegalArgumentException();

        this.coordinate = coordinate;
    }

    public CartesianCoordinate getCartesianCoordinate() {
        
        return this.coordinate;
    }

    public void setCartesianCoordinate(CartesianCoordinate coordinate) {

        this.coordinate = coordinate;
    }
}
