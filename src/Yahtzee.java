import java.util.Arrays;

/**
 * @author Vincent Hu, Jack Gentile
 *
 */

/**
 * Class to manage the rules and functions of the game.
 */
public class Yahtzee {
	/**********************
	 * INSTANCE VARIABLES *
	 **********************/

	/**
	 * Number assigned to cells that do not have a value set.
	 */
	private final int emptyCell = 888;

	/**
	 * Score board for the first player.
	 */
	private int[] player1;

	/**
	 * Score board for the second player.
	 */
	private int[] player2;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	/**
	 * Initializes a set of arrays that represents the score board.
	 */
	public Yahtzee() {
		player1 = new int[16];
		Arrays.fill(player1, this.emptyCell);
		player2 = new int[16];
		Arrays.fill(player2, this.emptyCell);
	}

	/***********
	 * METHODS *
	 ***********/

	/**
	 * Displays the scoreCards of the two players
	 */
	public String toString() {
		String horzDivider = "|---------------------|--------|--------|";
		String output = horzDivider + "\n|                     |Player 1|Player 2|\n" + horzDivider + "\n";
		String[] board = { "|(1)  Ones            |   ", "|(2)  Twos            |   ", "|(3)  Threes          |   ",
				"|(4)  Fours           |   ", "|(5)  Fives           |   ", "|(6)  Sixes           |   ",
				"|     Sum             |   ", "|     Bonus           |   ", "|(7)  Three of a Kind |   ",
				"|(8)  Four of a Kind  |   ", "|(9)  Full House      |   ", "|(10) Small Straight  |   ",
				"|(11) Large Straight  |   ", "|(12) Chance          |   ", "|(13) Yahtzee         |   ",
				"|     Total           |  " };
		for (int i = 0; i < board.length; i++) {
			String scoreP1 = "";
			String scoreP2 = "";
			output += board[i] + "\n" + horzDivider + "\n";

		}

		return output;
	}
}
