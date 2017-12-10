/**
 * @author Vincent Hu, Jack Gentile
 *
 */

/**
 * Class to manage the rules and functions of the game. Controls overall game flow.
 */
public class Yahtzee {
	/**********************
	 * INSTANCE VARIABLES *
	 **********************/
	
	/**
	 * True represents scoring methods used by each player.
	 */
	boolean[][] possibleScores;
	
	/**
	 * Representations of the scoring categories to be displayed to the user.
	 */
	final String[] categories = {
			"A Ones-------------",
			"B Twos-------------",
			"C Threes-----------",
			"D Fours------------",
			"E Fives------------",
			"F Sixes------------",
			"G Three of a kind--",
			"H Four of a kind---",
			"I Full House-------",
			"J Small Straight---",
			"K Large Straight---",
			"L Yahtzee----------",
			"M Chance-----------"
	};
	
	/****************
	 * CONSTRUCTORS *
	 ****************/
	
	
	public Yahtzee() {
		possibleScores = new boolean[2][13];
		
	}
	
	/***********
	 * METHODS *
	 ***********/
	
	/**
	 * Displays to the user possible scores that they could get using any category not already used.
	 * @param gameDice array of dice values unsorted
	 */
	public void showScores(final int[] gameDice) {
		int[] sortedDice = this.sortDice(gameDice);
		
	}
	
	/**
	 * Helper method to sort dice, making it easier to score.
	 * 
	 * @param gameDice Unsorted array of die values
	 * @return Sorted deep copy of the array
	 */
	private int[] sortDice(final int[] gameDice) {
		int[] result = new int[gameDice.length];
		for (int i = 0; i < gameDice.length; i++) {
			result[i] = gameDice[i];
		}
		for (int j = 0; j < result.length - 1; j++) {
			int mindex = j;
			for (int k = j + 1; k < result.length; k++) {
				if (result[k] < result[mindex]) {
					mindex = k;
				}
			}
			int temp = result[j];
			result[j] = result[mindex];
			result[mindex] = temp;
		}
		return result;
	}
}










