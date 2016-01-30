package se.johannalynn.google.codejam.y2008.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C_Mousetrap_unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1b/";
	private static final String OUT_PATH = "out/y2008/r1b/";
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
		int t = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < t; i++) {
			int k = Integer.valueOf(in.nextLine());
			String[] tmp = in.nextLine().split(" ");
			int n = Integer.valueOf(tmp[0]);
			int[] d = new int[n];
			for(int j = 0; j < n; j++) {
				d[j] = Integer.valueOf(tmp[1+j]);
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(solve(k, n, d));
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
	
	private static String solve(int k, int n, int[] d) {
		StringBuffer buffer = new StringBuffer();
		
		int[] deck = new int[k];
		List<Integer> pointers = new ArrayList<Integer>();
		for(int i=0; i<k; i++) {
			pointers.add(i);
		}
		
		int p = 0;
		int pointer = pointers.get(p);
		int counter = 1;
		int card = 1;
		
		while(card <= k) {
			if(card == counter) {
				System.out.println(card + " at " + pointer);
				//deck[pointer] = card;
				card++;
				counter = 1;
				pointers.remove(p);
				p = 0;
			} else {
				counter++;
			}
			p++;
			if(p >= pointers.size() - 1) {
				p = 0;
			}
			pointer = pointers.get(p);
		}
		
		for(int s = 0; s < n; s++) {
			int index = d[s];
			buffer.append(deck[index-1] + " ");
		}
		return buffer.toString();
	}
}
