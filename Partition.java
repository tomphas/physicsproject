import java.util.ArrayList;


public class Partition{
    ArrayList<Body> bodies = new ArrayList<Body>();
    
    public Partition(Body... b){
	for(Body bod: b){
	    bodies.add(bod);
	}
	
	
    }


    public void computerForces(){
	for(int i = 0; i < bodies.size(); i++){
	    for(int j = 0; j < bodies.size(); i++){
		bodies.get(i).addForceFrom(bodies.get(j));
	    }
	}
    }
}

