public abstract class Player {
	protected String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public abstract Location play(Board board);
}
