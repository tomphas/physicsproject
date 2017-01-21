import static java.lang.Math.*;

/**
 * Class for representing two dimensional circular bodies for
 * physics simulations and collision
 * @author Anthony Ghatas
 * @version 1.0
 */
public class ColBody implements Body{

    double xCoord;
    double yCoord;
    double xVelocity;
    double yVelocity;
    double mass;
    double radius;
    int r;
    int g;
    int b;
    double xForce;
    double yForce;
    double xVelDelta;
    double yVelDelta;

    /**
     * Constructor for ColBody
     */
    public ColBody(double xc, double yc, double xv, double yv, double m,double rad,  int rI, int gI, int bI){
	xCoord = xc;
        yCoord = yc;
        xVelocity = xv;
        yVelocity = yv;
        mass = m;
	radius = rad;
        r = rI;
        g = gI;
        b = bI;
	xForce = 0;
	yForce = 0;
	xVelDelta = 0;
	yVelDelta = 0;
    }

    
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
    

    public double getMass(){
	return mass;
    }


    public double getRadius(){
	return radius;
    }


    public int[] getRGB(){
	int[] colors = new int[3];
	colors[0] = r;
	colors[1] = g;
	colors[2] = b;
	return colors;
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

    public boolean isTouching(Body otherBody){
	double distance = (this.findDistance(otherBody));
	double sum = this.getRadius() + otherBody.getRadius();
	return distance <= sum;
    }


    public boolean isMovingTowardsEachother(Body otherBody){
	double posXDelta = otherBody.getXCoord() - this.getXCoord();
	double velXDelta = otherBody.getXVel() - this.getXVel();
	double posYDelta = otherBody.getYCoord() - this.getYCoord();
	double velYDelta = otherBody.getYVel() - this.getYVel();
	return ((posXDelta*velXDelta)+(posYDelta*velYDelta) < 0);
	
    }
    public boolean isColliding(Body otherBody){
	return this.isTouching(otherBody)
	    && (this.isMovingTowardsEachother(otherBody));
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
	if(this.isColliding(otherBody)){
	    this.addCollisionForce(otherBody);
	}
	
    }
    public double getXCollisionForce(Body otherBody){
	double mass1 = this.getMass();
	double mass2 = otherBody.getMass();
	double xPos1 = this.getXCoord();
	double xPos2 = otherBody.getXCoord();
	double yPos1 = this.getYCoord();
	double yPos2 = otherBody.getYCoord();
	double xVel1 = this.getXVel();
	double xVel2 = otherBody.getXVel();
	double yVel1 = this.getYVel();
	double yVel2 = otherBody.getYVel();
	double velChange =
	    ((2*mass2)/(mass1+mass2))
	    *(xPos2-xPos1)
	    *(
	      (((xPos2-xPos1)*(xVel2-xVel1))+((yPos2-yPos1)*(yVel2-yVel1)))
	      /
	      (pow((xPos2-xPos1),2)+pow((yPos2-yPos1), 2))
	      );
	return velChange;
    }

    public double getYCollisionForce(Body otherBody){
	double mass1 = this.getMass();
	double mass2 = otherBody.getMass();
	double xPos1 = this.getXCoord();
	double xPos2 = otherBody.getXCoord();
	double yPos1 = this.getYCoord();
	double yPos2 = otherBody.getYCoord();
	double xVel1 = this.getXVel();
	double xVel2 = otherBody.getXVel();
	double yVel1 = this.getYVel();
	double yVel2 = otherBody.getYVel();
	double velChange =
	    ((2*mass2)/(mass1+mass2))
	    *(yPos2-yPos1)
	    *(
	      (((xPos2-xPos1)*(xVel2-xVel1))+((yPos2-yPos1)*(yVel2-yVel1)))
	      /
	      (pow((xPos2-xPos1),2)+pow((yPos2-yPos1), 2))
	      );
	return velChange;
    }

    public void addCollisionForce(Body otherBody){
	if(this.isColliding(otherBody)){
	    xVelDelta = this.getXCollisionForce(otherBody);
	    yVelDelta = this.getYCollisionForce(otherBody);
	}
    }
    

    public double getXForce(){
	return xForce;
    }


    public double getYForce(){
	return yForce;
    }

    
    public double getXVelDelta(){
	return xVelDelta;
    }
    
    
    public double getYVelDelta(){
	return yVelDelta;
    }

    
    public void move(double time){
	double xAccel = xForce/mass;
	double yAccel = yForce/mass;
	xVelocity = xVelocity + time*xAccel;
	yVelocity = yVelocity + time*yAccel;
	xVelocity += xVelDelta;
	yVelocity += yVelDelta;
	xCoord += xVelocity*time;
	yCoord += yVelocity*time;
	xVelDelta = 0;
	yVelDelta = 0;
	xForce = 0;
	yForce = 0;
    }
}
