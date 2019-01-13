package brjt23.chs.wumpus.utils.property;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import brjt23.chs.wumpus.utils.property.IPropertyReader;
import brjt23.chs.wumpus.utils.property.SimplePropertyFileReader;
import brjt23.chs.wumpus.utils.property.WumpusPropertyFile;
import junit.framework.TestCase;

/**
 * Tests that a file is properly readed.
 * @author Borja
 *
 */
public class SimplePropertyFileReaderTest {
	
	/**
	 * Tests it read properly a file
	 */
	@Test
	public void readFile() {
//		String path = getClass().getResource("/config.properties").getFile();
		
		IPropertyReader reader = new SimplePropertyFileReader();
		
		try {
			WumpusPropertyFile prop = reader.read("/config.properties");
			WumpusPropertyFile expected = new WumpusPropertyFile();
			
			expected.setArrows(2);
			expected.setHeight(6);
			expected.setWidth(8);
			expected.setHoles(4);
			
			assertEquals(expected, prop);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	/**
	 * Tests exception is found when cannot find the file
	 * @throws IOException 
	 */
	@Test(expected = NullPointerException.class)
	public void fileNotFound() throws IOException {
		String path = "/conf.properties";
		
		IPropertyReader reader = new SimplePropertyFileReader();
		
		
		WumpusPropertyFile prop = reader.read(path);
		WumpusPropertyFile expected = new WumpusPropertyFile();
		
		expected.setArrows(2);
		expected.setHeight(6);
		expected.setWidth(8);
		expected.setHoles(4);
		
		assertEquals(expected, prop);
			
		
				
	}
}
