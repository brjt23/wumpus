package brjt23.chs.wumpus.board.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import brjt23.chs.wumpus.board.Position;

/**
 * Builds objects Position on different ways
 * @author Borja
 *
 */
public class PositionBuilder {

	/**
	 * Creates an amount of rendom positions on the interval x[0-width],y[0-height]
	 * @param width x max value
	 * @param height  y max value
	 * @param amount number of random positions to generate
	 * @return An array of positions generated randomly
	 */
	public static List<Position> generateRandomPositions(int width, int height, int amount) {
		List<Position> positions = new ArrayList<Position>();
		
		for (int i = 0; i < amount; i++) {
			positions.add(generateRandomPosition(width, height));
		}
		
		return positions;
	}

	/**
	 * Creates a random position given the interval  x[0-width],y[0-height]
	 * @param width x max value
	 * @param height y max value
	 * @return a position generated randomly
	 */
	public static Position generateRandomPosition(int width, int height) {
		int x = ThreadLocalRandom.current().nextInt(0, width);
		int y = ThreadLocalRandom.current().nextInt(0, height);
		
		return new Position(x, y);
	}

}
