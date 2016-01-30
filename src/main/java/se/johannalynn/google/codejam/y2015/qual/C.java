package se.johannalynn.google.codejam.y2015.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
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
			Result res = new Result(inputStr.substring(0, 1), false);
			point = searchI2(res, inputStr.substring(1));
		}
		final String YES = "YES";
		final String NO = "NO";
		String answer = point ? YES : NO;
		//System.out.println("answer: " + answer);
		return answer;
	}
	
	static class Result {
		private String value;
		private boolean neg;
		
		public Result(String value, boolean neg) {
			this.value = value;
			this.neg = neg;
		}
	}
	
	private static void findAllK(String input) {
		
	}
	
	private static boolean resultEquals(Result result, String equalsStr) {
		if(result.neg) {
			return false;
		} else {
			return result.value.equalsIgnoreCase(equalsStr);
		}
	}
	
	private static boolean searchI2(Result first, String tail) {
		while(true) {
			if(tail.length() < 1) {
				return false;
			}
			//System.out.println("searchI2: " + first.value);
			Result nextRes = new Result(tail.substring(0, 1), false);
			if(resultEquals(first, "i")) {
				if(searchJ2(nextRes, tail.substring(1))) {
					return true;
				} else {
					first = multiply(first, nextRes);
					tail = tail.substring(1);
				}
			} else {
				first = multiply(first, nextRes);
				tail = tail.substring(1);
			}
		}
	}
	
	private static boolean searchJ2(Result first, String tail) {
		while(true) {
			if(tail.length() < 1) {
				return false;
			}
			Result nextRes = new Result(tail.substring(0, 1), false);
			if(resultEquals(first, "j")) {
				if(searchK2(nextRes, tail.substring(1))) {
					return true;
				} else {
					first = multiply(first, nextRes);
					tail = tail.substring(1);
				}
			} else {
				first = multiply(first, nextRes);
				tail = tail.substring(1);
			}
		}
	}
	
	private static boolean searchK2(Result first, String tail) {
		while(true) {
			//System.out.println("searchK2: " + first.value);
			if(resultEquals(first, "k")) {
				if(tail.isEmpty()) {
					return true;
				} else {
					if(tail.length() < 1) {
						return false;
					} else {
						Result nextRes = new Result(tail.substring(0, 1), false);
						first = multiply(first, nextRes);
						tail = tail.substring(1);
					}
				}
			} else {
				if(tail.length() < 1) {
					return false;
				} else {
					Result nextRes = new Result(tail.substring(0, 1), false);
					first = multiply(first, nextRes);
					tail = tail.substring(1);
				}
			}
		}
	}
	/*
	private static boolean searchI(Result first, String tail) {
		System.out.println("searchI: " + first.value);
		if(resultEquals(first, "i")) {
			if(tail.length() < 1) {
				return false;
			} else {
				Result nextRes = new Result(tail.substring(0, 1), false);
				return searchJ(nextRes, tail.substring(1));
			}
		} else {
			if(tail.length() < 1) {
				return false;
			} else {
				Result nextRes = new Result(tail.substring(0, 1), false);
				return searchI(multiply(first, nextRes),tail.substring(1));
			}
		}
	}
	
	private static boolean searchJ(Result first, String tail) {
		System.out.println("searchJ: " + first.value);
		if(resultEquals(first, "j")) {
			if(tail.length() < 1) {
				return false;
			} else {
				Result nextRes = new Result(tail.substring(0, 1), false);
				return searchK(nextRes, tail.substring(1));
			}
		} else {
			if(tail.length() < 1) {
				return false;
			} else {
				Result nextRes = new Result(tail.substring(0, 1), false);
				return searchJ(multiply(first, nextRes),tail.substring(1));
			}
		}
	}
	
	private static boolean searchK(Result first, String tail) {
		System.out.println("searchK: " + first.value);
		if(resultEquals(first, "k")) {
			if(tail.isEmpty()) {
				return true;
			} else {
				if(tail.length() < 1) {
					return false;
				}
				Result nextRes = new Result(tail.substring(0, 1), false);
				return searchK(multiply(first, nextRes),tail.substring(1));
			}
		} else {
			if(tail.length() < 1) {
				return false;
			}
			Result nextRes = new Result(tail.substring(0, 1), false);
			return searchK(multiply(first, nextRes),tail.substring(1));
		}
	}*/
	
	private static boolean resultEquals2(Result res, String compare) {
		return res.value.equalsIgnoreCase(compare);
	}
	
	private static Map<String, Result> dict = new HashMap<String, Result>();
	
	private static Result multiply(Result a, Result b) {
		Result res = dict.get(a.value+a.neg+b.value+b.neg);
		if(res == null) {
			res = multiply2(a, b);
			dict.put(a.value+a.neg+b.value+b.neg, res);
		}
		return res;
	}
	
	private static Result multiply2(Result a, Result b) {
		boolean neg = a.neg ^ b.neg;
		if(resultEquals2(a, "1")) {
			if(resultEquals2(b,"1")) {
				return new Result("1", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result("i", neg);
			}
			if(resultEquals2(b, "j")) {
				return new Result("j", neg);
			}
			if(resultEquals2(b, "k")) {
				return new Result("k", neg);
			}
		}
		if(resultEquals2(a, "i")) {
			if(resultEquals2(b, "1")) {
				return new Result("i", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result("1", neg ^ false);
			}
			if(resultEquals2(b, "j")) {
				return new Result("k", neg);
			}
			if(resultEquals2(b, "k")) {
				return new Result("j", neg ^ false);
			}
		}
		if(resultEquals2(a, "j")) {
			if(resultEquals2(b, "1")) {
				return new Result("j", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result("k", neg ^ false);
			}
			if(resultEquals2(b, "j")) {
				return new Result("1", neg ^ false);
			}
			if(resultEquals2(b, "k")) {
				return new Result("i", neg);
			}
		}
		if(resultEquals2(a, "k")) {
			if(resultEquals2(b, "1")) {
				return new Result("k", neg);
			}
			if(resultEquals2(b, "i")) {
				return new Result("j", neg);
			}
			if(resultEquals2(b, "j")) {
				return new Result("i", neg);
			}
			if(resultEquals2(b, "k")) {
				return new Result("1", neg);
			}
		}
		return null;
	}
}
