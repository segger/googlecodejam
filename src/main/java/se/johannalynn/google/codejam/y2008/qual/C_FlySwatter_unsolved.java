package se.johannalynn.google.codejam.y2008.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class C_FlySwatter_unsolved {

	private static final String IN_FILE = "C.in";
	private static final String OUT_FILE = "C.out";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String inPath = "src/main/resources/se/johannalynn/google/codejam/y2008/qual/";
		String inFileName = inPath + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));
		
		StringBuffer buffer = new StringBuffer();
		int n = Integer.valueOf(in.nextLine());
		//System.out.println(n);
		for(int i = 0; i < n; i++) {
			
			String[] tmp = in.nextLine().split(" ");
			double f = Double.valueOf(tmp[0]);
			double R = Double.valueOf(tmp[1]);
			double t = Double.valueOf(tmp[2]);
			double r = Double.valueOf(tmp[3]);
			double g = Double.valueOf(tmp[4]);
			
			int caseNbr = i + 1;
			String output = "Case #" + caseNbr + ": " + hit(f, R, t, r, g) + "\n";
			buffer.append(output);
		}
		in.close();

		//print to file
		String outPath = "out/y2008/qual/";
		String outFileName = outPath + OUT_FILE;
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(outFileName)));
		out.write(buffer.toString());
		out.close();
	}
	
	private static String hit(double f, double R, double t, double r, double g) {
		//System.out.println(f + " " + R + " " + t + " " + r + " " + g);
		double hit = 0.32932322928;
		
		double tmp = (R-t) - r;
		int nbr_full_g = 0;
		while(tmp >= g) {
			tmp -= g;
			nbr_full_g++;
			tmp -= 2*r;
		}
		//nbr_full_g *= nbr_full_g;
		//nbr_full_g *= 4;
		
		DecimalFormat df = new DecimalFormat("0.000000");
		return df.format(hit);
	}
}
