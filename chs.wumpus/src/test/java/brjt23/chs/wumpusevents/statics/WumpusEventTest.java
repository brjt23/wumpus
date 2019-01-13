package brjt23.chs.wumpusevents.statics;

import static org.junit.Assert.assertEquals;

import brjt23.chs.wumpus.events.statics.WumpusEvent;
import brjt23.chs.wumpus.exceptions.GameOverException;

/**
 * Tests the wumpus event
 * @author Borja
 *
 */
public class WumpusEventTest {

	public void executeTes() {
		try {
			new WumpusEvent().execute();
		} catch (GameOverException e) {
			assertEquals("GAME OVER. You got killed by the Wumpus.", e.getMessage());
		}
	}
}
