package se.johannalynn.google.codejam.y2015.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2015/qual/";
	private static final String OUT_PATH = "out/y2015/qual/";
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
			int D = Integer.valueOf(in.nextLine());
			String[] tmp = in.nextLine().split(" ");
			List<Integer> plates = new ArrayList<Integer>();
			for(int p = 0; p < D; p++) {
				plates.add(Integer.valueOf(tmp[p]));
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(D, plates));
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
	
	private static String calc(int D, List<Integer> plates) {
		Collections.sort(plates);
		int max = Collections.max(plates);
		int[] persons = new int[max+1];
		for(Integer p : plates) {
			persons[p] += 1;
		}
		boolean done = false;
		int minutes = 0;
		int i = max;
		while(!done && i > 0) {
			int nbrOfPersons = persons[i];
			if(nbrOfPersons > 0) {
				int halfNbrOfPanncakes = i/2;
				if(nbrOfPersons < halfNbrOfPanncakes) {
					if(i%2==0) {
						persons[halfNbrOfPanncakes] += nbrOfPersons;	
					} else {
						persons[halfNbrOfPanncakes] += nbrOfPersons;
						persons[halfNbrOfPanncakes+1] += nbrOfPersons;
					}
					minutes += nbrOfPersons;
				} else {
					minutes += i;
					done = true;
				}
			}
			i--;
		}
		//System.out.println(minutes);
		return String.valueOf(minutes);
	}
}
