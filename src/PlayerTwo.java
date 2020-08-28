public class PlayerTwo extends Player{
	public PlayerTwo() {
		super("Two");
	}

	public Location play(Board board) {
		int place = 0;
		Location location = new Location(place, place);
		while (!board.isAvailable(location)) {
			place++;
			location = new Location((place / 3) % 3, place % 3);
		}
		return location;
	}
}
