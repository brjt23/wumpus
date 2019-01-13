package brjt23.chs.wumpusevents.statics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import brjt23.chs.wumpus.events.statics.HoleEvent;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Tests the holeEventTest
 * @author Borja
 *
 */
public class HoleEventTest {

	@Test
	public void executeTest() {
		try {
			new HoleEvent().execute();
		} catch (WumpusGameException e) {
			assertEquals("GAME OVER. You have fallen into a hole.", e.getMessage());
		}
	}
}
