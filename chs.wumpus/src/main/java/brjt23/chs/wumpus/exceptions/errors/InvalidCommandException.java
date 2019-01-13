package brjt23.chs.wumpus.exceptions.errors;

import brjt23.chs.wumpus.exceptions.WumpusGameException;

public class InvalidCommandException extends WumpusGameException {


	private String msg;
	
	/**
	 * 
	 * @param msg excetion message
	 */
	public InvalidCommandException(String msg) {
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
