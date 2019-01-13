package brjt23.chs.wumpus.events.statics;

import brjt23.chs.wumpus.events.IEvent;
import brjt23.chs.wumpus.exceptions.GameOverException;
import brjt23.chs.wumpus.exceptions.GoldFoundException;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Event launched when gold is found at a cell
 * @author Borja
 *
 */
public class GoldEvent implements IEvent {
	
	private final String NAME = "Gold Event";
	
	private final String EVENT_INFO = "CONGRATS!!! You have found the gold.";
	
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
		throw new GoldFoundException(EVENT_INFO);
		
	}

}
