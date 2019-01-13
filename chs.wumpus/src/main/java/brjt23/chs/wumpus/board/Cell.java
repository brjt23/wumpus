package brjt23.chs.wumpus.board;

import java.util.ArrayList;
import java.util.List;

import brjt23.chs.wumpus.events.IEvent;
import brjt23.chs.wumpus.perceptions.Perception;

/**
 * Represents a cell of the board, it may contains events or perceptions
 * @author Borja
 *
 */
public class Cell {
	
	/**
	 * Cell event, can be null
	 */
	private IEvent event;
	
	/**
	 * Cell perceptions
	 */
	private final List<Perception> perceptions = new ArrayList<Perception>();

	
	
	/**
	 * 
	 * @return cell event
	 */
	public IEvent getEvent() {
		return event;
	}

	/**
	 * 
	 * @param event cell event
	 */
	public void setEvent(IEvent event) {
		this.event = event;
	}

	/**
	 * 
	 * @return cell perceptions
	 */
	public List<Perception> getPerceptions() {
		return perceptions;
	}

	
}
