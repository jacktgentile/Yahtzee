
public class Player {
	public String name;
	private int score;
	public boolean[] scoreSheet;
	
	public Player(String n) {
		name = n;
		score = 0;
		for (boolean b : scoreSheet) {
			b = false;
		}
	}
	
	public int getScore() {
		return score;
	}
}
