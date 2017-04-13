package se.johannalynn.google.codejam.y2017.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B_TidyNumbers {
	private static final String YEAR = "y2017";
	private static final String ROUND = "qual";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/";
	
	//private static final String FILE = "B-small-attempt1";
	private static final String FILE = "B-large";
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
		
		for (int i = 0; i < T; i++) {
			String input = in.nextLine();
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			String result = calc(input);
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
	
	private static String calc(String input) {
		System.out.print(input + " -> ");
		
		int length = input.length();
		if(length == 1) {
			return input;
		}
		
		int current = Integer.valueOf(input.substring(0, 1));
		int c = 1;
		int index = 0;
		
		StringBuffer buffer = new StringBuffer();
		StringBuffer tmpBuffer = new StringBuffer();
		
		while(c < length) {
			int next = Integer.valueOf(input.substring(c, c + 1));
			if(next > current) {
				buffer.append(tmpBuffer.toString());
				buffer.append(current);
				index = c;
				tmpBuffer = new StringBuffer();
			} else if(next < current) {
				//do i miss current
				int selected = Integer.valueOf(input.substring(index, index + 1));
				if(selected - 1 > 0) {
					buffer.append(selected - 1);
				}
				for(int j = index + 1; j < length; j++) {
					buffer.append("9");
				}
				return buffer.toString();
			} else {
				//buffer.append(current);
				tmpBuffer.append(current);
			}
			current = next;
			c++;
		}
		buffer.append(tmpBuffer.toString());
		buffer.append(current);
		
		return buffer.toString();
	}
}
