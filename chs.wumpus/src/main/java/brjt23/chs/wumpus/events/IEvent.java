package brjt23.chs.wumpus.events;

import brjt23.chs.wumpus.exceptions.GameOverException;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Interface methods for wumpus events
 * @author Borja
 *
 */
public interface IEvent {

	/**
	 * 
	 * @return the name of the event
	 */
	public String getName();
	
	/**
	 * Executes the actions of the event
	 */
	public void execute() throws WumpusGameException;
}
