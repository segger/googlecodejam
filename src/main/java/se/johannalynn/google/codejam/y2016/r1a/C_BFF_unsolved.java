package se.johannalynn.google.codejam.y2016.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * You are a teacher at the brand new Little Coders kindergarten. You have N kids in your class, and each
 * one has a different student ID number from 1 through N. Every kid in your class has a single best
 * friend forever (BFF), and you know who that BFF is for each kid. BFFs are not necessarily reciprocal --
 * that is, B being A's BFF does not imply that A is B's BFF.

Your lesson plan for tomorrow includes an activity in which the participants must sit in a circle.
You want to make the activity as successful as possible by building the largest possible circle of
kids such that each kid in the circle is sitting directly next to their BFF, either to the left or to the
right. Any kids not in the circle will watch the activity without participating.

What is the greatest number of kids that can be in the circle?
 * @author segger
 *
 */
public class C_BFF_unsolved {
	private static final String YEAR = "y2016";
	private static final String ROUND = "r1a";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = "out/";
	
	private static final String FILE = "C";
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
