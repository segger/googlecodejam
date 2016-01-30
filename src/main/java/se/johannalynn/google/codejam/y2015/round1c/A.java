package se.johannalynn.google.codejam.y2015.round1c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A {
	private static final String YEAR = "y2015";
	private static final String ROUND = "round1c";
	
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";
	
	private static final String IN_FILE = "A.in";
	private static final String OUT_FILE = "A.out";

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
			int r = Integer.valueOf(tmp[0]);
			int c = Integer.valueOf(tmp[1]);
			int w = Integer.valueOf(tmp[2]);
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(r, c, w));
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

	private static String calc(int r, int c, int w) {
		System.out.println("calc!");
		int turns = 0;
		turns = hitting(w, c);
		System.out.println("turns: " + turns);
		turns *= r;
		System.out.println();
		return String.valueOf(turns);
	}
	
	private static int hitting(int w, int c) {
		System.out.println("w: " + w + ", c: " + c);
		if(w == c || w == 1) {
			return c;
		} else if(w == 0) {
			return 1;
		} else {
			int hits = 0;
			int halfC = c/2;
			if(w > halfC) {
				hits += halfC;
				if(c%2 == 0) {
					hits += hitting(w-halfC, halfC-1);	
				} else {
					hits += hitting(w-halfC, halfC);
				}
			} else {
				hits += hitting(w, halfC);
				if(c%2 == 0) {
					hits += hitting(w, halfC);
				} else {
					hits += hitting(w, halfC-1);
				}
			}
			return hits;
		}
	}
	
	private static int hits(int w, int c) {
		System.out.println("w: " + w + ", c: " + c);
		if(w == c || w == 1 || c == 1) {
			return c;
		} else {
			int round = 0;
			int halfC = c/2;
			if(w > halfC) { //hit
				if(c % 2 == 0) {
					round += hits(w-1, halfC-1);
				} else {
					round += hits(w-1, halfC);
				}
				round += halfC-1;
			} else {
				round += hits(w, halfC);
				if(c % 2 == 0) {
					round += hits(w, halfC-1);
				} else {
					round += hits(w, halfC);
				}
			}
			return round;
		}
	}
	
	private static int hit(int w, int wLeft, int c) {
		System.out.println("w: " + w + ", c: " + c);
		if(w == c || w == 1 || c-1 == w) {
			return c;
		} else if(c == 1) {
			return 1;
		} else {
			int halfC = c/2;
			System.out.println("halfC: " + halfC);
			int turns = hit(w, w-1, halfC-1);
			if(wLeft > halfC) {
				turns += halfC;
			} else {
				int miss = 0;
				if(c % 2 == 0) {
					miss += hit(w, w, halfC-1);	
				} else {
					miss += hit(w, w, halfC);
				}
				turns += miss;
			}
			System.out.println("turns i: " + turns);
			return turns;
		}
	}
}
