package brjt23.chs.wumpus.hunter;

import brjt23.chs.wumpus.board.Position;
import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Actions that any hunter can do
 * @author Borja
 *
 */
public interface IHunter {
	
	/**
	 * 
	 * @return current position of the hunter
	 */
	public Position getPosition();
	
	/**
	 * 
	 * @return current orientation in degrees of the hunter
	 */
	public double getOrientation();
	
	/**
	 * 
	 * @return true if the hunter already found the gold
	 */
	public boolean hasGold();
	
	/**
	 * The hunters pick up the gold
	 */
	public void pickUpGold();
	
	/**
	 * Goes to next position
	 */
	public void go() ;
	
	/**
	 * it turns the indicated amount of degrees 
	 * @param degrees degrees to be turned, positive values turn right, negative left 
	 */
	public void turn(double degrees) ;
	
	/**
	 * Shoots the hunter weapon
	 * @throws WumpusGameException when weapon cannot be used
	 */
	public void shoot() throws WumpusGameException;

	/**
	 * goes to the position p
	 * @param p position to go to
	 */
	public void go(Position p);
	
	
}
