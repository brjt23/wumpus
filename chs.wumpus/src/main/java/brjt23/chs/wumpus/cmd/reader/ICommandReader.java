package brjt23.chs.wumpus.cmd.reader;

import brjt23.chs.wumpus.cmd.ICommand;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Interface to read commands
 * @author Borja
 *
 */
public interface ICommandReader {

	/**
	 * 
	 * @return an instance of the read command
	 * @throws WumpusGameException 
	 */
	public ICommand read() throws WumpusGameException;
}
