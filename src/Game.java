
public class Game {
	Player p1, p2;
	int roundNum;
	public Game(Player player1, Player player2) {
		p1 = player1;
		p2 = player2;
	}
	
	public void start() {
		roundNum = 1;
	}
}
