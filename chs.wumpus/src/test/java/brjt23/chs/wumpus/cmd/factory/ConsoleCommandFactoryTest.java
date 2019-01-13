package brjt23.chs.wumpus.cmd.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import brjt23.chs.wumpus.cmd.ArrowCommand;
import brjt23.chs.wumpus.cmd.GoCommand;
import brjt23.chs.wumpus.cmd.LeaveCommand;
import brjt23.chs.wumpus.cmd.QuitCommand;
import brjt23.chs.wumpus.cmd.TurnCommand;
import brjt23.chs.wumpus.exceptions.WumpusGameException;
import brjt23.chs.wumpus.exceptions.errors.InvalidCommandException;

/**
 * Tests that the factory is properly working.
 * It creates the right command, acts properly when command not found,
 * accepts command in both upper and lower case
 * @author Borja
 *
 */
public class ConsoleCommandFactoryTest {

	
	@Test(expected = InvalidCommandException.class)
	public void createTest() throws WumpusGameException {
		ICommandFactory factory = new ConsoleCommandFactory();
		
		assertTrue(factory.create("G") instanceof GoCommand);
		assertTrue(factory.create("r") instanceof TurnCommand);
		assertTrue(factory.create("l") instanceof TurnCommand);
		assertTrue(factory.create("A") instanceof ArrowCommand);
		assertTrue(factory.create("f") instanceof LeaveCommand);
		assertTrue(factory.create("q") instanceof QuitCommand);
		assertTrue(factory.create("GuAu") instanceof GoCommand);
	}
}
