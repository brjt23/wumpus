package brjt23.chs.wumpus.perceptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that has the information related to each perception
 * @author Borja
 *
 */
public class PerceptionInfo {

	private static final String SMELL_INFO = "You smell the Wumpus. Is nearby...";

	private static final String WIND_INFO = "You feel a cool wind. A hole is nearby...";

	private static final String CRASH_INFO = "You crashed against a wall. Looks like that's not the right way...";

	private static final String SCREAM_INFO = "WAAAAAAHHHHHHH!!!! Can you listen it? That was the Wumpus dying";

	private static final String SHINE_INFO = "There's something shining here. Gold should be here...";

	private static PerceptionInfo instance = null;
	
	private final Map<Perception, String> perceptions = new HashMap<Perception, String>(); 
	
	/**
	 * Creates an instance of PerceptionInfo with the default info messages to the default perceptions
	 */
	private PerceptionInfo () {
		perceptions.put(Perception.SMELL, SMELL_INFO);
		perceptions.put(Perception.WIND, WIND_INFO);
		perceptions.put(Perception.CRASH, CRASH_INFO);
		perceptions.put(Perception.SCREAM, SCREAM_INFO);
		perceptions.put(Perception.SHINE, SHINE_INFO);
		instance = this;
	}
	
	/**
	 * 
	 * @return new instance of perceptionInfo in case it does not exists
	 */
	public static PerceptionInfo getInstance() {
		if (instance == null) {
			instance = new PerceptionInfo();
			return instance;
		}
		
		return instance;
	}

	/**
	 * 
	 * @return Map with the perceptions and their info
	 */
	public Map<Perception, String> getPerceptions() {
		return perceptions;
	}
}
