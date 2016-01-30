package se.johannalynn.google.codejam.y2009.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_unsolved {
	private static final String YEAR = "y2009";
	private static final String ROUND = "qual";
	
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
		//int n = Integer.valueOf(in.nextLine());
		String[] tmp = in.nextLine().split(" ");
		int l = Integer.valueOf(tmp[0]);
		int d = Integer.valueOf(tmp[1]);
		int n = Integer.valueOf(tmp[2]);
		//System.out.println(n);
		
		List<String[]> dict = new ArrayList<String[]>();
		for (int k = 0; k < d; k++) {
			String[] word = in.nextLine().split("");
			dict.add(word);
		}
		
		for (int i = 0; i < n; i++) {
			String[] testCase = in.nextLine().split("");
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(dict, d, testCase));
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
	
	private static String calc(List<String[]> dict, int d, String[] testCase) {
		int matches = 0;
		List<String[]> sublist = new ArrayList<String[]>();
		for(String[] temp : dict) {
			sublist.add(temp);
		}
		
		int j = 1;
		List<List<String>> founded = new ArrayList<List<String>>();
		for(int i=0; i<d; i++) {
			List<String> foundLetters = new ArrayList<String>();
			boolean found = false;
			boolean more = false;
			while(!found && j < testCase.length) {
				String letter = testCase[j];
				if(letter.equalsIgnoreCase("(")) {
					more = true;
					j++;
					continue;
				}
				if(letter.equalsIgnoreCase(")")) {
					more = false;
					found = true;
					j++;
					continue;
				}
				if(!more) {
					foundLetters.add(letter);
					found = true;
					j++;
					continue;
				}
				if(more) {
					foundLetters.add(letter);
					j++;
				}
			}
			
			founded.add(foundLetters);
		}
		
		return String.valueOf(matches);
	}
}
