import java.util.Random;

public class PlayerOne extends Player{
	private Random rand;
	public PlayerOne() {
		super("One");
		rand = new Random();
	}

	public Location play(Board board) {
		Location location = new Location(rand.nextInt(3), rand.nextInt(3));
		while (!board.isAvailable(location)) {
			location = new Location(rand.nextInt(3), rand.nextInt(3));
		}
		return location;
	}
}
