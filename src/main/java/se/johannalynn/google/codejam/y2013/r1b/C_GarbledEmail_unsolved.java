package se.johannalynn.google.codejam.y2013.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Gagan just got an email from her friend Jorge. The email contains important information, but unfortunately
 * it was corrupted when it was sent: all of the spaces are missing, and after the removal of the spaces, some of the letters have been changed to other letters!
 * All Gagan has now is a string S of lower-case characters.

You know that the email was originally made out of words from the dictionary described below. You also know the
letters were changed after the spaces were removed, and that the difference between the indices of any two
letter changes is not less than 5. So for example, the string "code jam" could have become "codejam", "dodejbm",
"zodejan" or "cidejab", but not "kodezam" (because the distance between the indices of the "k" change and the
"z" change is only 4).

What is the minimum number of letters that could have been changed?

Dictionary

In order to solve this problem, you'll need an extra file: a special dictionary that you can find at
https://code.google.com/codejam/contest/static/garbled_email_dictionary.txt. It is not a dictionary from any
natural language, though it does contain some English words. Each line of the dictionary contains one word.
The dictionary file should be 3844492 bytes in size, contain 521196 words, start with the word "a", and end with
the word "zymuznh".

When you're submitting the code you used to solve this problem, you shouldn't include the dictionary. As usual,
however, you must submit all code you used to solve the problem.

Note that if you are using Windows and want to look at the dictionary file, you should avoid Notepad, and
instead use WordPad or another piece of software, or else all the words might appear on the same line.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists
of a single line containing a string S, consisting of lower-case characters a-z.

Output

For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and
y is the minimum number of letters that could have been changed in order to make S.

Limits

S is valid: it is possible to make it using the method described above.
Small dataset

1 ≤ T ≤ 20.
1 ≤ length of S ≤ 50.
Large dataset

1 ≤ T ≤ 4.
1 ≤ length of S ≤ 4000.


 * @author segger
 *
 */
public class C_GarbledEmail_unsolved {
	private static final String YEAR = "y2013";
	private static final String ROUND = "r1b";
	
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";
	
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
		int n = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(s));
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
	
	private static String calc(String s) {
		return null;
	}
}
