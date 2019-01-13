package brjt23.chs.wumpus.exceptions;

/**
 * Exception thrown when you lose the game
 * @author Borja
 *
 */
public class GameOverException extends WumpusGameException{

	private String msg;
	
	public GameOverException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1123995765956189166L;

}
