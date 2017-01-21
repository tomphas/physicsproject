public class ColUniverseReader extends UniverseReader{
    private int numBods;
    private String[] bodiesStr;
    private Body[] cBodies;

    public ColUniverseReader(String fileName){
	In input = new In(fileName);
	numBods = input.readInt();
	universeRadius = input.readDouble();
	bodies = new Body[numBods];
	for(int i = 0; i < numBods; i++){
	    bodies[i] = new ColBody
		(input.readDouble(), input.readDouble(), input.readDouble(),
		 input.readDouble(), input.readDouble(), input.readDouble(),
		 input.readInt(), input.readInt(), input.readInt());  
	}
    }
    public int getNumBod(){
	return numBods;
    }
    /* public ColBody[] getCBodies(){
	return cBodies;
	}*/

    public static void main(String[] args){
	ColUniverseReader CR = new ColUniverseReader("coltest0.txt");
	Body[] test = CR.getBodies();
	System.out.println(CR.getNumBod());
	System.out.println(CR.getUniverseRadius());
	//System.out.println(test[0].getXCoord());
	System.out.println(test[7].getXCoord());
	System.out.println(test[6].getYVel());
    }
    
}
