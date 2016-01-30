package se.johannalynn.google.codejam.y2008.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class C_Numbers_unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1a/";
	private static final String OUT_PATH = "out/y2008/r1a/";
	private static final String IN_FILE = "C-large-practice.in";
	private static final String OUT_FILE = "C-large-practice.out";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String inFileName = IN_PATH + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));

		StringBuffer buffer = new StringBuffer();
		
		// read in start
		int t = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		BigDecimal three = new BigDecimal("3.0");
		BigDecimal five = new BigDecimal("5.0");
		BigDecimal sqrtFive = sqrt(five);
		BigDecimal calcNbr = three.add(sqrtFive);
		
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(in.nextLine());
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(calcNbr, n));
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
	
	private static String calc(BigDecimal calcNbr, int n) {
		//double sqrtFive = Math.sqrt(5.0);
		//double calcNbr = 3 + sqrtFive;
		BigDecimal tmp = BigDecimal.ONE;
		for(int i = 0; i < n; i++) {
			tmp = tmp.multiply(calcNbr);
		}
		BigInteger intValue = tmp.toBigInteger();
		String retValue = intValue.toString();
		if(retValue.length() >= 3) {
			return retValue.substring(retValue.length()-3);
		} else if (retValue.length() == 2){
			return "0" + retValue;
		} else if (retValue.length() == 1) {
			return "00" + retValue;
		} else {
			return "000";
		}
	}
	
	public static BigDecimal sqrt(BigDecimal value) {
	    BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
	    return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
	}
}
