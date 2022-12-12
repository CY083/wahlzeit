package org.wahlzeit.model;
import java.util.HashMap;
import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private final double rho;
    private final double theta;
    private final double phi;

    protected static HashMap<Integer, SphericCoordinate> hm = new HashMap<Integer, SphericCoordinate>();
    
    private SphericCoordinate(double rho, double theta, double phi) {
        this.rho = rho;
        this.theta = theta;
        this.phi = phi;

    }

    public double getRho() {

        return rho;
    }

    public double getTheta() {

        return theta;
    }

    public double getPhi() {

        return phi;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rho, theta, phi);

    }

    private static int hashCode(double rho, double theta, double phi) {
        
        return Objects.hash(rho, theta, phi);
        
    }

    public static SphericCoordinate getOrCreateSphericCoordinate(double rho, double theta, double phi) {

        int key = hashCode(rho, theta, phi);

        SphericCoordinate sphericCoord = hm.get(key);

        if (sphericCoord == null) {

            sphericCoord = new SphericCoordinate(rho, theta, phi);

            hm.put(key, sphericCoord);

        }

        return sphericCoord;

    }



    @Override
    public void assertClassInvariants() throws IllegalArgumentException {

        if (rho <= 0 || theta < 0 || theta > Math.PI || phi < -Math.PI || phi > Math.PI) {

            throw new IllegalArgumentException("Radius must be positive number. Theta must be between 0 and Pi. Phi must be between .Pi and Pi.");
        }

    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        assertClassInvariants();

        double x;
        double y;
        double z;

        x = this.rho * Math.sin(this.theta) * Math.cos(this.phi);
        y = this.rho * Math.sin(this.theta) * Math.sin(this.phi);
        z = this.rho * Math.cos(this.theta);

        CartesianCoordinate cartesianCoord = CartesianCoordinate.getOrCreateCartesianCoordinate(x, y, z);

        cartesianCoord.assertClassInvariants();

        return cartesianCoord;

    }

    @Override
    public SphericCoordinate asSphericCoordinate() {

        assertClassInvariants();
        
        return this;
    }

    

    
}
