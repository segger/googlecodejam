package se.johannalynn.google.codejam.y2013.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Alice and Bob have a lawn in front of their house, shaped like an N metre by M metre rectangle.
 * Each year, they try to cut the lawn in some interesting pattern. They used to do their cutting
 * with shears, which was very time-consuming; but now they have a new automatic lawnmower with
 * multiple settings, and they want to try it out.

The new lawnmower has a height setting - you can set it to any height h between 1 and 100 millimetres,
and it will cut all the grass higher than h it encounters to height h. You run it by entering the
lawn at any part of the edge of the lawn; then the lawnmower goes in a straight line, perpendicular
to the edge of the lawn it entered, cutting grass in a swath 1m wide, until it exits the lawn on the
other side. The lawnmower's height can be set only when it is not on the lawn.

Alice and Bob have a number of various patterns of grass that they could have on their lawn. For each
of those, they want to know whether it's possible to cut the grass into this pattern with their new
lawnmower. Each pattern is described by specifying the height of the grass on each 1m x 1m square of
the lawn.

The grass is initially 100mm high on the whole lawn.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case
begins with a line containing two integers: N and M. Next follow N lines, with the ith line containing
M integers ai,j each, the number ai,j describing the desired height of the grass in the jth square of
the ith row.

Output

For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1)
and y is either the word "YES" if it's possible to get the x-th pattern using the lawnmower, or "NO",
if it's impossible (quotes for clarity only).

Limits

1 ≤ T ≤ 100.

Small dataset

1 ≤ N, M ≤ 10.
1 ≤ ai,j ≤ 2.
Large dataset

1 ≤ N, M ≤ 100.
1 ≤ ai,j ≤ 100.

 * @author segger
 *
 */
public class B_Lawnmover_unsolved {
	private static final String YEAR = "y2013";
	private static final String ROUND = "qual";
	
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";
	
	private static final String IN_FILE = "B.in";
	private static final String OUT_FILE = "B.out";

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
			String[] tmp = in.nextLine().split(" ");
			int N = Integer.valueOf(tmp[0]);
			int M = Integer.valueOf(tmp[1]);
			int[][] lawn = new int[N][M];
			for(int n = 0; n < N; n++) {
				String[] line = in.nextLine().split(" ");
				for(int m = 0; m < M; m++) {
					lawn[n][m] = Integer.valueOf(line[m]);
				}
			}
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(N, M, lawn));
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
	
	private static String calc(int N, int M, int[][] lawn) {
		
		return "YES";
	}
}