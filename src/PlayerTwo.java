public class PlayerTwo extends Player{
	public PlayerTwo() {
		super("Two");
	}
	
	public Location play(Board board) {
		int place = 0;
		Location loc = new Location(place, place);
		while (!board.isAvailable(loc)) {
			place++;
			loc = new Location((place / 3) % 3, place % 3);
		}
		return loc;
	}
}
