package brjt23.chs.wumpus.exceptions.errors;

import brjt23.chs.wumpus.exceptions.WumpusGameException;

/**
 * Exception that throws when an error occurs on attempting to create a board
 * @author Borja
 *
 */
public class WrongBoardDefinitionException extends WumpusGameException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7753472180684716215L;
	
	private String msg;
	
	/**
	 * Initializes the exception message
	 * @param msg  exception message
	 */
	public WrongBoardDefinitionException(String msg) {
		this.msg = msg;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage() {
		return this.msg;
	}

}
