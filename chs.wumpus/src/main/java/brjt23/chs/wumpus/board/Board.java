package brjt23.chs.wumpus.board;

import java.util.HashMap;
import java.util.Map;

import brjt23.chs.wumpus.exceptions.errors.WrongBoardDefinitionException;
import brjt23.chs.wumpus.utils.Messages;



/**
 * Wumpus game board. It's a 2D board build by cells.
 * @author Borja
 *
 */
public class Board {

	/**
	 * It need at least 4 cells to be able to play the game
	 */
	private static final int MIN_CELLS = 4;

	/**
	 * Board's width
	 */
	private final int width;
	
	/**
	 * board's height
	 */
	private final int height;
	
	/**
	 * Board's holes
	 */
	private final int holes;
	
	/**
	 * Board's cells
	 */
	private final Map<Position, Cell> cells;
	
	/**
	 * Creates a Board given width, height and number of holes
	 * @param width
	 * @param height
	 * @param holes
	 * @throws WrongBoardDefinitionException 
	 */
	public Board(int width, int height, int holes) throws WrongBoardDefinitionException {
		checkDimensions(width, height, holes);
		cells = new HashMap<Position, Cell>();
		this.width = width;
		this.height = height;
		this.holes = holes;
		
		initCells();
	}

	/**
	 * Checks if the board parameters are fine.
	 * There's at least one cell for wumpus,gold,player and one empty
	 * The number of holes is less than the empty cells
	 * @param width board width
	 * @param height board height
	 * @param holes board holes
	 * @throws WrongBoardDefinitionException when the board is too small or has too many holes
	 */
	private void checkDimensions(int width, int height, int holes) throws WrongBoardDefinitionException {
		int size = width*height;
		
		if (size < MIN_CELLS) {
			throw new WrongBoardDefinitionException(Messages.SMALL_BOARD + MIN_CELLS);
		} 
		
		if (holes > (size - MIN_CELLS)) {
			throw new WrongBoardDefinitionException(Messages.MANY_HOLES);
		}
	}

	/**
	 * 
	 * @return board's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return board's height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @return Board's holes
	 */
	public int getHoles() {
		return holes;
	}

	/**
	 * 
	 * @return board's cells
	 */
	public Map<Position, Cell> getCells() {
		return cells;
	}

	

	/**
	 * initialices the board with empty cells
	 */
	private void initCells() {
		for (int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				cells.put(new Position(x,y), new Cell());
			}
		}
	}
}
