package se.johannalynn.google.codejam.y2008.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_Milkshakes {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1a/";
	private static final String OUT_PATH = "out/y2008/r1a/";
	private static final String IN_FILE = "B-large-practice.in";
	private static final String OUT_FILE = "B-large-practice.out";

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
			int n = Integer.valueOf(in.nextLine());
			// System.out.println(n);
			int m = Integer.valueOf(in.nextLine());
			// System.out.println(m);
			List<List<int[]>> customers = new ArrayList<List<int[]>>();
			for (int j = 0; j < m; j++) {
				String[] m_tmp = in.nextLine().split(" ");
				int t = Integer.valueOf(m_tmp[0]);
				// System.out.print(t + ": ");
				List<int[]> likes = new ArrayList<int[]>();
				for (int k = 0; k < t; k++) {
					int[] tmp = new int[2];
					tmp[0] = Integer.valueOf(m_tmp[1 + 2 * k]);
					tmp[1] = Integer.valueOf(m_tmp[1 + 2 * k + 1]);
					// System.out.print(tmp[0] + ", " + tmp[1]);
					likes.add(tmp);
				}
				// System.out.println();
				/*
				 * Collections.sort(likes, new Comparator<int[]>() {
				 * 
				 * @Override public int compare(int[] o1, int[] o2) { return
				 * o1[1] - o2[1]; }
				 * 
				 * });
				 */
				customers.add(likes);
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(solve(n, customers));
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

	private static String solve(int n, List<List<int[]>> customers) {
		StringBuffer buffer = new StringBuffer();

		boolean[] malted = new boolean[n];
		boolean done = false;
		boolean impossible = false;
		int c = 0;
		while (!done) {
			List<int[]> tmp = customers.get(c);
			if (!isSatisfied(tmp, malted)) {
				if (malt(tmp, malted)) {
					c = 0;
				} else {
					done = true;
					impossible = true;
				}
			} else {
				c++;
			}
			if (c >= customers.size()) {
				done = true;
			}
		}

		if (!impossible) {
			for (boolean b : malted) {
				if (b) {
					buffer.append("1");
				} else {
					buffer.append("0");
				}
				buffer.append(" ");
			}
		} else {
			buffer.append("IMPOSSIBLE");
		}

		return buffer.toString();
	}

	private static boolean isSatisfied(List<int[]> preferences, boolean[] malted) {
		for (int[] f : preferences) {
			boolean isMalted = malted[f[0] - 1];
			if ((f[1] == 0 && !isMalted) || (f[1] == 1 && isMalted)) {
				return true;
			}
		}
		return false;
	}

	private static boolean malt(List<int[]> preferences, boolean[] malted) {
		for (int[] f : preferences) {
			if (f[1] == 1 && !malted[f[0] - 1]) {
				malted[f[0] - 1] = true;
				return true;
			}
		}
		return false;
	}
}
