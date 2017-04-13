package se.johannalynn.google.codejam.y2016.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * When Sergeant Argus's army assembles for drilling, they stand in the shape of an N by N square grid,
 * with exactly one soldier in each cell. Each soldier has a certain height.

Argus believes that it is important to keep an eye on all of his soldiers at all times. Since he likes
to look at the grid from the upper left, he requires that:

Within every row of the grid, the soldiers' heights must be in strictly increasing order, from left to right.
Within every column of the grid, the soldiers' heights must be in strictly increasing order, from top to bottom.
Although no two soldiers in the same row or column may have the same height, it is possible for multiple
soldiers in the grid to have the same height.

Since soldiers sometimes train separately with their row or their column, Argus has asked you to make a
report consisting of 2*N lists of the soldiers' heights: one representing each row (in left-to-right order)
and column (in top-to-bottom order). As you surveyed the soldiers, you only had small pieces of paper to
write on, so you wrote each list on a separate piece of paper. However, on your way back to your office,
you were startled by a loud bugle blast and you dropped all of the pieces of paper, and the wind blew one
away before you could recover it! The other pieces of paper are now in no particular order, and you can't
even remember which lists represent rows and which represent columns, since you didn't write that down.

You know that Argus will make you do hundreds of push-ups if you give him an incomplete report. Can you
figure out what the missing list is?


 * @author segger
 *
 */
public class B_RankAndFile_unsolved {
	private static final String YEAR = "y2016";
	private static final String ROUND = "r1a";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = "out/";
	
	private static final String FILE = "B-practice";
	private static final String IN_FILE = FILE + ".in";
	private static final String OUT_FILE = FILE + ".out";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String inFileName = IN_PATH + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));

		StringBuffer buffer = new StringBuffer();
		
		// read in start
		int T = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < T; i++) {
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			//buffer.append(calc());
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
}
