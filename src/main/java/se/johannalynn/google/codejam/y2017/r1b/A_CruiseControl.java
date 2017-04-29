package se.johannalynn.google.codejam.y2017.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_CruiseControl {
	private static final String YEAR = "y2017";
	private static final String ROUND = "r1b";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";	
	private static final String OUT_PATH = "out/";
	
	private static final String FILE = "A-large";
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
			String[] input = in.nextLine().split(" ");
			int t_D = Integer.valueOf(input[0]);
			BigDecimal D = new BigDecimal(t_D);
			int N = Integer.valueOf(input[1]);
			BigDecimal maxTime = BigDecimal.valueOf(Double.MIN_VALUE);
			
			for(int j = 0; j < N; j++) {
				String[] tmp = in.nextLine().split(" ");
				int K = Integer.valueOf(tmp[0]);
				int tmp_s = t_D - K;
				BigDecimal s = new BigDecimal(tmp_s);
				
				int t_v = Integer.valueOf(tmp[1]);
				BigDecimal v = new BigDecimal(t_v);
				
				BigDecimal time = s.divide(v, 10, RoundingMode.HALF_UP);
				System.out.println("time: " + time);
				if(time.compareTo(maxTime) > 0) {
					maxTime = time;
				}
			}
			System.out.println("maxTime: " + maxTime);
			BigDecimal result = D.divide(maxTime, 10, RoundingMode.HALF_UP);
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
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
}
