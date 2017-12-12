import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Vincent Hu, Jack Gentile
 */

/**
 * A class that runs the game.
 */

public class Game {
	/**********************
	 * INSTANCE VARIABLES *
	 **********************/
//	Scanner keyIn = new Scanner(System.in);

	/***********
	 * METHODS *
	 ***********/
	public void playerRollSeqeunce() {
		//todo Ask players for whether they wish to roll after the automatic first roll.
	}

	/**
	 * Run method of the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Welcome and where to read rules.
		System.out.println("---------------------");
		System.out.println(" Welcome to Yahtzee!\n Rules : https://www.hasbro.com/common/instruct/Yahtzee.pdf");
		System.out.println("---------------------");
		
		Dice gameDice = new Dice();
		Yahtzee scoreCards = new Yahtzee();
		
		Scanner keyIn = new Scanner(System.in);
		
		// Test Area
		
//		gameDice.rollDice();
//		System.out.println("\ntesting dice roll \n"+gameDice.toString());
		
		for (int round = 0; round < 26; round++) {
			System.out.println("Round " + (round / 2 + 1) + ":\nPlayer " + (round % 2 + 1));
			gameDice.rollDice();
			//reroll loop
			for (int i = 0; i < 2; i++) {
				System.out.println(gameDice.toString() + "\nWrite the number for each die "
						+ "you wish to reroll, 0 to roll.");
				int val = 7;
				boolean[] rollSet = new boolean[5];
				Arrays.fill(rollSet, false);
				while (val != 0) {
					val = keyIn.nextInt();
					if (val > 0 && val < 6) {
						rollSet[val - 1] = true;
					}
				}
				gameDice.rollDice(rollSet);
			}
			System.out.println(scoreCards.toString() + "\n" + gameDice.toString());
			int val = 0;
			while (!scoreCards.isValidChoice(val, round % 2 + 1)) {
				val = keyIn.nextInt();
			}
			gameDice.sortGameDice();
			scoreCards.setScore(val, gameDice, round % 2 + 1);
			System.out.println(scoreCards.toString() + "\n");
		}

		System.out.println(scoreCards.toString());
		
		keyIn.close();
	}
}
