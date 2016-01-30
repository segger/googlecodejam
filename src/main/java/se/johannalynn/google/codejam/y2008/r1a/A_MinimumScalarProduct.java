package se.johannalynn.google.codejam.y2008.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A_MinimumScalarProduct {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1a/";
	private static final String OUT_PATH = "out/y2008/r1a/";
	
	private static final String IN_FILE = "A-large-practice.in";
	private static final String OUT_FILE = "A-large-practice.out";

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
			int t = Integer.valueOf(in.nextLine());
			Integer[] v1 = new Integer[t];
			String[] v1_tmp = in.nextLine().split(" ");
			for(int j = 0; j < t; j++) {
				v1[j] = Integer.valueOf(v1_tmp[j]);
			}
			Arrays.sort(v1);
			String[] v2_tmp = in.nextLine().split(" ");
			Integer[] v2 = new Integer[t];
			for(int k = 0; k < t; k++) {
				v2[k] = Integer.valueOf(v2_tmp[k]);
			}
			Arrays.sort(v2, new Comparator<Integer>() {

				@Override
				public int compare(Integer x, Integer y) {
					return y - x;
				}
				
			});
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(solve(v1, v2));
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
	
	private static String solve(Integer[] v1, Integer[] v2) {
		BigInteger scalarProduct = BigInteger.ZERO;
		for(int i = 0; i < v1.length; i++) {
			BigInteger v1i = new BigInteger(String.valueOf(v1[i]));
			BigInteger v2i = new BigInteger(String.valueOf(v2[i]));
			BigInteger mult = v1i.multiply(v2i);
			scalarProduct = scalarProduct.add(mult);
		}
		return scalarProduct.toString();
	}
}
