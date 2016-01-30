package se.johannalynn.google.codejam.y2008.r1c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class C_IncreasingSpeadLimits {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1c/";
	private static final String OUT_PATH = "out/y2008/r1c/";
	private static final String IN_FILE = "C.in";
	private static final String OUT_FILE = "C.out";

	private static final long sMod = 1000000007L;
	
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
			String[] tmp = in.nextLine().split(" ");
			int n = Integer.valueOf(tmp[0]);
			int m = Integer.valueOf(tmp[1]);
			long X = Long.parseLong(tmp[2]);
			long Y = Long.parseLong(tmp[3]);
			long Z = Long.parseLong(tmp[4]);
			
			long[] A = new long[m];
			for(int j=0; j<m; j++) {
				A[j] = Long.parseLong(in.nextLine());
			}
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(n, m, X, Y, Z, A));
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
	
	private static long calc(int n, int m, long X, long Y, long Z, long[] A) {
		long[] seq = generateSeq(n, m, X, Y, Z, A);
		long nbrOfSeqs = n; //single sign
		
		
		
		return nbrOfSeqs%sMod;
	}
	
	private static long[] generateSeq(int n, int m, long X, long Y, long Z, long[] A) {
		long[] seq = new long[n];
		for(int i=0; i<n; i++) {
			seq[i] = A[i%m];
			A[i%m] = (X*A[i%m] + Y*(i+1))%Z;
		}
		return seq;
	}
}
