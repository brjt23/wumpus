package brjt23.chs.wumpus.cmd;

import brjt23.chs.wumpus.utils.Messages;

/**
 * Command to quit the game
 * @author Borja
 *
 */
public class QuitCommand implements ICommand {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		System.out.println(Messages.QUIT_GAME);
		System.exit(0);
	}

}
