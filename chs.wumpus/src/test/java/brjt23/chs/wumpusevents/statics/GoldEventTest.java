package brjt23.chs.wumpusevents.statics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import brjt23.chs.wumpus.events.statics.GoldEvent;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Tests the execution of the GoldEvent
 * @author Borja
 *
 */
public class GoldEventTest {

	@Test
	public void executeTest() {
		try {
			new GoldEvent().execute();
		} catch (WumpusGameException e) {
			String expected = "CONGRATS!!! You have found the gold.";
			assertEquals(expected, e.getMessage());
		}
	}
}
