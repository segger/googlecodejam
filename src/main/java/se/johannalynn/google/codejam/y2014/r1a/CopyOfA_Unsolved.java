package se.johannalynn.google.codejam.y2014.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CopyOfA_Unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/r1a/";
	private static final String OUT_PATH = "out/y2014/r1a/";
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
			int N = Integer.valueOf(tmp[0]);
			int L = Integer.valueOf(tmp[1]);
			String[] tmp2 = in.nextLine().split(" ");
			String[] tmp3 = in.nextLine().split(" ");

			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(N, L, tmp2, tmp3));
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

	private static boolean possible(String[] devices, HashSet<String> switched) {
		for (String device : devices) {
			if (!switched.contains(device)) {
				return false;
			}
		}
		return true;
	}

	private static String calc(int N, int L, String[] initial, String[] devices) {
		final String NOT_POSSIBLE = "NOT POSSIBLE";
		//int maxNbr = (int)Math.pow(2, L);
		
		int[][] NLcharge = new int[N][L];
		int[][] NLdevice = new int[N][L];
		
		int[] jCountCharge = new int[L];
		int[] jCountDevice = new int[L];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<L; j++) {
				NLcharge[i][j] = Integer.parseInt(initial[i].substring(j, j+1));
				NLdevice[i][j] = Integer.parseInt(devices[i].substring(j, j+1));
				if(NLcharge[i][j] == 1) {
					jCountCharge[j]++;
				}
				if(NLdevice[i][j] == 1) {
					jCountDevice[j]++;
				}
			}
		}
		
		int counter = 0;
		
		return String.valueOf(counter);
	}
}
