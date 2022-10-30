package org.wahlzeit.model;

public class Location {
    
    private Coordinate coordinate;

    public Location(Coordinate coordinate) {

        if (coordinate == null) throw new IllegalArgumentException();

        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        
        return this.coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {

        this.coordinate = coordinate;
    }
}
