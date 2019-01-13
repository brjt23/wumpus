package brjt23.chs.wumpus;



import java.util.Date;

import brjt23.chs.wumpus.board.Board;
import brjt23.chs.wumpus.board.Position;
import brjt23.chs.wumpus.board.builder.BoardBuilder;
import brjt23.chs.wumpus.cmd.ICommand;
import brjt23.chs.wumpus.cmd.reader.ConsoleCommandReader;
import brjt23.chs.wumpus.cmd.reader.ICommandReader;
import brjt23.chs.wumpus.exceptions.WumpusGameException;
import brjt23.chs.wumpus.exceptions.errors.WrongBoardDefinitionException;
import brjt23.chs.wumpus.hunter.IHunter;
import brjt23.chs.wumpus.hunter.SimpleHunter;
import brjt23.chs.wumpus.utils.Messages;
import brjt23.chs.wumpus.utils.diplay.IDisplay;
import brjt23.chs.wumpus.utils.diplay.MainMenu;

/**
 * Main logic of a Wumpus game with a 2d board. 
 * It gets inputs from the console to move the player(hunter)
 * @author Borja
 *
 */
public class SimpleWumpusGame implements IGame{

	/**
	 * The initial position of the hunter at this game is (0,0)
	 */
	public static final Position INITIAL_POSITION = new Position(0, 0);

	/**
	 * number of steps took you to finish the game
	 */
	private int steps;
	
	/**
	 * Game board
	 */
	private  Board board;
	
	/**
	 * game hunter
	 */
	private  IHunter hunter;
	
	/**
	 * instance of the game. Only one game can be played at time
	 */
	private static IGame instance;
	
	/**
	 * Creates a new instance of the game
	 */
	private SimpleWumpusGame() {
		instance = this;
		board = null;
		hunter = null;
		steps = 0;
	}
	
	/**
	 * 
	 * @return an instance of the simple wumpus game
	 */
	public static IGame getInstance() {
		
		if(instance == null) {
			instance = new SimpleWumpusGame();
		}
		
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createBoard(int width, int height, int holes) throws WrongBoardDefinitionException {
		board = BoardBuilder.createRandomBoard(width, height, holes);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createHunter(int arrows) {
		hunter = new SimpleHunter(arrows);
	}
	
	/**
	 * 
	 * @param width with of the boar of the game
	 * @param height  height of the game's board
	 * @param arrows amount of arrows the hunter can use
	 * @param propertiesPath path to the properties file that initializes the game
	 * @throws WrongBoardDefinitionException when board too small or too many holes 
	 */
	private SimpleWumpusGame(int width,int height, int arrows) throws WrongBoardDefinitionException  {
		board = BoardBuilder.createRandomBoard(width, height, arrows);
		hunter = new SimpleHunter(arrows);
	}


	/**
	 * 
	 * @return game board
	 */
	public Board getBoard() {
		return board;
	}

	

	/**
	 * 
	 * @return game hunter
	 */
	public IHunter getHunter() {
		return hunter;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void play() {
		IDisplay mainMenu = new MainMenu();
		ICommandReader reader = new ConsoleCommandReader();
		ICommand cmd;
		long start = new Date().getTime();
		while (!(hunter.hasGold() && hunter.getPosition().equals(INITIAL_POSITION))) {
			mainMenu.display();
			try {
				cmd = reader.read();
				cmd.execute();
				steps++;
			} catch (WumpusGameException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		System.out.println(Messages.END_GAME);
		System.out.println(Messages.STEPS + steps);
		System.out.println(Messages.TIME + (new Date().getTime() - start));
	}
	
}
