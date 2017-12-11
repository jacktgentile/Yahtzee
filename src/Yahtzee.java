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
	 * Will set the score of the slot chosen by the player.
	 * 
	 * <p> The values for the parameter are indicated in the score board print.
	 * Run the Game class to see the parameter and their matching score choice.
	 * 
	 * @param indicator Which slot the player chose to score.
	 */
	public void setScore(final int indicator) {
		
	}

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
				"|     Total           |   " };
		for (int i = 0; i < board.length; i++) {
			String scoreP1 = "";
			String scoreP2 = "";
			if(player1[i] == this.emptyCell) {
				scoreP1 = "     |";
			} else {
				if(player1[i] / 10 == 0) {
					scoreP1 = player1[i] + "    |   ";
				} else {
					scoreP1 = player1[i] + "   |   ";
				}
			}
			
			if(player2[i] == this.emptyCell) {
				scoreP2 = "        |";
			} else {
				if(player2[i] / 10 == 0) {
					scoreP2 = player2[i] + "    |";
				} else {
					scoreP2 = player2[i] + "   |";
				}
			}
			output += board[i] + scoreP1 + scoreP2 + "\n" + horzDivider + "\n";
		}
		return output;
	}
}
