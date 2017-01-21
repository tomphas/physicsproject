import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static java.lang.Math.*;

public class TestColBody{

    @Test
	public void testGetXCoord(){
	ColBody cb = new ColBody(2.3987, 0, 0, 0, 0, 0, 0, 0, 0);
	double delta = 0.00001;

	assertEquals(2.3987, cb.getXCoord(), delta);
    }

    @Test
	public void testGetYCoord(){
	ColBody cb = new ColBody(0, 5.9765, 0, 0, 0, 0, 0, 0, 0);
	double delta = 0.00001;

	assertEquals(5.9765, cb.getYCoord(), delta);
	
    }
    
    @Test
	public void testGetXVel(){
	ColBody cb = new ColBody(0, 0, 1.5E-22, 0, 0, 0, 0, 0, 0);
	double delta = 0.000000000000000000000000000000000001;

	assertEquals(1.5E-22, cb.getXVel(), delta);
	
    }
    
    @Test
	public void testGetYVel(){
	ColBody cb = new ColBody(0, 0, 0, 2.34E-3, 0, 0, 0, 0, 0);
	double delta = 0.00001;

	assertEquals(2.34E-3, cb.getYVel(), delta);
	
    }
    
    @Test
	public void testGetMass(){
	ColBody cb = new ColBody(0, 0, 0, 0, 2497, 0, 0, 0, 0);
	double delta = 0.00001;

	assertEquals(2497, cb.getMass(), delta);
	
    }
    
    @Test
	public void testGetRadius(){
	ColBody cb = new ColBody(0, 0, 0, 0, 0, 6931, 0, 0, 0);
	double delta = 0.00001;

	assertEquals(6931, cb.getRadius(), delta);
	
    }
    
    @Test
	public void testGetRGB(){
	ColBody cb = new ColBody(0, 0, 0, 0, 0, 0, 67, 93, 144);
	double delta = 0.00001;
	int[] rgb = {67, 93, 144};
        int r = 67;
        int g = 93;
        int b = 144;
        //int[] test = gb.getRGB();
        assertArrayEquals(rgb, cb.getRGB());
	
    }

    @Test
	public void testIsTouching(){
	ColBody b1 = new ColBody(0.0, 0.0, 0.5, 0.5, 40.0, 4.0, 255, 0, 0);
	ColBody b2 = new ColBody(0.0, 90.0, 0.5, -2.0, 10.0, 3.0, 0, 0, 255);
	assertEquals(false, b1.isTouching(b2));
	assertEquals(false, b2.isTouching(b1));

	b1 = new ColBody(4, 4, 0, 0, 0, 3, 0, 0, 0);
	b2 = new ColBody(-4, -4, 0, 0, 0, 3, 0, 0, 0);
	assertEquals(false, b1.isTouching(b2));
	assertEquals(false, b2.isTouching(b1));
    }
    
    @Test
	public void testIsMovingTowardsEachother(){
	ColBody b1 = new ColBody(0.0, 0.0, 0.5, 0.5, 40.0, 4.0, 255, 0, 0);
	ColBody b2 = new ColBody(0.0, 90.0, 0.5, -2.0, 10.0, 3.0, 0, 0, 255);
	assertEquals(true, b1.isMovingTowardsEachother(b2));
	assertEquals(true, b2.isMovingTowardsEachother(b1));

	b1 = new ColBody(0, 0, -1, -1, 0, 0, 0, 0, 0);
	b2 = new ColBody(5, 5, 1, 1, 0, 0, 0, 0, 0);
	assertEquals(false, b1.isMovingTowardsEachother(b2));
	assertEquals(false, b2.isMovingTowardsEachother(b1));
	
    }
    
    @Test 
	public void testAddForceFrom(){
	ColBody poolBall = new ColBody(0, 0, -20, 0, 0.16, 2, 23, 45, 67);
	ColBody bowlingBall = new ColBody(0, -3, 10, 0, 4, 6, 23, 45, 67);
	double delta = 1E-10;
	
    }

    @Test 
	public void testIsColliding(){
	ColBody bod1 = new ColBody(0, 0, 0, 0, 0, 0, 0, 0, 0);
	ColBody bod2 = new ColBody(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    

}
