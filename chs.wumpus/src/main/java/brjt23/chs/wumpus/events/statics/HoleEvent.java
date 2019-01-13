package brjt23.chs.wumpus.events.statics;

import brjt23.chs.wumpus.events.IEvent;
import brjt23.chs.wumpus.exceptions.GameOverException;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Event launched when player shares a cell that contains a hole
 * @author Borja
 *
 */
public class HoleEvent implements IEvent {

	private final String NAME = "Hole Event";
	
	private final String EVENT_INFO = "GAME OVER. You have fallen into a hole.";
	
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
	public void execute() throws WumpusGameException {
		throw new GameOverException(EVENT_INFO);
		
	}

}
