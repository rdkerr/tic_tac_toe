import java.util.ArrayList;

public class Game implements Playable {
	private ArrayList<Player> players;
	public static int currentTurn;
	private GameStatus game;
	private Board board;
	
	public Game() {
		players = new ArrayList<Player>();
		players.add(new PlayerOne());
		players.add(new PlayerTwo());
		currentTurn = 0;
		game = GameStatus.CONTINUE;
		board = new Board();
	}
	
	public void playGame() {
		System.out.println("Welcome to TicTacToe");
		while(game == GameStatus.CONTINUE) {
			currentTurn++;
			Location turn;
			Space player;
			if (currentTurn % 2 == 0) {
				turn = players.get(0).play(board);
				player = Space.X;
			} else {
				turn = players.get(1).play(board);
				player = Space.O;
			}
			board.place(turn, player);
			game = board.checkForWin(player);
			System.out.println(board);
			System.out.println(player + " plays " + turn);
		}
	}
	
	public void printResults() {
		if (game == GameStatus.OVER && currentTurn % 2 == 0) {
			System.out.println("Player X wins!");
		} else if (game == GameStatus.OVER){
			System.out.println("Player O wins!");
		} else {
			System.out.println("DRAW");
		}
	}
}
