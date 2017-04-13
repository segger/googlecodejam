package se.johannalynn.google.codejam.y2016.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * On the game show The Last Word, the host begins a round by showing the contestant a string S of
 * uppercase English letters. The contestant has a whiteboard which is initially blank. The host will
 * then present the contestant with the letters of S, one by one, in the order in which they appear in S.
 * When the host presents the first letter, the contestant writes it on the whiteboard; this counts as
 * the first word in the game (even though it is only one letter long). After that, each time the host
 * presents a letter, the contestant must write it at the beginning or the end of the word on the
 * whiteboard before the host moves on to the next letter (or to the end of the game, if there are
 * no more letters).

For example, for S = CAB, after writing the word C on the whiteboard, the contestant could make one
of the following four sets of choices:

put the A before C to form AC, then put the B before AC to form BAC
put the A before C to form AC, then put the B after AC to form ACB
put the A after C to form CA, then put the B before CA to form BCA
put the A after C to form CA, then put the B after CA to form CAB
The word is called the last word when the contestant finishes writing all of the letters from S,
under the given rules. The contestant wins the game if their last word is the last of an alphabetically
sorted list of all of the possible last words that could have been produced. For the example above,
the winning last word is CAB (which happens to be the same as the original word). For a game with S = JAM,
the winning last word is MJA.

You are the next contestant on this show, and the host has just showed you the string S. What's the
winning last word that you should produce?


 * @author segger
 *
 */
public class A_TheLastWord_unsolved {
	private static final String YEAR = "y2016";
	private static final String ROUND = "r1a";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = "out/";
	
	private static final String FILE = "A";
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
			buffer.append(calc(in.nextLine().toCharArray()));
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
	
	private static String calc(char[] input) {
		
		char start = input[0];
		for(int i = 0; i < input.length; i++) {
			
		}
		//return input;
		return null;
	}
}
