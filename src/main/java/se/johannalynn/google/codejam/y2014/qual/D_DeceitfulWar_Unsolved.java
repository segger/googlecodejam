package se.johannalynn.google.codejam.y2014.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class D_DeceitfulWar_Unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/qual/";
	private static final String OUT_PATH = "out/y2014/qual/";
	private static final String IN_FILE = "D.in";
	private static final String OUT_FILE = "D.out";

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
			int nbrOfBlocks = Integer.valueOf(in.nextLine());
			String[] nTmp = in.nextLine().split(" ");
			String[] kTmp = in.nextLine().split(" ");
			List<Double> naomiList = new ArrayList<Double>();
			List<Double> kenList = new ArrayList<Double>();
			for (int j = 0; j < nbrOfBlocks; j++) {
				naomiList.add(Double.parseDouble(nTmp[j]));
				kenList.add(Double.parseDouble(kTmp[j]));
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calcDecetifulWar(nbrOfBlocks, naomiList, kenList));
			buffer.append(" ");
			buffer.append(calcWar(nbrOfBlocks, naomiList, kenList));
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

	private static String calcWar(int n, List<Double> naomi, List<Double> ken) {
		int points = 0;
		// Collections.sort(naomi);
		Collections.sort(ken);
		for (int i = 0; i < n; i++) {
			Double chosen = naomi.get(i);
			boolean kenPoint = false;
			int c = 0;
			while (!kenPoint && c < ken.size()) {
				Double kChoose = ken.get(c);
				if (kChoose > chosen) {
					kenPoint = true;
					ken.remove(c);
				}
				c++;
			}
			if (!kenPoint) {
				points++;
			}
		}
		return String.valueOf(points);
	}

	private static String calcDecetifulWar(int n, List<Double> naomi, List<Double> ken) {
		System.out.println("decetiful war");
		int points = 0;
		//Collections.sort(naomi);
		Collections.sort(ken);
		List<Double> all = new ArrayList<Double>();
		all.addAll(naomi);
		all.addAll(ken);
		Collections.sort(all);
		int c = 1;
		
		while(!all.isEmpty()) {
			Double lowest = all.remove(0);
			if(naomi.contains(lowest)) {
				System.out.println("naomi " + lowest);
				Double kenHighest = ken.get(ken.size()-c);
				if(all.remove(kenHighest)) {
					c++;
					System.out.println("remove: " + kenHighest);
				}
				//ken.remove(ken.size()-1);
			} else {
				System.out.println("ken: " + lowest);
				//ken.remove(lowest);
				points++;
			}
		}
		return String.valueOf(points);
	}
}
