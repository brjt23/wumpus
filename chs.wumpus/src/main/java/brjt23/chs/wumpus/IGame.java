package brjt23.chs.wumpus;

import brjt23.chs.wumpus.board.Board;
import brjt23.chs.wumpus.exceptions.errors.WrongBoardDefinitionException;
import brjt23.chs.wumpus.hunter.IHunter;

/**
 * Methods to play the game
 * @author Borja
 *
 */
public interface IGame {

	/**
	 * Starts playing the game
	 */
	public void play();

	/**
	 * 
	 * @return the hunter 
	 */
	public IHunter getHunter();

	/**
	 * 
	 * @return the board
	 */
	public Board getBoard();

	/**
	 * 
	 * @param width board width
	 * @param height board height
	 * @param holes board holes
	 * @throws WrongBoardDefinitionException when board cannot be created
	 */
	void createBoard(int width, int height, int holes) throws WrongBoardDefinitionException;

	/**
	 * Creates a hunter
	 * @param arrows number of arrows of the hunter
	 */
	void createHunter(int arrows);
}
