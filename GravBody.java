import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.*;

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
    //double xAccel;
    //double yAccel;
    double xForce;
    double yForce;
    // TODO: Add a constructor to initialize instance variables
    public GravBody(double xc, double yc, double xv, double yv, double m, int rI, int gI, int bI){
	xCoord = xc;
	yCoord = yc;
	xVelocity = xv;
	yVelocity = yv;
	mass = m;
	r = rI;
	g = gI;
	b = bI;
	xForce = 0;
	yForce = 0;
    }


    // TODO: Implement all methods to satisfy interface
    public double getXCoord(){
	return xCoord;
    }
    

    public double getYCoord(){
	return yCoord;
    }

    
    public double getXVel(){
	return xVelocity;
    }


    public double getYVel(){
	return yVelocity;
    }


    public double getRadius(){
	return 10000;
    }


    public int[] getRGB(){
	int[] rgb = new int[3];
	rgb[0] = r;
	rgb[1] = g;
	rgb[2] = b;
	return rgb;
    }


    public double getMass(){
	return mass;
    }


    public double findDistance(Body otherBody){
	return sqrt(pow(this.getYCoord()-otherBody.getYCoord(), 2)
		    +pow(this.getXCoord()- otherBody.getXCoord(), 2));
    }


    public double findXDistance(Body otherBody){
	return abs(xCoord - otherBody.getXCoord());
    }


    public double findYDistance(Body otherBody){
	return abs(yCoord - otherBody.getYCoord());
    }


    public double findTheta(Body otherBody){
	if(this.findXDistance(otherBody) == 0){
	    return 0;
	}
	else if(this.findYDistance(otherBody) == 0){
	    return 0;
	}
	else{
	    return atan(this.findYDistance(otherBody)/this.findXDistance(otherBody));
       }  
    }


    public double getForceFrom(Body otherBody){
	return ((6.67E-11)*this.getMass()*otherBody.getMass())/
	    (pow(this.findDistance(otherBody), 2));
    }


    public void addForceFrom(Body otherBody){
	if(this.xCoord < otherBody.getXCoord()){
	    xForce += cos(this.findTheta(otherBody))
		*this.getForceFrom(otherBody);
	    }
	else{
	    xForce -= cos(this.findTheta(otherBody))
		*this.getForceFrom(otherBody);
	    }
	if(this.yCoord < otherBody.getYCoord()){
		yForce += sin(this.findTheta(otherBody))
		    *this.getForceFrom(otherBody);
	    }
	else{
	    yForce -= sin(this.findTheta(otherBody))
		*this.getForceFrom(otherBody);
	    }
    }


    public double getXForce(){
	return xForce;
    }


    public double getYForce(){
	return yForce;
    }


    public void move(double time){
	double xAccel = xForce/mass;
	double yAccel = yForce/mass;
	xVelocity = xVelocity + time*xAccel;
	yVelocity = yVelocity + time*yAccel;
	xCoord += xVelocity*time;
	yCoord += yVelocity*time;
	xForce = 0;
	yForce = 0;
    }
    public void addCollisionForce(Body otherBody){

    }
    // TODO: Implment any additional methods for testing (i.e. methods
    // not listed on the Body interface). Look at TestGravBody for ideas
    // of helper methods you might need.
}
