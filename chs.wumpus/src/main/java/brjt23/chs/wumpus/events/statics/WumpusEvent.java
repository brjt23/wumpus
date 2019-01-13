package brjt23.chs.wumpus.events.statics;

import brjt23.chs.wumpus.events.IEvent;
import brjt23.chs.wumpus.exceptions.GameOverException;

/**
 * Event that runs when player is at the wumpus cell
 * @author Borja
 *
 */
public class WumpusEvent implements IEvent {

	private final String NAME = "Wumpus Event"; 
	
	private final String EVENT_INFO = "GAME OVER. You got killed by the Wumpus.";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws GameOverException {
		
		throw new GameOverException(EVENT_INFO);
	}

}
