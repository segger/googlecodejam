package se.johannalynn.google.codejam.y2013.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Tic-Tac-Toe-Tomek is a game played on a 4 x 4 square board. The board starts empty,
 * except that a single 'T' symbol may appear in one of the 16 squares.
 * There are two players: X and O. They take turns to make moves, with X starting.
 * In each move a player puts her symbol in one of the empty squares. Player X's symbol is
 * 'X', and player O's symbol is 'O'.

After a player's move, if there is a row, column or a diagonal containing 4 of that player's
symbols, or containing 3 of her symbols and the 'T' symbol, she wins and the game ends.
Otherwise the game continues with the other player's move. If all of the fields are filled
with symbols and nobody won, the game ends in a draw. See the sample input for examples of
various winning positions.

Given a 4 x 4 board description containing 'X', 'O', 'T' and '.' characters (where '.'
represents an empty square), describing the current state of a game, determine the status of
the Tic-Tac-Toe-Tomek game going on. The statuses to choose from are:

"X won" (the game is over, and X won)
"O won" (the game is over, and O won)
"Draw" (the game is over, and it ended in a draw)
"Game has not completed" (the game is not over yet)
If there are empty cells, and the game is not over, you should output "Game has not completed",
even if the outcome of the game is inevitable.

Input

The first line of the input gives the number of test cases, T. T test cases follow.
Each test case consists of 4 lines with 4 characters each, with each character being 'X', 'O', '.'
or 'T' (quotes for clarity only). Each test case is followed by an empty line.

Output

For each test case, output one line containing "Case #x: y", where x is the case number
(starting from 1) and y is one of the statuses given above. Make sure to get the statuses
exactly right. When you run your code on the sample input, it should create the sample output
exactly, including the "Case #1: ", the capital letter "O" rather than the number "0", and so on.

Limits

The game board provided will represent a valid state that was reached through play of the game
Tic-Tac-Toe-Tomek as described above.

Small dataset

1 ≤ T ≤ 10.

Large dataset

1 ≤ T ≤ 1000.
 * @author segger
 *
 */
public class A_TickTackToeTomek {
	private static final String YEAR = "y2013";
	private static final String ROUND = "qual";
	
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";
	
	//private static final String FILE = "A";
	private static final String FILE = "A-large-practice";
	private static final String IN_FILE = FILE + ".in";
	private static final String OUT_FILE = FILE + ".out";

	private static final String O_WON = "O won";
	private static final String X_WON = "X won";
	private static final String DRAW = "Draw";
	private static final String NOT_COMPLETE = "Game has not completed";
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String inFileName = IN_PATH + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));

		StringBuffer buffer = new StringBuffer();
		
		// read in start
		int n = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < n; i++) {
			String[][] board = new String[4][4];
			for(int row = 0; row < 4; row++) {
				String nextLine = in.nextLine();
				String[] colLine = nextLine.split("");
				for(int col = 1; col <= 4; col++) {
					board[row][col-1] = colLine[col];
				}
			}
			
			try {
				in.nextLine();
			} catch (NoSuchElementException e) {
				//last case
			}
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(board));
			buffer.append("\n");
		}
		in.close();

		// print to file
		String outFileName = OUT_PATH + OUT_FILE;
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(
				outFileName)));
		out.write(buffer.toString());
		out.close();
	}
	
	private static String calc(String[][] board) {
		boolean finished = true;
		
		int[] nbrOfODiag = new int[2];
		int[] nbrOfXDiag = new int[2];
		int[] nbrOfOCol = new int[4];
		int[] nbrOfXCol = new int[4];
		for(int i = 0; i < 4; i++) {
			int nbrOfORow = 0;
			int nbrOfXRow = 0;
			for(int j=0; j < 4; j++) {
				String sign = board[i][j];
				if(sign.equalsIgnoreCase("T")) {
					nbrOfORow++;
					nbrOfXRow++;
					nbrOfXCol[j]++;
					nbrOfOCol[j]++;
					if(diag(i, j, true)) {
						nbrOfXDiag[0]++;
						nbrOfODiag[0]++;
					}
					if(diag(i, j, false)) {
						nbrOfXDiag[1]++;
						nbrOfODiag[1]++;
					}
				} else if(sign.equalsIgnoreCase("X")) {
					nbrOfXRow++;
					nbrOfXCol[j]++;
					if(diag(i, j, true)) nbrOfXDiag[0]++;
					if(diag(i, j, false)) nbrOfXDiag[1]++;
				} else if(sign.equalsIgnoreCase("O")) {
					nbrOfORow++;
					nbrOfOCol[j]++;
					if(diag(i, j, true)) nbrOfODiag[0]++;
					if(diag(i, j, false)) nbrOfODiag[1]++;
				} else {
					finished = false;
				}
			}
			if(nbrOfXRow == 4) return X_WON;
			if(nbrOfORow == 4) return O_WON;
		}
		
		for(int k=0; k < 4; k++) {
			if(nbrOfXCol[k] == 4) return X_WON;
			if(nbrOfOCol[k] == 4) {
				return O_WON;
			}
		}
		for(int m=0; m < 2; m++) {
			if(nbrOfODiag[m] == 4) return O_WON;
			if(nbrOfXDiag[m] == 4) return X_WON;
		}
		
		if(finished) {
			return DRAW;
		} else {
			return NOT_COMPLETE;
		}
	}
	
	private static boolean diag(int i, int j, boolean one) {
		if(one) {
			if(i==0 && j==0) return true;
			if(i==1 && j==1) return true;
			if(i==2 && j==2) return true;
			if(i==3 && j==3) return true;
			return false;
		} else {
			if(i==0 && j==3) return true;
			if(i==1 && j==2) return true;
			if(i==2 && j==1) return true;
			if(i==3 && j==0) return true;
			return false;
		}
	}
}