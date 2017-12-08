//import java.util.Scanner;

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

	/****************
	 * CONSTRUCTORS *
	 ****************/

	/***********
	 * METHODS *
	 ***********/

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
		gameDice.rollDice();
		System.out.println("\ntesting dice roll \n"+gameDice.toString());
		
		int[] temp = {1,2,4};
		gameDice.diceSelection(temp);
		gameDice.rollDice();
		System.out.println("\ntesting dice roll with selection \n"+gameDice.toString());
		
	}
}
