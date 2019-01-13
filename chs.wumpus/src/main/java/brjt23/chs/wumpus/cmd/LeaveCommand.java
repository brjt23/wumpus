package brjt23.chs.wumpus.cmd;

import brjt23.chs.wumpus.IGame;
import brjt23.chs.wumpus.SimpleWumpusGame;
import brjt23.chs.wumpus.utils.Messages;

/**
 * Command to leave from the entrance
 * @author Borja
 *
 */
public class LeaveCommand implements ICommand {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		if(SimpleWumpusGame.getInstance().getHunter().getPosition() != SimpleWumpusGame.INITIAL_POSITION) {
			System.out.println(Messages.F_NOT_ALLOWED);
		} else {
			System.out.println(Messages.LEAVE_DUNGEON);
			System.exit(0);
		}
		
	}

}
