package se.johannalynn.google.codejam.y2015.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CopyOfC {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2015/qual/";
	private static final String OUT_PATH = "out/y2015/qual/";
	private static final String IN_FILE = "C.in";
	private static final String OUT_FILE = "C.out";

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
			BigInteger L = new BigInteger(tmp[0]);
			BigInteger X = new BigInteger(tmp[1]);
			String input = in.nextLine();
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(L, X, input));
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
	
	private static String calc(BigInteger L, BigInteger X, String input) {
		boolean point = false;
		//System.out.println("L: " + L + ", X: " + X + " : " + input);
		
		StringBuffer buffer = new StringBuffer();
		for(BigInteger i = BigInteger.ZERO; i.compareTo(X) < 0; i = i.add(BigInteger.ONE)) {
			buffer.append(input);
		}
		String inputStr = buffer.toString();
		//System.out.println("inputStr: " + inputStr);
		if(inputStr.length() > 1) {
			Result res = new Result(inputStr.substring(0, 1), inputStr.substring(0, 1), false);
			//point = searchI2(res, inputStr.substring(1));
		}
		final String YES = "YES";
		final String NO = "NO";
		String answer = point ? YES : NO;
		//System.out.println("answer: " + answer);
		return answer;
	}
	
	static class Result {
		private String input;
		private String value;
		private boolean neg;
		
		public Result(String input, String value, boolean neg) {
			this.value = value;
			this.neg = neg;
		}
	}
	
	private static boolean resultEquals2(Result res, String compare) {
		return res.value.equalsIgnoreCase(compare);
	}
	
	private static Map<String, Result> dict = new HashMap<String, Result>();
	
	private static Result multiply(Result a, Result b) {
		Result res = dict.get(a.input+b.input);
		if(res == null) {
			res = multiply2(a, b);
			dict.put(a.input+b.input, res);
		}
		return res;
	}
	
	private static Result multiply2(Result a, Result b) {
		boolean neg = a.neg ^ b.neg;
		if(resultEquals2(a, "1")) {
			if(resultEquals2(b,"1")) {
				return new Result(a.input+b.input, "1", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result(a.input+b.input, "i", neg);
			}
			if(resultEquals2(b, "j")) {
				return new Result(a.input+b.input, "j", neg);
			}
			if(resultEquals2(b, "k")) {
				return new Result(a.input+b.input, "k", neg);
			}
		}
		if(resultEquals2(a, "i")) {
			if(resultEquals2(b, "1")) {
				return new Result(a.input+b.input, "i", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result(a.input+b.input, "1", neg ^ false);
			}
			if(resultEquals2(b, "j")) {
				return new Result(a.input+b.input, "k", neg);
			}
			if(resultEquals2(b, "k")) {
				return new Result(a.input+b.input, "j", neg ^ false);
			}
		}
		if(resultEquals2(a, "j")) {
			if(resultEquals2(b, "1")) {
				return new Result(a.input+b.input, "j", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result(a.input+b.input, "k", neg ^ false);
			}
			if(resultEquals2(b, "j")) {
				return new Result(a.input+b.input, "1", neg ^ false);
			}
			if(resultEquals2(b, "k")) {
				return new Result(a.input+b.input, "i", neg);
			}
		}
		if(resultEquals2(a, "k")) {
			if(resultEquals2(b, "1")) {
				return new Result(a.input+b.input, "k", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result(a.input+b.input, "j", neg);
			}
			if(resultEquals2(b, "j")) {
				return new Result(a.input+b.input, "i", neg);
			}
			if(resultEquals2(b, "k")) {
				return new Result(a.input+b.input, "1", neg);
			}
		}
		return null;
	}
}
