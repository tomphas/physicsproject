import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TestGravBody {
    
    @Test
    public void testGetXCoord() {
	GravBody gb = new GravBody( 2.3987, 0, 0, 0, 0, 0, 0, 0);

	// It is NEVER a good idea to check if floating point numbers are
        // ==. To represent floating point numbers using binary, the
	// computer must ROUND when it does math. 
	// For example, System.out.println(0.7 + 0.1 == 0.9 - 0.1);
	// will print false.
	//
	// Instead, it's a good idea to see if floating point numbers are
	// really really CLOSE. So we need to specify how close they should
        // be to basically count as equal. That's this number below:
	double delta = 0.00001;

	assertEquals(2.3987, gb.getXCoord(), delta);
    }


    @Test
    public void testGetYCoord() {
	GravBody gb = new GravBody(0, 3.5555, 0, 0, 0, 0, 0, 0);

	double delta = 0.00001;

	// TODO: assert that gb.getYCoord() returns the y-value you picked in
	// the constructor. This is exactly like testGetXCoord() above.

	assertEquals(3.5555, gb.getYCoord(), delta);
    }

    // TODO: Add a test for getXVel
    @Test
    public void testGetXVel()
    {
	GravBody gb = new GravBody(0, 0, 2.345, 0, 0, 0, 0, 0);
	double delta = 0.00001;
	assertEquals(2.345, gb.getXVel(), delta);
    }
    // TODO: Add a test for getYVel
    @Test
    public void testGetYVel()
    {
	GravBody gb = new GravBody(0, 0, 0, 6.66, 0, 0, 0, 0);
	double delta = 0.00001;
	assertEquals(6.66, gb.getYVel(), delta);
    }

    // TODO: Add a test for getRadius
    @Test
    public void testGetRadius()
    {
	GravBody gb = new GravBody(0, 0, 0, 0, 5, 0, 0, 0);
	double delta = 0.00001;
	assertEquals(0, gb.getRadius(), delta);
    }

    // TODO: Add a test for getRGB
    @Test
    public void testGetRBG()
    {
	GravBody gb = new GravBody(0, 0, 0, 0, 0, 67, 93, 144);
	double delta = 0.00001;
	int[] rgb = {67, 93, 144};
	int r = 67;
	int g = 93;
	int b = 144;
	int[] test = gb.getRGB();
	assertArrayEquals(rgb, gb.getRGB());
    }
    // TODO: Add a test for getMass
    @Test
    public void testGetMass()
    {
	GravBody gb = new GravBody(0, 0, 0, 0, 5, 0, 0, 0);
	double delta = 0.00001;
	assertEquals(5, gb.getMass(), delta);
    }
    @Test
    public void testFindDistance()
    {
	GravBody gbA = new GravBody(0, 2, 0, 0, 0, 0, 0, 0);
	GravBody gbB = new GravBody(0, 5, 0, 0, 0, 0, 0, 0);
	double delta = 0.00001;
	assertEquals(3, gbA.findDistance(gbB), delta);
    }

    @Test
    public void testAddForceFrom(){
	// HINT: The physics coursework/homework you did is helpful here

	GravBody gbA = new GravBody(0, 2, 0, 0, 5, 0, 0, 0);
	GravBody gbB = new GravBody(0, 5, 0, 0, 4, 0, 0, 0);
	GravBody gbC = new GravBody(0, 7, 0, 0, 6, 0, 0, 0);
	double delta = 0.0000000000001;

	// TODO: Assert that the x and y component of force on gbA are 0
	// HINT: There's no method on the Body to get the forces--but gbA is
	// a GravBody. So you can add methods to gravBody that isnt' on the
	// interface to get the forces you need solely for testing purposes.

	assertEquals(0, gbA.getXForce(), delta);
	assertEquals(0, gbA.getYForce(), delta);

	// TODO: Assert that the x and y components of force on gbA are correct
	gbA.addForceFrom(gbB);
	gbA.addForceFrom(gbC);
	assertEquals(2.283512E-10, gbA.getXForce(), delta);
	assertEquals(0, gbA.getYForce(), delta);
	
	// TODO: Assert that the x and y components of force on gbB are 0

	// TODO: Assert that x and y components of force on gbB are correct

	
	// TODO: Write test ensuring that forces can be calculated correctly
	// for gbC
	// HINT: It's the same as the last two test cases you wrote.
    }

    @Test
    public void testMove(){
	// HINT: The physics coursework/homework you did her is helpful.

	// TODO: Create 3 GravBody objects
	GravBody gbA = new GravBody(0, 2, 0, 0, 5, 0, 0, 0);
	GravBody gbB = new GravBody(0, 5, 0, 0, 4, 0, 0, 0);
	GravBody gbC = new GravBody(0, 7, 0, 0, 6, 0, 0, 0);
	double delta = 0.00000000000000000000000000001;
	// TODO: For each GravBody object, add force from other two
	gbA.addForceFrom(gbB);
	gbA.addForceFrom(gbC);
	// TODO: Move each GravBody object for some time delta
	gbA.move(1);
	// TODO: For each GravBody object, assert that new x and y coordinates
	// are correct after movement
	assertEquals(4.567024E-11, gbA.getXCoord(), delta);
	// TODO: For each GravBody object, assert that x and y components of
	// force are now 0

	
	// TODO: Repeat the above process on the same 3 GravBody objects once
	// more.
    }

    
}
