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
	Scanner keyIn = new Scanner(System.in);

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
		
		// Test Area
		
		gameDice.rollDice();
		System.out.println("\ntesting dice roll \n"+gameDice.toString());
		
		int[] temp = {1,2,4};
		gameDice.diceSelection(temp);
		gameDice.rollDice();
		System.out.println("\ntesting dice roll with selection \n"+gameDice.toString());

		System.out.println(scoreCards.toString());
		
	}
}
