package se.johannalynn.google.codejam.y2016.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CopyOfB_RankAndFile {
	private static final String YEAR = "y2016";
	private static final String ROUND = "r1a";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = "out/";
	
	private static final String FILE = "B-large-practice";
	//private static final String FILE = "B";
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
			int N = Integer.valueOf(in.nextLine());
			
			Map<Integer, Integer> nbrs = new HashMap<>();
			for(int j = 0; j < 2*N-1; j++) {
				String[] input = in.nextLine().split(" ");
				for(int k = 0; k < input.length; k++) {
					int nbr = Integer.valueOf(input[k]);
					Integer amount = nbrs.get(nbr);
					if(amount == null) {
						amount = 1;
					} else {
						amount += 1;
					}
					nbrs.put(nbr, amount);
				}
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			String result = calc(N, nbrs);
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
	
	private static String calc(int N, Map<Integer, Integer> nbrs) {
		System.out.println("N: " + N + ", nbrs.size: " + nbrs.size());
		
		List<Integer> result = new ArrayList<>();
		Iterator<Integer> itr = nbrs.keySet().iterator();
		while(itr.hasNext()) {
			Integer mapKey = itr.next();
			Integer amount = nbrs.get(mapKey);
			System.out.println("mapKey: " + mapKey + ", amount: " + amount);
			if(amount % 2 != 0) {
				result.add(mapKey);
			}
		}
		Collections.sort(result);
		StringBuffer buffer = new StringBuffer();
		for(Integer nbr : result) {
			buffer.append(nbr + " ");
		}
		return buffer.toString();
	}
}
