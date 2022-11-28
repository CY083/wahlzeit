package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

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

    @Override
    public boolean assertClassInvariants() {

        if (Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z)) {

            return false;

        }

        if (Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z)) {

            return false;

        }

        return true;
    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        assert assertClassInvariants();
        
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {

        assertClassInvariants();

        double rho;
        double theta;
        double phi;

        rho = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        theta = Math.acos(this.getZ() / rho);
        phi = Math.atan(this.getY() / this.getX());

        SphericCoordinate sphericCoord = new SphericCoordinate(rho, theta, phi);

        assert sphericCoord.assertClassInvariants();

        return sphericCoord;
    }

}
