package brjt23.chs.wumpus.cmd.factory;

import brjt23.chs.wumpus.cmd.ArrowCommand;
import brjt23.chs.wumpus.cmd.GoCommand;
import brjt23.chs.wumpus.cmd.ICommand;
import brjt23.chs.wumpus.cmd.LeaveCommand;
import brjt23.chs.wumpus.cmd.QuitCommand;
import brjt23.chs.wumpus.cmd.TurnCommand;
import brjt23.chs.wumpus.exceptions.WumpusGameException;
import brjt23.chs.wumpus.exceptions.errors.InvalidCommandException;
import brjt23.chs.wumpus.hunter.SimpleHunter;
import brjt23.chs.wumpus.utils.Messages;

/**
 * Creates console commands for the wumpus game
 * @author Borja
 *
 */
public class ConsoleCommandFactory implements ICommandFactory{

	/**
	 * {@inheritDoc}
	 * @throws WumpusGameException 
	 */
	@Override
	public ICommand create(String name) throws WumpusGameException {
		switch (name.toLowerCase()) {
		case "g":
			// go
			return new GoCommand();
		case "r":
			//turn right
			return new TurnCommand(SimpleHunter.RIGHT_TURN);
		case "l":
			//turn left
			return new TurnCommand(SimpleHunter.LEFT_TURN);
		case "a":
			//use an arrow
			return new ArrowCommand();
		case "f":
			return new LeaveCommand();
		case "q":
			//quit the game
			return new QuitCommand();
		default:
			throw new InvalidCommandException(Messages.COMMAND_NOT_VALID);
		}		
		
	}

	
}
