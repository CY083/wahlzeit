package org.wahlzeit.model;
import java.util.HashMap;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    protected static HashMap<Integer, CartesianCoordinate> hm = new HashMap<Integer, CartesianCoordinate>();

    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {

        return x;

    }

    public double getY() {

        return y;

    }

    public double getZ() {

        return z;

    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z);

    }

    private static int hashCode(double x, double y, double z) {

        return Objects.hash(x, y, z);
        
    }

    public static CartesianCoordinate getOrCreateCartesianCoordinate(double x, double y, double z) {

        int key = hashCode(x, y, z);

        CartesianCoordinate cartCoord = hm.get(key);

        if (cartCoord == null) {

            cartCoord = new CartesianCoordinate(x, y, z);

            hm.put(key, cartCoord);

        }

        return cartCoord;

    }

    @Override
    public void assertClassInvariants() throws IllegalArgumentException{

        if (Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z)) {

            throw new IllegalArgumentException("At least one value is not a number.");

        }

        if (Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z)) {

            throw new IllegalArgumentException("At least on value is infinite.");
        }

    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        assertClassInvariants();
        
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

        SphericCoordinate sphericCoord = SphericCoordinate.getOrCreateSphericCoordinate(rho, theta, phi);

        sphericCoord.assertClassInvariants();

        return sphericCoord;
    }

}
