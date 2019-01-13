package brjt23.chs.wumpus.hunter;

import brjt23.chs.wumpus.board.Position;
import brjt23.chs.wumpus.exceptions.NoArrowsException;
import brjt23.chs.wumpus.utils.Messages;

/**
 * A simlpe hunter that can move only one step over, turns alwas |90| degrees
 * and shoots arows
 * @author Borja
 *
 */
public class SimpleHunter implements IHunter{

	/**
	 * To turn left the hunter rotates -90 degrees
	 */
	public static final double RIGHT_TURN = Math.PI / -2;

	/**
	 * Vlue of pi i degrees
	 */
	//private static final int PI = 180;

	/**
	 * To turn left the hunter rotates 90 degrees
	 */
	public static final double LEFT_TURN = Math.PI / 2;

	/**
	 * number of arrows the hunter can still use
	 */
	private int arrows;
	
	/**
	 * current position of the hunter
	 */
	private Position position;
	
	/**
	 * current orientation of the hunter expressed in degrees
	 */
	private double orientation;

	/**
	 * true when the hunter has found the gold
	 */
	private boolean gold;
	
	/**
	 * Creates a player located at position (0,0) with orientation 0 degrees.
	 * @param arrows amoubnt of arrows the hunter can use
	 */
	public SimpleHunter(int arrows) {
		this.arrows = arrows;
		position = new Position(0, 0);
		orientation = 0;
		gold = false;
	}

	/**
	 * 
	 * @return the remaining arrows
	 */
	public int getArrows() {
		return arrows;
	}

	/**
	 * 
	 * @param arrows remaining amount of arrows
	 */
	public void setArrows(int arrows) {
		this.arrows = arrows;
	}

	/**
	 * 
	 * @return current position of the hunter
	 */
	public Position getPosition() {
		return position;
	}


	/**
	 * 
	 * @return current orientation of the hunter in degrees 
	 */
	public double getOrientation() {
		return orientation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void go() {
		// uses sin and cos cause it always returns 0 or 1 for the available orientations
		// cos is used with x axe and sin with y
		this.position = this.position.sum(
				new Position((int)Math.cos(orientation),
						(int)Math.sin(orientation)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void turn(double degrees) {
		if (degrees % RIGHT_TURN != 0) {
			throw new IllegalArgumentException("This hunter can only turn abs(90)");
		}
		
		orientation += degrees;
		
		scale();
		
	}

	/**
	 * Scales the orientation so it remains in the interval [0-360]
	 */
	private void scale() {
		int n = (int)Math.abs(orientation / (2*Math.PI));
		
		// If bigger than 2PI it adds/substrates n2PI where n is the number of times the orientation pass 2PI
		if(orientation > (2*Math.PI)) {
			orientation -= (n*(2*Math.PI));
		} else if(orientation < (-2 * Math.PI)) {
			orientation += (n*(2*Math.PI));
		}
		
	}

	/**
	 * {@inheritDoc}
	 * @throws NoArrowsException when arrows < 1
	 */
	@Override
	public void shoot() throws NoArrowsException {
		if(arrows < 1) {
			throw new NoArrowsException(Messages.NO_ARROWS);
		}
		arrows--;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasGold() {
		
		return gold;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void pickUpGold() {
		gold = true;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void go(Position p) {
		this.position = p;
	}

	
	
}
