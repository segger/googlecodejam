package se.johannalynn.google.codejam.y2008.r1c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A_TextMessagingOutrage {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1c/";
	private static final String OUT_PATH = "out/y2008/r1c/";
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
			String[] tmp = in.nextLine().split(" ");
			int p = Integer.valueOf(tmp[0]);
			int k = Integer.valueOf(tmp[1]);
			int l = Integer.valueOf(tmp[2]);
			String[] tmp2 = in.nextLine().split(" ");
			List<Integer> freq = new ArrayList<Integer>();
			for(int j=0; j<l; j++) {
				freq.add(Integer.valueOf(tmp2[j]));
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(p, k, freq));
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
	
	private static String calc(int p, int k, List<Integer> freq) {
		BigInteger presses = BigInteger.ZERO;
		Collections.sort(freq);
		int[][] keyMult = new int[p][k];
		int mult = 1;
		for(int b = 0; b < p; b++) {
			for(int a = 0; a < k; a++) {
				keyMult[b][a] = mult;
			}
			mult++;
		}
		int[] keyMult2 = new int[p*k];
		int c = 0;
		for(int b = 0; b < p; b++) {
			for(int a = 0; a < k; a++) {
				keyMult2[c++] = keyMult[b][a];
			}
		}
		c = 0;
		for(int i = freq.size() - 1; i >= 0; i--) {
			int tmp_freq = freq.get(i);
			int tmp_mult = keyMult2[c++];
			int press_freq = tmp_freq * tmp_mult;
			presses = presses.add(new BigInteger(String.valueOf(press_freq)));
		}
		
		return presses.toString();
	}
}
