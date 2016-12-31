/**
 * Abstract class for reading in a file of two dimensional circular bodies for
 * physics simulations. Sub-classes just need to implement a constructor
 * that reads from an input source and initializes the protected instance
 * variables.
 * @author Sean Stern
 * @version 1.0
 */
public abstract class UniverseReader{

    protected double universeRadius;
    protected Body[] bodies;

    /**
     * Returns an array of {@link Body} objects based on an input file.
     *
     * @return an array of {@link Body} objects.
     */
    public Body[] getBodies(){
	return bodies;
    }

    /**
     * Returns the radius of the universe that {@link Body} objects will
     * occupy. The radius of the universe is defined as the minimum distnace
     * from the center to an edge. For example, the universe below with a
     * center at the period (.) has a radius of 2:
     * 
     *  _ _ _ _
     * |       |
     * |   ._ _| <--Example (square) universe with radius 2
     * |       |
     * |_ _ _ _|
     *
     *
     * @return the radius of the universe
     */
    public double getUniverseRadius(){
	return universeRadius;
    } 
}