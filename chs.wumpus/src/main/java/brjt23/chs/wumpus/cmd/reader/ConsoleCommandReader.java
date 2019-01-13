package brjt23.chs.wumpus.cmd.reader;

import java.util.Scanner;

import brjt23.chs.wumpus.cmd.ICommand;
import brjt23.chs.wumpus.cmd.factory.ConsoleCommandFactory;
import brjt23.chs.wumpus.cmd.factory.ICommandFactory;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Reads commands from console
 * @author Borja
 *
 */
public class ConsoleCommandReader implements ICommandReader {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICommand read() throws WumpusGameException {
		Scanner scanner = new Scanner(System.in);
		ICommandFactory factory = new ConsoleCommandFactory();
		return factory.create(scanner.nextLine());
	}

}
