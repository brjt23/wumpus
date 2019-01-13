package brjt23.chs.wumpus.display;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brjt23.chs.wumpus.utils.diplay.WelcomeMenu;

/**
 * Tests hte content of the welcome test is correct
 * @author Borja
 *
 */
public class WelcomeMenuTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	 
	}
	
	@Test
	public void displayTest() {
		new WelcomeMenu().display();
		String expected = "WELCOME TO THE WUMPUS GAME." + System.getProperty("line.separator") + 
				"Try to find the gold and leave the dungeon. But be aware of the Wumpus or to fall at any hole" 
				+ System.getProperty("line.separator");
		assertEquals(expected, outContent.toString());
	}
	
}
