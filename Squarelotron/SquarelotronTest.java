import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {
	
	Squarelotron mySq = new Squarelotron(3);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSquarelotron() {
		assert(mySq.size == 3);
	}

	@Test
	public void testUpsideDownFlip() {
		int t[][] = {{7,8,9}, {4,5,6}, {1,2,3}};
		Squarelotron s = new Squarelotron(mySq.size);
		s.squarelotron = t;
		assertEquals(mySq.upsideDownFlip(1), s);
		
	}

	@Test
	public void testMainDiagonalFlip() {
		int t[][] = {{1,4,7}, {2,5,8}, {3,6,9}};
		Squarelotron s = new Squarelotron(mySq.size);
		s.squarelotron = t;
		assertEquals(mySq.mainDiagonalFlip(1), s);
	}

	@Test
	public void testRotateRight() {
		int t[][] = {{7,4,1}, {8,5,2}, {9,6,3}};
		Squarelotron s = new Squarelotron(mySq.size);
		s.squarelotron = t;
		mySq.rotateRight(1);
		assertEquals(mySq, s);
	}

}
