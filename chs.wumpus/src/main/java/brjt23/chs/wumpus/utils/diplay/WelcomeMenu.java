package brjt23.chs.wumpus.utils.diplay;

/**
 * Welcome men u of the Wumpus game
 * @author Borja
 *
 */
public class WelcomeMenu implements IDisplay{

	private final String TITLE = "WELCOME TO THE WUMPUS GAME.";
	private final String INSTRUCTIONS = "Try to find the gold and leave the dungeon.";
	private final String AWARE = "But be aware of the Wumpus or to fall at any hole";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void display() {
		StringBuilder builder = new StringBuilder();
		builder.append(TITLE);
		builder.append(System.getProperty("line.separator"));
		builder.append(INSTRUCTIONS);
		builder.append(" ");
		builder.append(AWARE);
		builder.append(System.getProperty("line.separator"));
		
		System.out.print(builder.toString());
	}

	
}
