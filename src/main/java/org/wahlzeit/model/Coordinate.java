package org.wahlzeit.model;

public class Coordinate {

    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
}

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    public double getDistance(Coordinate coordinate) {

        double distX = this.getX() - coordinate.getX();
        double distY = this.getX() - coordinate.getY();
        double distZ = this.getX() - coordinate.getZ();

        return Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2) + Math.pow(distZ, 2));
    }

    public boolean isEqual(Coordinate coordinate) {

        if (coordinate == this) {

            return true;

        } else {

            return this.getX() == coordinate.getX() && this.getY() == coordinate.getY() && this.getZ() == coordinate.getZ();

        }

    }

    @Override
    public boolean equals(Object object) {

        Coordinate coordinate = (Coordinate) object;

        return isEqual(coordinate);
        
    }

    


    }

