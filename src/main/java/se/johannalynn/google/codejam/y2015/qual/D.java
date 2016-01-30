package se.johannalynn.google.codejam.y2015.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class D {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2015/qual/";
	private static final String OUT_PATH = "out/y2015/qual/";
	private static final String IN_FILE = "D-small.in";
	private static final String OUT_FILE = "D-small.out";

	private static Map<Integer, Map<String, Boolean>> answer = new HashMap<Integer, Map<String, Boolean>>();
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String inFileName = IN_PATH + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));

		StringBuffer buffer = new StringBuffer();
		
		init();
		
		// read in start
		int n = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < n; i++) {
			String[] tmp = in.nextLine().split(" ");
			int X = Integer.valueOf(tmp[0]);
			int R = Integer.valueOf(tmp[1]);
			int C = Integer.valueOf(tmp[2]);
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(X, R, C));
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
	
	private static String getKey(int r, int c) {
		String key = String.valueOf(r)+String.valueOf(c);
		return key;
	}
	
	private static void init() {
		initX1();
		initX2();
		initX3();
		initX4();
	}
	
	private static void initX1() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(getKey(1,1), false);
		map.put(getKey(1,2), false);
		map.put(getKey(1,3), false);
		map.put(getKey(1,4), false);
		map.put(getKey(2,2), false);
		map.put(getKey(2,3), false);
		map.put(getKey(2,4), false);
		map.put(getKey(3,3), false);
		map.put(getKey(3,4), false);
		map.put(getKey(4,4), false);
		answer.put(1, map);
	}
	
	private static void initX2() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(getKey(1,1), true);
		map.put(getKey(1,2), false);
		map.put(getKey(1,3), true);
		map.put(getKey(1,4), false);
		map.put(getKey(2,2), false);
		map.put(getKey(2,3), false);
		map.put(getKey(2,4), false);
		map.put(getKey(3,3), true);
		map.put(getKey(3,4), false);
		map.put(getKey(4,4), false);
		answer.put(2, map);
	}
	
	private static void initX3() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(getKey(1,1), true);
		map.put(getKey(1,2), true);
		map.put(getKey(1,3), true);
		map.put(getKey(1,4), true);
		map.put(getKey(2,2), true);
		map.put(getKey(2,3), false);
		map.put(getKey(2,4), true);
		map.put(getKey(3,3), false);
		map.put(getKey(3,4), false);
		map.put(getKey(4,4), true);
		answer.put(3, map);
	}
	
	private static void initX4() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(getKey(1,1), true);
		map.put(getKey(1,2), true);
		map.put(getKey(1,3), true);
		map.put(getKey(1,4), true);
		map.put(getKey(2,2), true);
		map.put(getKey(2,3), true);
		map.put(getKey(2,4), true);
		map.put(getKey(3,3), true);
		map.put(getKey(3,4), false);
		map.put(getKey(4,4), false);
		answer.put(4, map);
	}
	
	private static String calc(int X, int R, int C) {
		Map<String, Boolean> map = answer.get(X);
		String key = null;
		if(R<=C) {
			key = String.valueOf(R)+String.valueOf(C);
		} else {
			key = String.valueOf(C)+String.valueOf(R);
		}
		Boolean richard = map.get(key);
		
		final String RICHARD = "RICHARD";
		final String GABRIEL = "GABRIEL";
		String answer = richard ? RICHARD : GABRIEL;
		return answer;
	}
}
