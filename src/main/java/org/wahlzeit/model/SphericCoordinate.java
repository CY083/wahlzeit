package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

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


    @Override
    public boolean assertClassInvariants() {

        if (rho <= 0 || theta < 0 || theta > Math.PI || phi < -Math.PI || phi > Math.PI) {

            return false;
        }

        return true;
    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        assert assertClassInvariants();

        double x;
        double y;
        double z;

        x = this.rho * Math.sin(this.theta) * Math.cos(this.phi);
        y = this.rho * Math.sin(this.theta) * Math.sin(this.phi);
        z = this.rho * Math.cos(this.theta);

        CartesianCoordinate cartesianCoord = new CartesianCoordinate(x, y, z);

        assert cartesianCoord.assertClassInvariants();

        return cartesianCoord;

    }

    @Override
    public SphericCoordinate asSphericCoordinate() {

        assert assertClassInvariants();
        
        return this;
    }

    

    
}
