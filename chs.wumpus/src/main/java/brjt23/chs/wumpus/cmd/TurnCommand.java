package brjt23.chs.wumpus.cmd;

import brjt23.chs.wumpus.SimpleWumpusGame;
import brjt23.chs.wumpus.hunter.SimpleHunter;
import brjt23.chs.wumpus.utils.Messages;

/**
 * Turns the hunter to the right o the left
 * @author Borja
 *
 */
public class TurnCommand implements ICommand {
	
	private double radians;
	
	/**
	 * Creates a turn command that turns the specified amount of radians
	 * @param radians radians to turn
	 */
	public TurnCommand(double radians) {
		this.radians = radians;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		SimpleWumpusGame.getInstance().getHunter().turn(radians);
		System.out.println(Messages.ROTATION_SUCCES 
				+ SimpleWumpusGame.getInstance().getHunter().getOrientation());
		
	}

}
