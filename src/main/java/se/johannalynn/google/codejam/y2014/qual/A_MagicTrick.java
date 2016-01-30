package se.johannalynn.google.codejam.y2014.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A_MagicTrick {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/qual/";
	private static final String OUT_PATH = "out/y2014/qual/";
	private static final String IN_FILE = "A-small-attempt0.in";
	private static final String OUT_FILE = "A-small-attempt0.out";

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
			
			int a = Integer.valueOf(in.nextLine());
			int[][] first = new int[4][4];
			for(int j=0; j<4; j++) {
				String[] row = in.nextLine().split(" ");
				int[] split = new int[4];
				for(int m = 0; m<4; m++) {
					split[m] = Integer.valueOf(row[m]);
				}
				first[j] = split;
			}
			int b = Integer.valueOf(in.nextLine());
			int[][] second = new int[4][4];
			for(int j2=0; j2<4; j2++) {
				String[] row2 = in.nextLine().split(" ");
				int[] split2 = new int[4];
				for(int m2 = 0; m2<4; m2++) {
					split2[m2] = Integer.valueOf(row2[m2]);
				}
				second[j2] = split2;
			}
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(a, b, first, second));
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
	
	
	private static String calc(int a, int b, int[][] first, int[][] second) {
		final String MULTIPLE = "Bad magician!";
		final String NONE = "Volunteer cheated!";
		
		String retValue = NONE;
		
		int[] selected = first[a-1];
		int[] selected2 = second[b-1];
		for(int t : selected) {
			for(int p : selected2) {
				if(t == p) {
					if(retValue.equalsIgnoreCase(NONE)) {
						retValue = String.valueOf(t);
					} else {
						retValue = MULTIPLE;
					}
				}
			}
		}
		return retValue;
	}
}
