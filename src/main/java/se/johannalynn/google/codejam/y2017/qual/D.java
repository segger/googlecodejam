package se.johannalynn.google.codejam.y2017.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
	private static final String YEAR = "y2017";
	private static final String ROUND = "qual";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/";
	
	private static final String FILE = "D";
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
			String[] input = in.nextLine().split(" ");
			int N = Integer.valueOf(input[0]);
			int M = Integer.valueOf(input[1]);
			List<Model> models = new ArrayList<>();
			for(int j = 0; j < M; j++) {
				String[] modelInput = in.nextLine().split(" ");
				models.add(new Model(modelInput[0], Integer.valueOf(modelInput[1]), Integer.valueOf(modelInput[2])));
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			String result = calc(N, M, models);
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
	
	static class Model {
		String type;
		int row;
		int col;
		
		Model(String type, int row, int col) {
			this.type = type;
			this.row = row;
			this.col = col;
		}
		
		String print() {
			return type + " " + row + " " + col;
		}
	}
	
	private static String calc(int N, int M, List<Model> models) {
		System.out.println("N: " + N + ", M: " + M);
		int points = 0;
		int modified = 0;
		
		for(Model m : models) {
			//System.out.println(m.print());
			if(m.type.equals("o")) {
				points += 2;
			} else {
				points += 1;
			}
		}
		
		StringBuffer buffer = new StringBuffer();
		List<Model> edited = new ArrayList<>();
		
		String resultRow = points + " " + modified;
		buffer.append(resultRow);
		
		//edited.add(new Model("x", 0, 0));
		
		for(Model model : edited) {
			buffer.append("\n" + model.print());
		}
		return buffer.toString();
	}
}
