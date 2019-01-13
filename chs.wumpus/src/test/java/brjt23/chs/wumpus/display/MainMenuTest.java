package brjt23.chs.wumpus.display;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brjt23.chs.wumpus.utils.diplay.MainMenu;
import brjt23.chs.wumpus.utils.diplay.WelcomeMenu;

/**
 * Test the display of he menu is right
 * @author Borja
 *
 */
public class MainMenuTest {
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
		new MainMenu().display();
		String expected = "Select the next action you wanna do:" 
				+ System.getProperty("line.separator") 
				+"- g: Go forward." 
				+ System.getProperty("line.separator")
				+ "- l: Turn 90º to the left" 
				+ System.getProperty("line.separator")
				+ "- r: Turn 90º to the right" 
				+ System.getProperty("line.separator")
				+ "- a: Use an arrow" 
				+ System.getProperty("line.separator")
				+ "- f: Leave the dungeon"
				+ System.getProperty("line.separator")
				+ "- q: Quit the game" 
				+ System.getProperty("line.separator");
		assertEquals(expected, outContent.toString());
	}
	
}
