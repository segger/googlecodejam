package se.johannalynn.google.codejam.y2015.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2015/qual/";
	private static final String OUT_PATH = "out/y2015/qual/";
	
	private static final String IN_FILE = "A-large.in";
	private static final String OUT_FILE = "A-large.out";

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
			int s_max = Integer.valueOf(tmp[0]);
			
			String[] tmp2 = tmp[1].split("");
			
			int[] person = new int[s_max+1];
			for(int j=0; j<tmp2.length-1; j++) {
				person[j] = Integer.valueOf(tmp2[j+1]);
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(s_max, person));
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
	
	private static String calc(int max, int[] persons) {
		int addedPersons = 0;
		int standing = 0;
		int i = 0;
		while(i < max+1) {
			if(standing >= i) {
				standing += persons[i];
				i++;
			} else {
				addedPersons++;
				standing++;
			}
		}
		return String.valueOf(addedPersons);
	}
}
