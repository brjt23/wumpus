package brjt23.chs.wumpus.exceptions;

/**
 * Exception thrown when the hunter has no more arrows
 * @author Borja
 *
 */
public class NoArrowsException extends WumpusGameException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3817478079043143383L;
	
	
	private String msg;
	/**
	 * Initializes the exception message
	 * @param msg exception message
	 */
	public NoArrowsException(String msg) {
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
