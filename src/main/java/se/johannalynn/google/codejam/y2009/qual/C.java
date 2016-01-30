package se.johannalynn.google.codejam.y2009.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * So you've registered. We sent you a welcoming email, to welcome you to code jam.
 * But it's possible that you still don't feel welcomed to code jam. That's why we
 * decided to name a problem "welcome to code jam". After solving this problem, we hope
 * that you'll feel very welcome. Very welcome, that is, to code jam.
 * 
 * If you read the previous paragraph, you're probably wondering why it's there. But
 * if you read it very carefully, you might notice that we have written the words "welcome
 * to code jam" several times: 400263727 times in total.
 * After all, it's easy to look through the paragraph and find a 'w'; then find an 'e'
 * later in the paragraph; then find an 'l' after that, and so on. Your task is to write a program
 * that can take any text and print out how many times that text contains the phrase "welcome
 * to code jam".
 * 
 * To be more precise, given a text string, you are to determine how many times the string
 * "welcome to code jam" appears as a sub-sequence of that string. In other words, find a
 * sequence s of increasing indices into the input string such that the concatenation of
 * input[s[0]], input[s[1]], ... , input[s[18]] is the string "welcome to code jam"
 * 
 * The result of your calculation might be huge, so for convenience we should only like you
 * to find the last 4 digits.
 * @author segger
 *
 */
public class C {
	private static final String YEAR = "y2009";
	private static final String ROUND = "qual";
	
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";
	
	private static final String IN_FILE = "C.in";
	private static final String OUT_FILE = "C.out";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String inFileName = IN_PATH + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));

		StringBuffer buffer = new StringBuffer();
		
		// read in start
		int N = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < N; i++) {
			String testCase = in.nextLine();
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(testCase));
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
	
	private static String calc(String testCase) {
		return "";
	}
}
