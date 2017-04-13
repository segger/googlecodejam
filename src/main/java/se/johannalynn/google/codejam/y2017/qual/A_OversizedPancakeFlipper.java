package se.johannalynn.google.codejam.y2017.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A_OversizedPancakeFlipper {
	private static final String YEAR = "y2017";
	private static final String ROUND = "qual";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/";
	
	private static final String FILE = "A-large";
	//private static final String FILE = "A-small-attempt0";
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
			String[] line = in.nextLine().split(" ");
			int K = Integer.valueOf(line[1]);
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			String result = calc(line[0], K);
			System.out.println(result);
			buffer.append(result);
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
	
	private static String calc(String input, int K) {
		System.out.println(input + " -> " + K);
		int length = input.length();
		
		int happy = 0;
		boolean[] board = new boolean[length];
		for(int i = 0; i < length; i++) {
			if(input.charAt(i) == '+') {
				board[i] = true;
				happy++;
			}
		}
		
		if(happy == length) {
			return "0";
		}
		
		int nbrOfFlips = 0;
		int c = 0;
		while(c < length) {
			//System.out.println("c: " + c + " -> " + board[c]);
			if(!board[c]) {
				//System.out.println("flip " + c + " -> " + (c + K - 1));
				//flipp
				for(int i = 0; i < K; i++) {
					int flip_i = c + i;
					//System.out.println("flipping " + flip_i);
					if(flip_i >= length) {
						return "IMPOSSIBLE";
					}
					board[flip_i] = !board[flip_i];
				}
				nbrOfFlips++;
			}
			c++;
		}
		
		return String.valueOf(nbrOfFlips);
	}
}
