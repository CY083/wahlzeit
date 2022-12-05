package org.wahlzeit.model;

public interface Coordinate {

    CartesianCoordinate asCartesianCoordinate();

    double getCartesianDistance(Coordinate coordinate);

    SphericCoordinate asSphericCoordinate();

    double getCentralAngle(Coordinate coordniate);

    boolean isEqual(Coordinate coordinate);

    void assertClassInvariants();

    }

