package brjt23.chs.wumpus.exceptions;

public class GoldFoundException extends WumpusGameException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6602747960334598182L;
	
	private String msg;
	
	public GoldFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
