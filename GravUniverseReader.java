/**
 * Class for reading in a file of two dimensional circular bodies for
 * gravity simulations.
 * @author Sean Stern
 * @version 1.0
 */
public class GravUniverseReader extends UniverseReader{
    private int numBods;
    private String[] bodiesStr;
    /**
     * Reads a gravitational simulation universe from a file.
     *
     * @param fileName the file that contains the gravity simulation data in
     *        the following format:
     *
     * [integer n representing number of bodies in universe]\n
     * [real number r representing the radius of the universe]\n
     * [real number x-coordinate of body]
     * [real number y-coordinate of body]
     * [real number x-velocity of body] 
     * [real number y-velocity of body]
     * [real number mass of body]
     * [integer red-value using 0-255 RGB color scale]
     * [integer green-value using 0-255 RGB color scale]
     * [integer blue-value using 0-255 RGB color scale]\n
     */ 
    public GravUniverseReader(String fileName){
	In input = new In(fileName);

	// TODO: Read in data from file according to format
	
	// TODO: Initialize parent class's protected instance variables
	// with data read from file
	numBods = input.readInt();
	universeRadius = input.readDouble();
	bodies = new Body[numBods];
	//bodiesStr = input.readLine();
	for(int i = 0; i < numBods; i++)
	    {
		bodies[i] = new GravBody(input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(), input.readInt(), input.readInt(), input.readInt());
	    }
    }

    public int  getNumBods()
    {
	return numBods;
    }
    /* public String[] getBodiesStr()
    {
	return bodiesStr;
	}*/
    public static void main(String[] args){
	// TODO: Write simple test of GravUniverseReader here by
	// constructing a GravUniverseReader object and calling
	// the two inherited methods on the GravUniverseReader object.
        // Then print out the information returned from these methods
	// to verify that they worked correctly.
	GravUniverseReader UR = new GravUniverseReader("planets.txt");
	Body[] test = UR.getBodies();
	System.out.println(test[1].getXCoord());
	System.out.println(test[0].getXCoord());
	System.out.println(test[2].getXCoord());
	System.out.println(UR.getNumBods());
	System.out.println(UR.getUniverseRadius());
	//String[] bods = UR.getBodiesStr();
	//System.out.println(bods[1]);
    }
}
