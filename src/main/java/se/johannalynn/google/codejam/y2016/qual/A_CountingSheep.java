package se.johannalynn.google.codejam.y2016.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will fall asleep.

Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose that Bleatrix picks N = 1692. She would count as follows:

N = 1692. Now she has seen the digits 1, 2, 6, and 9.
2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
3N = 5076. Now she has seen all ten digits, and falls asleep.
What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.

Sample

Input 
5
0
1
2
11
1692

Output
Case #1: INSOMNIA
Case #2: 10
Case #3: 90
Case #4: 110
Case #5: 5076



 * @author segger
 *
 */
public class A_CountingSheep {
	private static final String YEAR = "y2016";
	private static final String ROUND = "qual";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	
	private static final String FILE = "A-large-practice";
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
			int N = Integer.valueOf(in.nextLine());
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(N));
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

	private static String calc(int N) {
		if(N == 0) return "INSOMNIA";
		int sheep = N;
		
		boolean[] nbrsFound = new boolean[10];
		boolean allNbrsFound = false;
		int count = 1;
		
		while(!allNbrsFound) {
			char[] asChars = (""+sheep).toCharArray();
			
			for(char asChar : asChars) {
				int nbr = Integer.parseInt(String.valueOf(asChar));
				nbrsFound[nbr] = true;
			}
			
			allNbrsFound = true;
			for(boolean nbr : nbrsFound) {
				if(!nbr) {
					allNbrsFound = false;
				}
			}
			
			if(allNbrsFound) {
				return String.valueOf(sheep);
			}
			
			sheep = ++count*N;
		}
		
		return "INSOMNIA";
	}
}
