package brjt23.chs.wumpus;
import java.io.IOException;



import brjt23.chs.wumpus.exceptions.errors.WrongBoardDefinitionException;
import brjt23.chs.wumpus.utils.Messages;
import brjt23.chs.wumpus.utils.diplay.IDisplay;
import brjt23.chs.wumpus.utils.diplay.WelcomeMenu;
import brjt23.chs.wumpus.utils.property.IPropertyReader;
import brjt23.chs.wumpus.utils.property.SimplePropertyFileReader;
import brjt23.chs.wumpus.utils.property.WumpusPropertyFile;

/**
 * Hello world!
 *
 */
public class Wumpus 
{
    private static String path;

	public static void main( String[] args )
    {
		path = "/config.properties";
		
    	new WelcomeMenu().display();
    	
    	IPropertyReader reader = new SimplePropertyFileReader();
    	
    	try {
			WumpusPropertyFile properties = reader.read(path);
			IGame game = SimpleWumpusGame.getInstance();
			
			game.createBoard(properties.getWidth(), properties.getHeight(), properties.getHoles());
			game.createHunter(properties.getArrows());
			
			game.play();
			
			System.out.println(Messages.QUIT_GAME);
			
		} catch (IOException e) {
			System.out.println(Messages.FILE_NOT_FOUND_ERROR + path);
		} catch (WrongBoardDefinitionException e) {
			System.out.println(e.getMessage());
		}
    	
    }
}
