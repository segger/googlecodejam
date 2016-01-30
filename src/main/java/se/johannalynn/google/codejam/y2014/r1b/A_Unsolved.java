package se.johannalynn.google.codejam.y2014.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_Unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/r1b/";
	private static final String OUT_PATH = "out/y2014/r1b/";
	private static final String IN_FILE = "A-large.in";
	private static final String OUT_FILE = "A-large.out";

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
			int N = Integer.valueOf(in.nextLine());
			List<String> strings = new ArrayList<String>();
			for(int j=0; j<N; j++) {
				String input = in.nextLine();
				strings.add(input);
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(strings));
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
	
	private static String calc(List<String> strings) {
		final String IMPOSSIBLE = "Fegla Won";
		
		boolean alike = true;
		int c1 = 1;
		String s = strings.get(0);
		while(alike && c1 < strings.size()) {
			String stmp = strings.get(c1);
			if(!s.equalsIgnoreCase(stmp)) {
				alike = false;
			}
			c1++;
		}
		
		if(alike) {
			return "0";
		}
		
		List<String> shortest = new ArrayList<String>();
		List<List<Integer>> counters = new ArrayList<List<Integer>>();
		for(int k=0; k<strings.size(); k++) {
			String s1 = strings.get(k);
			char old = '0';
			StringBuffer shortString = new StringBuffer();
			int c5 = 1;
			List<Integer> counter = new ArrayList<Integer>();
			for(int i=0; i<s1.length(); i++) {
				char tmp = s1.charAt(i);
				if(tmp != old) {
					if(old != '0') {
						counter.add(c5);
					}
					shortString.append(tmp);
					old = tmp;
					c5 = 1;
				} else {
					c5++;
				}
			}
			counter.add(c5);
			shortest.add(shortString.toString());
			counters.add(counter);
		}
		
		int c = 1;
		String s2 = shortest.get(0);
		while(c < shortest.size()) {
			String s2tmp = shortest.get(c);
			if(!s2.equalsIgnoreCase(s2tmp)) {
				return IMPOSSIBLE;
			}
			c++;
		}
		
		int length = shortest.get(0).length();
		int[][] matrix = new int[shortest.size()][length];
		for(int i2=0; i2<shortest.size(); i2++) {
			List<Integer> tmp = counters.get(i2);
			
			for(int i3=0; i3<tmp.size(); i3++) {
				matrix[i2][i3]=tmp.get(i3);
			}
		}
		
		double diff = Double.MAX_VALUE;
		for(int x=0; x<strings.size(); x++) {
			
			double diff_t = Double.MAX_VALUE;
			double diff_t3 = 0;
			for(int i0=0; i0<strings.size(); i0++) {
				for(int i4=0; i4<length; i4++) {
					double diff_t2 = Math.abs(matrix[x][i4]-matrix[i0][i4]);
					if(diff_t2 != 0 && diff_t2 < diff_t) {
						diff_t = diff_t2;
					}
				}
				diff_t3 += diff_t;
			}
			//System.out.println(diff_t);
			if(diff_t3 < diff) {
				diff = diff_t3;
			}
		}
		
		return String.valueOf((int)diff);
	}
}
