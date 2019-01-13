package brjt23.chs.wumpus.board.builder;

import java.util.List;

import brjt23.chs.wumpus.board.Board;
import brjt23.chs.wumpus.board.Position;
import brjt23.chs.wumpus.events.statics.GoldEvent;
import brjt23.chs.wumpus.events.statics.HoleEvent;
import brjt23.chs.wumpus.events.statics.WumpusEvent;
import brjt23.chs.wumpus.exceptions.errors.WrongBoardDefinitionException;
import brjt23.chs.wumpus.perceptions.Perception;

/**
 * Generates boards to play Wumpus game
 * @author Borja
 *
 */
public class BoardBuilder {

	/**
	 * Creates a board with gold, wumpus and holes created randomly
	 * @param width
	 * @param height
	 * @param holes
	 * @return a board created with gold, wumpus and holes located randomly
	 * @throws WrongBoardDefinitionException when board too small or too many holes
	 */
	public static Board createRandomBoard(int width, int height, int holes) throws WrongBoardDefinitionException {
		Board board = new Board(width,height,holes);
		
		board = addGold(board);
		board = addWumpus(board);
		board = addHoles(board);
		
		return board;
	}
	
	/**
	 * Generates holes randomly and sets its events and perceptions
	 */
	private static Board addHoles(Board board) {
		List<Position> holePostions = PositionBuilder.generateRandomPositions(board.getWidth(), 
				board.getHeight(), board.getHoles());
		
		for(Position p : holePostions) {
			board.getCells().get(p).setEvent(new HoleEvent());
			board = addAdjacentPerceptions(board, p, Perception.WIND);
		}
		
		return board;
	}

	/**
	 * Generates a wumpus event and perceptions at a random position
	 */
	private static Board addWumpus(Board board) {
		Position wumpusPosition = PositionBuilder.generateRandomPosition(board.getWidth(), board.getHeight());
		
		board.getCells().get(wumpusPosition).setEvent(new WumpusEvent());
		board = addAdjacentPerceptions(board, wumpusPosition, Perception.SMELL);
		
		return board;
	}

	/**
	 * Adds perception to the wumpus adjacent cells
	 * @param board
	 * @param position
	 * @return board updated withb smells
	 */
	private static Board addAdjacentPerceptions(Board board, Position position, Perception perception) {
		Position up = position.sum(new Position(0,1));
		Position right = position.sum(new Position(1,0));
		Position left = position.sum(new Position(-1,0));
		Position down = position.sum(new Position(0,-1));
		
		board = addPerception(board, up, perception);
		board = addPerception(board, right, perception);
		board = addPerception(board, left, perception);
		board = addPerception(board, down, perception);
		
		return board;
		
	}

	/**
	 * Adds a perception at the mentioned position of the board
	 * @param board
	 * @param position
	 * @param perception
	 * @return board updated with the new perception added
	 */
	private static Board addPerception(Board board, Position position, Perception perception) {
		if(board.getCells().get(position) != null) {
			board.getCells().get(position).getPerceptions().add(perception);
		};	
		return board;
	}

	/**
	 * Generetes a gold position randomly and adds its event and perceptions
	 */
	private static Board addGold(Board board) {
		Position goldPosition = PositionBuilder.generateRandomPosition(board.getWidth(), board.getHeight());
		board.getCells().get(goldPosition).setEvent(new GoldEvent());
		board.getCells().get(goldPosition).getPerceptions().add(Perception.SHINE);
		
		return board;
	}
}
