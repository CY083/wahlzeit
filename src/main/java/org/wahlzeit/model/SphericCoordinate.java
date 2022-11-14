package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

    public static final double EPSILON = 0.0001;

    private double rho;
    private double theta;
    private double phi;
    
    public double getRho() {
        return rho;
    }

    public void setRho(double rho) {
        this.rho = rho;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }


    public SphericCoordinate(double rho, double theta, double phi) {
        this.rho = rho;
        this.theta = theta;
        this.phi = phi;

    }

    public boolean isEqual(Coordinate coordinate) {

        SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();

        double delta = this.getCartesianDistance(sphericCoord);

        if (sphericCoord == this) {

            return true;


        } 
        
        if (delta <= EPSILON) { 

            return true;


        } else {

            return this.getRho() == sphericCoord.getRho() && this.getPhi() == sphericCoord.getPhi() && this.getTheta() == sphericCoord.getTheta();

        }

    }

    @Override
    public boolean equals(Object object) {

        SphericCoordinate coordinate = (SphericCoordinate) object;

        return isEqual(coordinate);

    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        double x;
        double y;
        double z;

        x = this.rho * Math.sin(this.theta) * Math.cos(this.phi);
        y = this.rho * Math.sin(this.theta) * Math.sin(this.phi);
        z = this.rho * Math.cos(this.theta);

        CartesianCoordinate cartesianCoord = new CartesianCoordinate(x, y, z);

        return cartesianCoord;

    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {

        

        return this.asCartesianCoordinate().getDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        
        SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();

        double phi1 = this.getPhi();
        double phi2 = sphericCoord.getPhi();

        double theta1 = this.getTheta();
        double theta2 = sphericCoord.getTheta();

        double centralAngle = Math.acos(Math.sin(phi1) * Math.sin(phi2) + Math.cos(phi1) * Math.cos(phi2) * Math.cos(Math.abs(theta1 - theta2)));

        return centralAngle;
    }

    
}
