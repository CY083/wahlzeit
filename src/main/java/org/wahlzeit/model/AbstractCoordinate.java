package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    public static final double EPSILON = 0.0001;


    public void assertIsNotNull(Coordinate coord) throws NullPointerException{


        if (coord == null) throw new NullPointerException("Coordinate is null.");
    
    
    }

    public void assertIsNumber(double number) throws IllegalArgumentException {

        if (!Double.isFinite(number)) throw new IllegalArgumentException("Argument is not a number or infinite.");

    }



    @Override
    public double getCartesianDistance(Coordinate coordinate) {

        assertClassInvariants();
        assertIsNotNull(coordinate);

        CartesianCoordinate cartCoord = this.asCartesianCoordinate();
        CartesianCoordinate otherCartCoord = coordinate.asCartesianCoordinate();

        double distance = doGetCartesianDistance(cartCoord, otherCartCoord);


        assertIsNumber(distance);
        assertClassInvariants();

        return distance;

    }

    private double doGetCartesianDistance(CartesianCoordinate cartCoord, CartesianCoordinate otherCartCoord) {

        double distX = cartCoord.getX() - otherCartCoord.getX();
        double distY = cartCoord.getX() - otherCartCoord.getY();
        double distZ = cartCoord.getX() - otherCartCoord.getZ();

        double distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2) + Math.pow(distZ, 2));

        return distance;


    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {

        assertClassInvariants();
        assertIsNotNull(coordinate);
        

        SphericCoordinate sphericCoord = this.asSphericCoordinate();
        SphericCoordinate otherSphericCoord = coordinate.asSphericCoordinate();

        double centralAngle = doGetCentralAngle(sphericCoord, otherSphericCoord);

        assertIsNumber(centralAngle);
        assertClassInvariants();

        return centralAngle;

        
    }

    private double doGetCentralAngle(SphericCoordinate sphericCoord, SphericCoordinate otherSphericCoord) {

        double phi1 = sphericCoord.getPhi();
        double phi2 = otherSphericCoord.getPhi();

        double theta1 = sphericCoord.getTheta();
        double theta2 = otherSphericCoord.getTheta();

        double centralAngle = Math.acos(Math.sin(phi1) * Math.sin(phi2) + Math.cos(phi1) * Math.cos(phi2) * Math.cos(Math.abs(theta1 - theta2)));

        return centralAngle;

    }


    public boolean isEqual(Coordinate coordinate) {

        assertIsNotNull(this);
        assertIsNotNull(coordinate);

        CartesianCoordinate cartCoord = this.asCartesianCoordinate();
        CartesianCoordinate otherCartCoord = coordinate.asCartesianCoordinate();

        double delta = cartCoord.getCartesianDistance(otherCartCoord);

        if (cartCoord == otherCartCoord) {

            return true;

        }

        if (delta <= EPSILON) { 

            return true;
    

        } else {

            return Math.abs(cartCoord.getX() - otherCartCoord.getX()) <= EPSILON
            && Math.abs(cartCoord.getY() - otherCartCoord.getY()) <= EPSILON 
            && Math.abs(cartCoord.getZ() - otherCartCoord.getZ()) <= EPSILON;

        }

    }

    @Override
    public boolean equals(Object object) {



        if ((object == null) || !( object instanceof Coordinate)) {

            return false;

        }

        Coordinate coordinate = (Coordinate) object;

        return isEqual(coordinate);

    }

    

}
