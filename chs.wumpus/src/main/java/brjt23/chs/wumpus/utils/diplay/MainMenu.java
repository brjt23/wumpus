package brjt23.chs.wumpus.utils.diplay;

/**
 * Main menu of the Wumpus game. Offers the actions to do.
 * @author Borja
 *
 */
public class MainMenu implements IDisplay{
	
	private final String TITLE = "Select the next action you wanna do:";
	private final String GO = "- g: Go forward.";
	private final String TURN_RIGHT = "- r: Turn 90º to the right";
	private final String TURN_LEFT = "- l: Turn 90º to the left";
	private final String SHOT = "- a: Use an arrow";
	private final String LEAVE = "- f: Leave the dungeon";
	private final String QUIT = "- q: Quit the game";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void display() {
		StringBuilder builder = new StringBuilder();
		builder.append(TITLE);
		builder.append(System.getProperty("line.separator"));
		builder.append(GO);
		builder.append(System.getProperty("line.separator"));
		builder.append(TURN_LEFT);
		builder.append(System.getProperty("line.separator"));
		builder.append(TURN_RIGHT);
		builder.append(System.getProperty("line.separator"));
		builder.append(SHOT);
		builder.append(System.getProperty("line.separator"));
		builder.append(LEAVE);
		builder.append(System.getProperty("line.separator"));
		builder.append(QUIT);
		builder.append(System.getProperty("line.separator"));
		
		System.out.print(builder.toString());
		
	}

}
