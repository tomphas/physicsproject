import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
/**
 * Class for representating two dimensional circular bodies for
 * physics simulations
 * @author Sean Stern
 * @version 1.0
 */
public class GravBody implements Body{

    // TODO: Add appropriate instance variables
    double xCoord;
    double yCoord;
    double xVelocity;
    double yVelocity;
    double mass;
    int r;
    int g;
    int b;
    double force;
    // TODO: Add a constructor to initialize instance variables
    public GravBody(double xc, double yc, double xv, double yv, double m, int rI, int gI, int bI)
    {
	xCoord = xc;
	yCoord = yc;
	xVelocity = xv;
	yVelocity = yv;
	mass = m;
	r = rI;
	g = gI;
	b = bI;
	force = 0;
    }
    // TODO: Implement all methods to satisfy interface
    public double getXCoord()
    {
	return xCoord;
    }

    public double getYCoord()
    {
	return yCoord;
    }

    public double getXVel()
    {
	return xVelocity;
    }
    public double getYVel()
    {
	return yVelocity;
    }
    public double getRadius()
    {
	return 0;
    }
    public int[] getRGB()
    {
	int[] rgb = new int[3];
	rgb[0] = r;
	rgb[1] = g;
	rgb[2] = b;
	return rgb;
    }
    public double getMass()
    {
	return mass;
    }
    public double findDistance(Body otherBody)
    {
	return sqrt(pow(this.getYCoord()-otherBody.getYCoord(), 2)
		    +pow(this.getXCoord()- otherBody.getXCoord(), 2));
    }
    public double getForceFrom(Body otherBody)
    {
	return ((6.67*pow(10, -11))*this.getMass()*otherBody.getMass())/
	    (pow(this.findDistance(otherBody), 2));
    }
    public void addForceFrom(Body otherBody)
    {
	force = ((6.67*pow(10, -11))*this.getMass()*otherBody.getMass())/
	    (pow(this.findDistance(otherBody), 2));
    }
    public void move(double time)
    {
	int xForce = 
    }
    // TODO: Implment any additional methods for testing (i.e. methods
    // not listed on the Body interface). Look at TestGravBody for ideas
    // of helper methods you might need.
}
