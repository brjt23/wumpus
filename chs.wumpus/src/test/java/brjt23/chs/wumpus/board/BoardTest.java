package brjt23.chs.wumpus.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import brjt23.chs.wumpus.exceptions.errors.WrongBoardDefinitionException;
import brjt23.chs.wumpus.utils.Messages;

/**
 * Test the Board. 
 * The most important is control its creation so it has enough cells 
 * to locate the gold, the player, the wumpus and the holes.
 * @author Borja
 *
 */
public class BoardTest {

	// Control creation
	@Test
	public void creationTest() {
		// Not enough for basic items
		try {
			new Board(1, 1, 0);
		} catch (WrongBoardDefinitionException e) {
			assertEquals(Messages.SMALL_BOARD + 4, e.getMessage());
			
		}
		
		// More holes than available cells
		try {
			new Board(4,4, 16); 
		} catch (WrongBoardDefinitionException e) {
			assertEquals(Messages.MANY_HOLES, e.getMessage());
		}
	}
	
}
