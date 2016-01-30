package se.johannalynn.google.codejam.y2008.r1c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_UglyNumbers_unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1c/";
	private static final String OUT_PATH = "out/y2008/r1c/";
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
			String tmp = in.nextLine();
			String[] input = tmp.split("");
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(input));
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
	
	private static String calc(String[] input) {
		final BigInteger[] primes = new BigInteger[4];
		primes[0] = new BigInteger("2");
		primes[1] = new BigInteger("3");
		primes[2] = new BigInteger("5");
		primes[3] = new BigInteger("7");
		
		List<String> values = new ArrayList<String>(); 
		for(String t : input) {
			if(t.length() > 0) {
				values.add(t);
			}
		}
		
		if(values.size() == 1) {
			if(isUgly(primes, new BigInteger(values.get(0)))) {
				return "1";
			} else {
				return "0";
			}
		}
		
		int valueIndex = 1;
		String value = values.get(0);
		List<String> currentValues = new ArrayList<String>();
		currentValues.add(value);
		while(valueIndex < values.size()) {
			
			List<String> newCurrentValues = new ArrayList<String>();
			int nbrOfCurrentValues = currentValues.size();
			int c = 0;
			while(c < nbrOfCurrentValues) {
				String currentValue = currentValues.get(c);
				String nextValue = values.get(valueIndex);
				
				newCurrentValues.add(add(currentValue, nextValue));
				newCurrentValues.add(minus(currentValue, nextValue));
				newCurrentValues.add(none(currentValue, nextValue));
				c++;
			}
			currentValues = newCurrentValues;
			valueIndex++;
		}
		
		//Collections.sort(currentValues);
		System.out.println(currentValues.size());
		int ugly = 0;
		for(String v : currentValues) {
			/*if(isUgly(primes, v)) {
				ugly++;
			}*/
			calcMe(v);
		}
		
		return String.valueOf(ugly);
	}
	
	private static BigInteger calcMe(String nbr) {
		int firstAdd = nbr.indexOf("+");
		int firstSub = nbr.indexOf("-");
		if(firstAdd != -1) {
			if(firstSub != -1) {
				if(firstAdd > firstSub) {
					
				}
			}
		}
		return BigInteger.ZERO;
	}
	
	private static String add(String current, String next) {
		return current + "+" + next;
	}
	
	private static String minus(String current, String next) {
		return current + "-" + next;
	}
	
	private static String none(String current, String next) {
		return current + next;
	}
	private static boolean isUgly(BigInteger[] primes, BigInteger nbr) {
		for(int i=0; i<primes.length; i++) {
			if(BigInteger.ZERO.equals(nbr.mod(primes[i]))) {
				return true;
			}
		}
		return false;
	}
}
