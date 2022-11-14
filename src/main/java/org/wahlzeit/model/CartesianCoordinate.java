package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {

    public static final double EPSILON = 0.0001;
    
    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
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


    public double getDistance(CartesianCoordinate coordinate) {

        double distX = this.getX() - coordinate.getX();
        double distY = this.getX() - coordinate.getY();
        double distZ = this.getX() - coordinate.getZ();

        return Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2) + Math.pow(distZ, 2));
    }

    public boolean isEqual(Coordinate coordinate) {


        CartesianCoordinate cartesianCoord = coordinate.asCartesianCoordinate();

        double delta = this.getCartesianDistance(cartesianCoord);

        if (cartesianCoord == this) {

            return true;

        }

        if (delta <= EPSILON) { 

            return true;
    
    

        } else {

            return this.getX() == cartesianCoord.getX() && this.getY() == cartesianCoord.getY() && this.getZ() == cartesianCoord.getZ();

        }

    }

    @Override
    public boolean equals(Object object) {

        CartesianCoordinate coordinate = (CartesianCoordinate) object;

        return isEqual(coordinate);
        
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {

        return this.getDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {

        double rho;
        double theta;
        double phi;

        rho = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        theta = Math.acos(this.getZ() / rho);
        phi = Math.atan(this.getY() / this.getX());

        SphericCoordinate sphericCoord = new SphericCoordinate(rho, theta, phi);

        return sphericCoord;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {

        SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();

        double phi1 = this.asSphericCoordinate().getPhi();
        double phi2 = sphericCoord.getPhi();

        double theta1 = this.asSphericCoordinate().getTheta();
        double theta2 = sphericCoord.getTheta();

        double centralAngle = Math.acos(Math.sin(phi1) * Math.sin(phi2) + Math.cos(phi1) * Math.cos(phi2) * Math.cos(Math.abs(theta1 - theta2)));

        return centralAngle;
    
    }

    
    
}
