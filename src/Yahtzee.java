import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// title and game information
		System.out.println("---------------------");
		System.out.println(" Welcome to Yahtzee!\n For rules, go to https://www.hasbro.com/common/instruct/Yahtzee.pdf");
		System.out.println("---------------------");
		System.out.println(" To start, enter a name for each player:\n");
		
		// prompt user for information to construct players 1 and 2
		String name1 = "", name2 = "";
		Scanner scan = new Scanner(System.in);
		while (name1.equals("")) {
			System.out.print("Player 1: ");
			name1 = scan.next();
		}
		Player p1 = new Player(name1);
		while (name2.equals("")) {
			System.out.print("Player 2: ");
			name2 = scan.next();
		}
		Player p2 = new Player(name2);
		Game ggNoRe = new Game(p1, p2);
		ggNoRe.start();
		
	}

}
