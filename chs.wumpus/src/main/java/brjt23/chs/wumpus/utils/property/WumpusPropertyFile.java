package brjt23.chs.wumpus.utils.property;

/**
 * Encapsulates the properties to configure the Wumpus game
 * @author Borja
 *
 */
public class WumpusPropertyFile {
	/**
	 * Name of the property Arrows at the property file
	 */
	public static final String ARROWS = "Arrows";

	/**
	 * Name of the property Height at the property file
	 */
	public static final String HEIGTH = "Heigth";

	/**
	 * Name of the property Holes at the property file
	 */
	public static final String HOLES = "Holes";

	/**
	 * Name of the property Width at the property file
	 */
	public static final String WIDTH = "Width";

	/**
	 * With of the board
	 */
	private int width;
	
	/**
	 * Height of the board
	 */
	private int height;
	
	/**
	 * Number of holes in the board
	 */
	private int holes;
	
	/**
	 * Number of arrows for the player
	 */
	private int arrows;

	/**
	 * Creates default properties for the game. Board 4x4, 3 holes and 1 arrrow
	 */
	public WumpusPropertyFile() {
		super();
		this.width = 4;
		this.height = 4;
		this.holes = 3;
		this.arrows = 1;
	}
	
	
	/**
	 * 
	 * @param width width of the board
	 * @param height height of the board
	 * @param holes number of holes in the board
	 * @param arrows number of arrows for the player
	 */
	public WumpusPropertyFile(int width, int height, int holes, int arrows) {
		super();
		this.width = width;
		this.height = height;
		this.holes = holes;
		this.arrows = arrows;
	}

	/**
	 * 
	 * @return width of the board
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width width of the board
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * 
	 * @return heigth of the board
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @param height height of the board
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * 
	 * @return number of holes in the board
	 */
	public int getHoles() {
		return holes;
	}

	/**
	 * 
	 * @param holes number of holes in the board
	 */
	public void setHoles(int holes) {
		this.holes = holes;
	}

	/**
	 * 
	 * @return number of arrows for the player
	 */
	public int getArrows() {
		return arrows;
	}

	/**
	 * 
	 * @param arrows number of arrows for the player
	 */
	public void setArrows(int arrows) {
		this.arrows = arrows;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arrows;
		result = prime * result + height;
		result = prime * result + holes;
		result = prime * result + width;
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
		WumpusPropertyFile other = (WumpusPropertyFile) obj;
		if (arrows != other.arrows)
			return false;
		if (height != other.height)
			return false;
		if (holes != other.holes)
			return false;
		if (width != other.width)
			return false;
		return true;
	}



}
