package se.johannalynn.google.codejam.y2017.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class C {
	private static final String YEAR = "y2017";
	private static final String ROUND = "qual";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/";
	
	private static final String FILE = "C-large";
	//private static final String FILE = "C";
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
			String[] input = in.nextLine().split(" ");
			//BigInteger N = new BigInteger(input[0]);
			long N = Long.valueOf(input[0]);
			//BigInteger K = new BigInteger(input[1]);
			long K = Long.valueOf(input[1]);
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			String result = calc(N, K);
			System.out.println(result);
			buffer.append(result);
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
	
	private static String calc(long N, long K) {
		System.out.println("N: " + N + ", K: " + K);
		
		if(K == N) {
			return "0 0";
		}
		if(K == 1) {
			long middle = N / 2;
			long min = middle;
			if(N % 2 == 0) {
				min = middle - 1;
			}
			return middle + " " + min; 
		}
		
		long base2ofK = (long)Math.floor(Math.log(K) / Math.log(2.0));
		long split_with = (long)Math.pow(2, base2ofK);
		long diff = K - split_with;
		long N_diff = N % split_with;
		
		long max_array_size = N / split_with;
		long new_array_size = max_array_size - 1;
		
		long array_size = (diff <= N_diff) ? max_array_size : new_array_size;
		
		System.out.println("    2 ^ " + base2ofK + " = " + split_with + " : " + array_size);
		
		long middle = array_size / 2;
		long max = middle;
		long min = middle;
		if(array_size % 2 == 0) {
			min = middle - 1;
		}
		
		return String.valueOf(max) + " " + String.valueOf(min);
	}
}
