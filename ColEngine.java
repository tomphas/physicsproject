public class ColEngine extends PhysicsEngine{
    public ColEngine(Body[] cBodies, double timeDelta, double universeRadius, int bgRed, int bgBlue, int bgGreen){
	super(cBodies, timeDelta, universeRadius, bgRed, bgBlue, bgGreen);
    }

    protected void computeForces(){
	for(int i = 0; i < cBodies.length; i++){
	    for(int j = 0; j < cBodies.length; j++){
		if(j!=i){
		    cBodies[i].addForceFrom(cBodies[j]);
		}
		//cBodies[j].addForceFrom(cBodies[i]);
	    }
	}
    }
}
