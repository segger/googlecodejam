package se.johannalynn.google.codejam.y2008.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_SavingTheUniverse {

	private static final String IN_FILE = "A-large-practice.in";
	private static final String OUT_FILE = "A-large-practice.out";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String inPath = "src/main/resources/se/johannalynn/google/codejam/y2008/qual/";
		String inFileName = inPath + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));
		
		StringBuffer buffer = new StringBuffer();
		
		//read in start
		int n = Integer.valueOf(in.nextLine());
		//System.out.println(n);
		for (int i = 0; i < n; i++) {
			int s = Integer.valueOf(in.nextLine());
			//System.out.println(s);
			String[] engines = new String[s];
			for (int j = 0; j < s; j++) {
				String engine = in.nextLine();
				//System.out.println(engine);
				engines[j] = engine;
			}
			int q = Integer.valueOf(in.nextLine());
			//System.out.println(q);
			List<String> queries = new ArrayList<String>();
			for (int k = 0; k < q; k++) {
				String query = in.nextLine();
				//System.out.println(query);
				queries.add(query);
			}
			int caseNbr = i + 1;
			String output = "Case #" + caseNbr + ": " + switches(engines, queries) + "\n";
			buffer.append(output);
			//System.out.println("Case #" + caseNbr + ": " + switches(engines, queries));
		}
		in.close();

		//print to file
		String outPath = "out/y2008/qual/";
		String outFileName = outPath + OUT_FILE;
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(outFileName)));
		out.write(buffer.toString());
		out.close();
	}

	private static int switches(String[] engines, List<String> queries) {
		int switches = 0;
		boolean[] switchedEngine  = new boolean[engines.length];
		int countOffSwitched = 0;
		int currentQuery = 0;
		for (String query : queries) {
			for (int i = 0; i < engines.length; i++) {
				String engine = engines[i];
				if (query.compareTo(engine) == 0) {
					if(!switchedEngine[i]) {
						switchedEngine[i] = true;
						countOffSwitched++;
						currentQuery = i;
					}
				}
			}
			if(countOffSwitched == engines.length) {
				switches++;
				switchedEngine = new boolean[engines.length];
				switchedEngine[currentQuery] = true;
				countOffSwitched = 1;
			}
		}
		return switches;
	}
}
