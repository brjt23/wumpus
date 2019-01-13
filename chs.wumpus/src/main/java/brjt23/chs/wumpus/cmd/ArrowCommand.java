package brjt23.chs.wumpus.cmd;



import brjt23.chs.wumpus.IGame;
import brjt23.chs.wumpus.SimpleWumpusGame;
import brjt23.chs.wumpus.board.Position;
import brjt23.chs.wumpus.events.statics.WumpusEvent;
import brjt23.chs.wumpus.exceptions.WumpusGameException;
import brjt23.chs.wumpus.exceptions.WumpusKilledException;
import brjt23.chs.wumpus.perceptions.Perception;
import brjt23.chs.wumpus.perceptions.PerceptionInfo;

/**
 * Command to throw an arrow
 * @author Borja
 *
 */
public class ArrowCommand implements ICommand {
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		IGame game = SimpleWumpusGame.getInstance();
		Position p = game.getHunter().getPosition();
		double orientation = game.getHunter().getOrientation();
		boolean hit = false;
		
		try {
			game.getHunter().shoot();
			while (!hit) {
				p = p.sum(
						new Position((int)Math.cos(orientation),(int)Math.sin(orientation)));
				
				if(!game.getBoard().getCells().containsKey(p)) {
					//hits a wall
					hit = true;
					System.out.println(PerceptionInfo.getInstance().getPerceptions().get(Perception.CRASH));
				} else {
					try {
						String eventName =game.getBoard().getCells().get(p).getEvent().getName();
						
						if(eventName.equals(new WumpusEvent().getName())) {
							// hits the Wumpus
							hit = true;
							game.getBoard().getCells().get(p).setEvent(null);// kill wumpus event
							System.out.println(PerceptionInfo.getInstance().getPerceptions().get(Perception.SCREAM));
						}
					} catch (NullPointerException e) {
						System.err.println("No event at position: " + game.getHunter().getPosition());
					}
				}
				
			}
		} catch (WumpusGameException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
