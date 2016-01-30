package se.johannalynn.google.codejam.y2008.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class B_Number_Sets_unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1b/";
	private static final String OUT_PATH = "out/y2008/r1b/";
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
		int c = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < c; i++) {
			String[] tmp = in.nextLine().split(" ");
			BigInteger A = new BigInteger(tmp[0]);
			BigInteger B = new BigInteger(tmp[1]);
			BigInteger P = new BigInteger(tmp[2]);
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(solve(A, B, P));
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
	
	private static String solve(BigInteger A, BigInteger B, BigInteger P) {
		return "42";
	}
}
