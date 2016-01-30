package se.johannalynn.google.codejam.y2014.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C_Minesweeper_Unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/qual/";
	private static final String OUT_PATH = "out/y2014/qual/";
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

			String[] input = in.nextLine().split(" ");
			int r = Integer.valueOf(input[0]);
			int c = Integer.valueOf(input[1]);
			int m = Integer.valueOf(input[2]);

			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ":\n");
			buffer.append(calc(r, c, m));
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

	private static String calc(int r, int c, int m) {
		class Pair {
			int i;
			int j;
			
			@Override
			public boolean equals(Object o) {
				if(o instanceof Pair) {
					Pair p = (Pair)o;
					return i == p.i && j == p.j;
				}
				return false;
			}
		}
		
		final String IMPOSSIBLE = "Impossible";
		final String MINE = "*";
		final String CLICK = "c";
		final String EMPTY = ".";
		final String NON_START = "1";
		
		String[][] board = new String[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				board[i][j] = EMPTY;
			}
		}
		int i = 0;
		int j = 0;
		List<Pair> nonStarts = new ArrayList<Pair>();
		
		for(int mines = 0; mines<m; mines++) {
			board[i][j] = MINE;
			boolean tmp1 = i+1 < r;
			boolean tmp2 = j+1 < c;
			if(tmp1) {
				board[i+1][j] = NON_START;
				Pair p = new Pair();
				p.i = i+1;
				p.j = j;
				if(!nonStarts.contains(p)) {
					nonStarts.add(p);
				}
			}
			if(tmp2) {
				board[i][j+1] = NON_START;
				Pair p = new Pair();
				p.i = i;
				p.j = j+1;
				if(!nonStarts.contains(p)) {
					nonStarts.add(p);
				}
			}
			if(tmp1 && tmp2) {
				board[i+1][j+1] = NON_START;
				Pair p = new Pair();
				p.i = i+1;
				p.j = j+1;
				if(!nonStarts.contains(p)) {
					nonStarts.add(p);
				}
			}
			if(!nonStarts.isEmpty()) {
				Pair first = nonStarts.remove(0);
				System.out.println("out: " + i + ", " + j);
				i = first.i;
				j = first.j;
			}
		}
		/*
		if(NON_START.equalsIgnoreCase(board[r-1][c-1])) {
			if(r*c-1 == m) {
				System.out.println(r*c-1+m);
			} else {
				
				return IMPOSSIBLE;
			}
		}*/
		
		board[r-1][c-1] = CLICK;
		
		StringBuffer buffer = new StringBuffer();
		for(int a=0; a<r; a++) {
			for(int b=0; b<c; b++) {
				if(NON_START.equalsIgnoreCase(board[a][b])) {
					buffer.append(EMPTY);
				} else {
					buffer.append(board[a][b]);
				}
			}
			buffer.append("\n");
		}
		
		for(int p=0; p<r; p++) {
			for(int q=0; q<c; q++) {
				System.out.print(board[p][q]);
			}
			System.out.println();
		}
		
		return buffer.toString();
	}
}
