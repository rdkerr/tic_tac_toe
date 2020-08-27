public class Board {
	private Space[][] board;
	private final int SIZE = 3;
	
	public Board() {
		board = new Space[SIZE][SIZE];
		for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Space.E;
            }
        }
	}
	
	public void place(Location loc, Space sp) {
		board[loc.getX()][loc.getY()] = sp;
	}
	
	public GameStatus checkForWin(Space sp) {
		// Check horizontal
		for (int i = 0; i < board.length; i++) {
			int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == sp) count++;
            }
			if (count == 3) return GameStatus.OVER;
        }
		// Check vertical
		for (int i = 0; i < board.length; i++) {
			int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == sp) count++;
            }
			if (count == 3) return GameStatus.OVER;
        }
		
		// Check diagonals
		if (board[0][0] == sp && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return GameStatus.OVER;
		if (board[0][2] == sp && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return GameStatus.OVER;
		
		// Check for draw
		for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Space.E) return GameStatus.CONTINUE;
            }
        }
		return GameStatus.DRAW;
	}
	
	public boolean isAvailable(Location loc) {
		return board[loc.getX()][loc.getY()] == Space.E;
	}
	
	@Override
	public String toString() {
		String temp = "  1 2 3\n";
	    temp += "A " + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n";  
	    temp += "-------" + "\n";  
	    temp += "B " + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n";   
	    temp += "-------" + "\n";  
	    temp += "C " + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "\n"; 
	    return temp;
	}
}
