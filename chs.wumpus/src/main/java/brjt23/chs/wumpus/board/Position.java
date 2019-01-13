package brjt23.chs.wumpus.board;

/**
 * Represents a 2D position at the board using cartesian axes X and Y
 * @author Borja
 *
 */
public class Position {

	

	/**
	 * Represents te position at the X axe of the board
	 */
	private int x;
	
	/**
	 * Represents the position at the Y axe of the board
	 */
	private int y;
	
	/**
	 * 
	 * @param x position at axe X of the board
	 * @param y position at axe y of the board
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @return position at axe X of the board
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x position at axe X of the board
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return position at axe Y of the board
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y position at axe Y of the board
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Sums tow position 
	 * @param p position to sum to the current
	 * @return a new Position which x and y values are the result 
	 * of the sum of the x and y of the current position and the 
	 * one gotten as a parameter
	 */
	public Position sum(Position p) {
		return new Position(x + p.getX(), y + p.getY());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
