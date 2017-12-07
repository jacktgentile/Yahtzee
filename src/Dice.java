
/**
 * @author Vincent Hu , Jack Gentile
 */

import java.util.Arrays;

/**
 * Class that manages the functions of 5 dice.
 */
public class Dice {
	/**********************
	 * INSTANCE VARIABLES *
	 **********************/

	/**
	 * Array of integers that represents the 5 dice from the game.
	 */
	private int[] gameDice;

	/**
	 * Array of booleans that represent which dice the player wants to roll.
	 */
	private boolean[] diceRollSet;

	/****************
	 * CONSTRUCTORS *
	 ****************/

	/**
	 * Initializes a set of
	 */
	public Dice() {
		gameDice = new int[5];
		diceRollSet = new boolean[5];
		Arrays.fill(diceRollSet, true);
	}

	/***********
	 * METHODS *
	 ***********/

	/**
	 * Sets which dice to roll and which dice too keep.
	 * 
	 * @param diceSel
	 *            Array of which dice to roll
	 */
	public void diceSelection(final int[] diceSel) {
		for (int i = 0; i < diceSel.length; i++) {
			Arrays.fill(diceRollSet, false);

			// Game Class will force diceSel values to be from 1-5.
			diceRollSet[diceSel[i] - 1] = true;
		}
	}

	/**
	 * Will roll dice dictated by diceRollSet.
	 */
	public void rollDice() {
		for (int i = 0; i < this.gameDice.length; i++) {
			if (this.diceRollSet[i]) {
				this.gameDice[i] = ((int)(6 * Math.random())) + 1;
			}
		}
	}
	
	/**
	 * Prints the dice and number onto the screen.
	 * @return Dice values in text picture format
	 */
	public String displayDice() {
		return "";
	}
}
