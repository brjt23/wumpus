package brjt23.chs.wumpus.hunter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import brjt23.chs.wumpus.board.Position;
import brjt23.chs.wumpus.exceptions.NoArrowsException;
import brjt23.chs.wumpus.exceptions.WumpusGameException;


/**
 * Class to test the functionality of the simple hunter.
 * Try to finds what happens on the right functionality and against unexpected actions.
 * Testes:
 * - go(): used to move around the board
 * - shoot(): used to try to kill the wumpus
 * - turn(): used to change the orientation.
 * 
 * Position is not been mocked cause it's quite simple and it already has tests.
 * 
 * @author Borja
 *
 */
public class SimpleHunterTest {

	/**
	 * Tests that the hunter can go to any orientation.
	 */
	@Test
	public void goTest() {
		IHunter hunter = new SimpleHunter(0);
		// turn right to -90 and go to (0,-1)
		Position expected0 = new Position(0,-1);
		hunter.turn(SimpleHunter.RIGHT_TURN);
		hunter.go();
		assertEquals(expected0, hunter.getPosition());
		
		// turn left to 0 and go to (1,-1)
		Position expected1 = new Position(1, -1);
		hunter.turn(SimpleHunter.LEFT_TURN);
		hunter.go();
		assertEquals(expected1, hunter.getPosition());
		
		// turn left to 90 and go to (1,0)
		Position expected2 = new Position(1,0);
		hunter.turn(SimpleHunter.LEFT_TURN);
		hunter.go();
		assertEquals(expected2, hunter.getPosition());
		
		// turn left to 180 and go to (0,0)
		Position expected3 = new Position(0,0);
		hunter.turn(SimpleHunter.LEFT_TURN);
		hunter.go();
		assertEquals(expected3, hunter.getPosition());
	}
	
	/**
	 * Test that the hunter can turn only to any orientation allowed
	 */
	@Test
	public void turnTest() {
		IHunter hunter = new SimpleHunter(0);
		
		// go to 90
		hunter.turn(SimpleHunter.LEFT_TURN);
		
		assertTrue(Math.PI/2 == hunter.getOrientation());
		
		// turn to -90
		hunter.turn(-1*Math.PI);
		
		assertTrue(Math.PI / -2 == hunter.getOrientation());
		
		// can turn if x%90 != 0
		try {
			hunter.turn(Math.toRadians(135));
			assertFalse(true);
		}catch(IllegalArgumentException e) {
			assertTrue(true);
			
		}
		
		// check scale()
		// negative value
		hunter.turn((-2*Math.PI));// makes 5 turns but remains at the same orientation
		assertTrue((Math.PI / -2) == hunter.getOrientation());//same than -90, but since is adding to scale it gets positive
		//positive value
		hunter.turn(2*SimpleHunter.LEFT_TURN);// go to 90
		hunter.turn(-1*(2*Math.PI));// makes 5 turns but remains at the same orientation
		assertTrue((3*Math.PI / -2) == hunter.getOrientation());
		
		
		
	}
	
	/**
	 * Tests that the hunter can only use am arrow while arrows are still remaining
	 * @throws WumpusGameException 
	 */
	@Test(expected = NoArrowsException.class)
	public void arrowTest() throws WumpusGameException {
		IHunter hunter = new SimpleHunter(0);
		
		hunter.shoot();
	}
	
	
}
