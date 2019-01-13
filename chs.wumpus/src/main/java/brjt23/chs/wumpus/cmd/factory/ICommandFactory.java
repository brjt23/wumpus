package brjt23.chs.wumpus.cmd.factory;

import brjt23.chs.wumpus.cmd.ICommand;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Factory to create commands
 * @author Borja
 *
 */
public interface ICommandFactory {

	/**
	 * Creates a command using its name
	 * @param name name of the command
	 * @return the command
	 * @throws WumpusGameException when command cannot be created
	 */
	public ICommand create(String name) throws WumpusGameException;
}
