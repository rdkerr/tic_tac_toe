import java.util.ArrayList;

public class Players {
	private ArrayList<Player> players;

	public Players() {
		players = new ArrayList<Player>();
		players.add(new PlayerOne());
		players.add(new PlayerTwo());
	}

	public Player whoseTurn(int turn) {
		return players.get(turn % 2);
	}
}
