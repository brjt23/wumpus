package brjt23.chs.wumpus.utils.property;

import java.io.IOException;

/**
 * Interface with the required methods to read from a file
 * @author Borja
 *
 */
public interface IPropertyReader {

	/**
	 * Reads a property file located at the mentioned path
	 * @param path path to the property file
	 * @return A propertyFile object with the read data.
	 * @throws IOException whe property file cannot be found
	 */
	public WumpusPropertyFile read(String path) throws IOException;
}
