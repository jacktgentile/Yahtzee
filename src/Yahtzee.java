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
	 * @param indicator Which slot the player chose to score. Indicator will be checked
	 * for validity before calling this method.
	 * @param gameDice From call to player's dice getGameDice after sorting.
	 */
	public void setScore(final int indicator, final Dice gameDice, final int playerNum) {
		int[] p = player1;
		if (playerNum == 2) {
			p = player2;
		}
		int sum = 0;
		if (indicator <= 6) {
			sum = gameDice.sumOf(indicator);
			p[indicator - 1] = sum;
		}
		int[] diceArr = gameDice.getGameDice();
		switch (indicator) {
		case 7:
			//3 of a kind - add all die values
			if ((diceArr[0] == diceArr[1] && diceArr[0] == diceArr[2]) 
					|| (diceArr[1] == diceArr[2] && diceArr[1] == diceArr[3]) 
					|| (diceArr[2] == diceArr[3] && diceArr[2] == diceArr[4])) {
				sum = gameDice.sumOf(0);
			}
			p[8] = sum;
			return;
		case 8:
			//4 of a kind - add all die values
			if ((diceArr[0] == diceArr[1] && diceArr[0] == diceArr[2] && diceArr[0] == diceArr[3]) 
					|| (diceArr[4] == diceArr[1] && diceArr[4] == diceArr[2] && diceArr[4] == diceArr[3])) {
				sum = gameDice.sumOf(0);
			}
			p[9] = sum;
			return;
		case 9:
			//full house - 25
			if (diceArr[0] == diceArr[1] && diceArr[3] == diceArr[4]) {
				if (diceArr[0] == diceArr[2] || diceArr[4] == diceArr[2]) {
					sum = 25;
				}
			}
			p[10] = sum;
			return;
		case 10:
			//small straight of 4 - 30
			int min = diceArr[0];
			if (gameDice.contains(min+1) && gameDice.contains(min+2) 
					&& gameDice.contains(min+3)) {
				sum = 30;
			}
			min = diceArr[1];
			if (gameDice.contains(min+1) && gameDice.contains(min+2) 
					&& gameDice.contains(min+3)) {
				sum = 30;
			}
			p[11] = sum;
			return;
		case 11:
			//large straight of 4 - 40
			boolean flag = true;
			for (int i = 0; i < diceArr.length - 1; i++) {
				if (diceArr[i] + 1 != diceArr[i + 1]) {
					flag = false;
				}
			}
			if (flag) {
				sum = 40;
			}
			p[12] = sum;
			return;
		case 12:
			//chance
			p[13] = gameDice.sumOf(0);
			return;
		case 13:
			//yahtzee
			for (int i: gameDice.getGameDice()) {
				if (i != gameDice.getGameDice()[0]) {
					p[14] = 0;
					return;
				}
			}
			if (p[14] == emptyCell) {
				p[14] = 50;
				return;
			} else if (p[14] == 50) {
				if (p[7] == emptyCell) {
					p[7] = 100;
					return;
				}
				p[7] += 100;
				return;
			}
		}
	}

	/**
	 * determine whether an indicator value is valid for a given player.
	 * must be in the range [1,13] and (except for 13) value in player array must be emptyCell.
	 * @param indicator
	 * @param playerNum
	 * @return true if value is valid
	 */
	public boolean isValidChoice(final int indicator, final int playerNum) {
		if (indicator < 1 || indicator > 13) {
			return false;
		}
		int[] p = player1;
		if (playerNum == 2) {
			p = player2;
		}
		if (indicator < 6 && p[indicator-1] == emptyCell) {
			return true;
		}
		if (indicator > 5 && p[indicator+1] == emptyCell) {
			return true;
		}
		//special case for yahtzee with bonus points
		if (indicator == 13) {
			if (p[14] == 50) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Displays the scoreCards of the two players
	 */
	public String toString() {
		this.updateTotals();
		String horzDivider = "|---------------------|--------|--------|";
		String output = horzDivider + "\n|                     |Player 1|Player 2|\n" + horzDivider + "\n";
		String[] board = { "|(1)  Ones            |   ", "|(2)  Twos            |   ", "|(3)  Threes          |   ",
				"|(4)  Fours           |   ", "|(5)  Fives           |   ", "|(6)  Sixes           |   ",
				"|     Sum             |   ", "|     Bonus           |   ", "|(7)  Three of a Kind |   ",
				"|(8)  Four of a Kind  |   ", "|(9)  Full House      |   ", "|(10) Small Straight  |   ",
				"|(11) Large Straight  |   ", "|(12) Chance          |   ", "|(13) Yahtzee         |   ",
				"|     Total           |   " };
		for (int i = 0; i < player1.length; i++) {
			String scoreP1 = "";
			String scoreP2 = "";
			if(player1[i] == this.emptyCell) {
				scoreP1 = "     |   ";
			} else {
				if(player1[i] / 10 == 0) {
					scoreP1 = player1[i] + "    |   ";
				} else {
					scoreP1 = player1[i] + "   |   ";
				}
			}
			
			if(player2[i] == this.emptyCell) {
				scoreP2 = "     |";
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

	public void updateTotals() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < 6; i++) {
			if (player1[i] != emptyCell) {
				sum1 += player1[i];
			}
			if (player2[i] != emptyCell) {
				sum2 += player2[i];
			}
		}
		player1[6] = sum1;
		if (sum1 >= 63) {
			player1[7] = 35;
		}
		player2[6] = sum2;
		if (sum2 >= 63) {
			player2[7] = 35;
		}
		for (int i = 8; i < 15; i++) {
			if (player1[i] != emptyCell) {
				sum1 += player1[i];
			}
			if (player2[i] != emptyCell) {
				sum2 += player2[i];
			}
		}
		player1[15] = sum1;
		player2[15] = sum2;
	}
	
}








