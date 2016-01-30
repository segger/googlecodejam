package se.johannalynn.google.codejam.y2014.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B_Unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/r1b/";
	private static final String OUT_PATH = "out/y2014/r1b/";
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
		int n = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < n; i++) {
			String[] tmp = in.nextLine().split(" ");
			long A = Long.valueOf(tmp[0]);
			long B = Long.valueOf(tmp[1]);
			long K = Long.valueOf(tmp[2]);
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(A, B, K));
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
	
	private static long calc(long A, long B, long K) {
		long calc = 0;
		for(long i=0; i<A; i++) {
			for(long j=0; j<B; j++) {
				long result = i&j;
				if(result < K) {
					calc++;
				}
			}
		}
		
		return calc;
	}
	
	class Tmp {
		//generate all possible result from 0 to 10⁹
	}
}
