package se.johannalynn.google.codejam.y2014.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class B_CookieClicker {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/qual/";
	private static final String OUT_PATH = "out/y2014/qual/";
	private static final String IN_FILE = "B-large.in";
	private static final String OUT_FILE = "B-large.out";

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

			String[] input = in.nextLine().split(" ");
			double c = Double.valueOf(input[0]);
			double f = Double.valueOf(input[1]);
			double x = Double.valueOf(input[2]);

			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(c, f, x));
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

	private static String calc(double c, double f, double x) {
		//double currentAmountCookies = 0;
		double currentProduceRate = 2;

		double oldTime = Double.MAX_VALUE;
		double timeToWin = x / currentProduceRate;
		double timeToNextFarm = 0;
		
		while (timeToWin <= oldTime) {
			oldTime = timeToWin;
			timeToNextFarm += c / currentProduceRate;
			currentProduceRate += f;
			double tmp = x / currentProduceRate;
			timeToWin = timeToNextFarm + tmp;
			//System.out.println(timeToWin + ", " + oldTime);
		}

		DecimalFormat formatted = new DecimalFormat("#.0000000");
		return formatted.format(oldTime);

	}
}
