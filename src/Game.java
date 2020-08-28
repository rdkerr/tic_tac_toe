public class Game implements Playable {
	public static int currentTurn;
	private GameStatus game;
	private Board board;
	private Players players;

	public Game() {
		currentTurn = 0;
		game = GameStatus.CONTINUE;
		board = new Board();
		players = new Players();
	}

	public void playGame() {
		System.out.println("Welcome to TicTacToe");
		while(game == GameStatus.CONTINUE) {
			currentTurn++;
			Location turn;
			Space space = currentTurn % 2 == 0 ? Space.X : Space.O;
			Player player = players.whoseTurn(currentTurn);
			turn = player.play(board);
			board.place(turn, space);
			game = board.checkForWin(space);
			System.out.println(board);
			System.out.println(space + " played at: " + turn);
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
