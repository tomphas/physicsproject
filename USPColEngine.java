import static java.lang.Math.*;

public class USPColEngine extends PhysicsEngine{
    public USPColEngine(Body[] cBodies, double timeDelta, double universeRadius, int bgRed, int bgBlue, int bgGreen){
	super(cBodies, timeDelta, universeRadius, bgRed, bgBlue, bgGreen);
    }
    int numBods = cBodies.length;
    double numParts = pow((ceil(sqrt(numBods))),2);
    int partsSqrt = sqrt(numParts);
    public void makePartitions(){
	int numBodsInPart;
	int checkXCoord;
	int checkYCoord;
	for(int i = 0; i < numParts; i++){
	    checkXCoord = 
	}
	
    }

    
    protected void computeForces(){
 	
	
    }
}
