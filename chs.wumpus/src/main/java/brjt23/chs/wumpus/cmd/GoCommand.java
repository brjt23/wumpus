package brjt23.chs.wumpus.cmd;


import brjt23.chs.wumpus.IGame;
import brjt23.chs.wumpus.SimpleWumpusGame;
import brjt23.chs.wumpus.board.Position;
import brjt23.chs.wumpus.exceptions.GameOverException;
import brjt23.chs.wumpus.exceptions.GoldFoundException;
import brjt23.chs.wumpus.exceptions.WumpusGameException;
import brjt23.chs.wumpus.hunter.IHunter;
import brjt23.chs.wumpus.perceptions.Perception;
import brjt23.chs.wumpus.perceptions.PerceptionInfo;

/**
 * Go command. Make the hunter move
 * @author Borja
 *
 */
public class GoCommand implements ICommand {

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		IGame game = SimpleWumpusGame.getInstance();
		
		Position last = game.getHunter().getPosition();
		game.getHunter().go();
		//print perceptions
		if(!game.getBoard().getCells().containsKey(game.getHunter().getPosition())) {
			System.out.println(PerceptionInfo.getInstance().getPerceptions().get(Perception.CRASH));
			// rollback. 
			game.getHunter().go(last);
		}
		else {
			game.getBoard().getCells().get(game.getHunter().getPosition()).getPerceptions().forEach((perception) -> {
				String msg = PerceptionInfo.getInstance().getPerceptions().get(perception);
				System.out.println(msg);
			});
			// run event if exist
			try {
				game.getBoard().getCells().get(game.getHunter().getPosition()).getEvent().execute();
			} catch (NullPointerException e) {
				System.err.println("No event at position: " + game.getHunter().getPosition());
			} catch (GoldFoundException e) {
				game.getHunter().pickUpGold();
				System.out.println(e.getMessage());
			} catch (GameOverException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} catch (WumpusGameException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
