package brjt23.chs.wumpus.utils.property;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;




/**
 * Reads a simple text property file.
 * @author Borja
 *
 */
public class SimplePropertyFileReader implements IPropertyReader{


	/**
	 * {@inheritDoc}
	 */
	@Override
	public WumpusPropertyFile read(String path) throws IOException, FileNotFoundException {
		Properties prop = new Properties();
		prop.load(SimplePropertyFileReader.class.getResourceAsStream(path));
		
		WumpusPropertyFile propertyFile = new WumpusPropertyFile();
		
		
		propertyFile.setArrows(Integer.parseInt((String)prop.get(WumpusPropertyFile.ARROWS)));
		propertyFile.setHeight(Integer.parseInt((String)prop.get(WumpusPropertyFile.HEIGTH)));
		propertyFile.setHoles(Integer.parseInt((String)prop.get(WumpusPropertyFile.HOLES)));
		propertyFile.setWidth(Integer.parseInt((String)prop.get(WumpusPropertyFile.WIDTH)));
		
		
		return propertyFile;
	}

	

}
