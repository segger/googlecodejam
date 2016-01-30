package se.johannalynn.google.codejam.y2009.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Geologists sometimes divide an area of land into different regions based on
 * where rainfall flows down to. These region are called drainage basins.
 * 
 * Given an elevation map (a 2-dimensional array of altitudes), label the map
 * such that locations in the same drainage basin have the same label, subject
 * to the following rules.
 * 
 * * From each cell, water flows down to at most one of its 4 neighboring cells
 * * For each cell, if none of its 4 neighboring cells has a lower altitude than
 *   the current cell's, then the water does not flow, and the current cell is
 *   called a sink
 * * Otherwise, water flows from the current cell to the neighbor with the lowest
 *   altitude
 * * In case of a tie, water will choose the first direction with the lowest altitude
 *   from this list: North, West, East, South
 *   
 * Every cell that drains directly or indirectly to the same sink is part of the same
 * drainage basin. Each basins labeled by a unique lower-case letter, in such way that,
 * when the rows of the map are concatenated from top to bottom, the resulting string
 * is lexicographically smallest. (In particular the basin of the most North-Western cell
 * is always labeled 'a')
 *  
 * @author segger
 *
 */
public class B_unsolved {
	private static final String YEAR = "y2009";
	private static final String ROUND = "qual";
	
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";
	
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
		int T = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < T; i++) {
			String[] tmp = in.nextLine().split(" ");
			int H = Integer.valueOf(tmp[0]);
			int W = Integer.valueOf(tmp[1]);
			
			int[][] map = new int[H][W];
			for(int h = 0; h < H; h++) {
				String[] row = in.nextLine().split(" ");
				for(int w = 0; w < W; w++) {
					map[h][w] = Integer.valueOf(row[w]);
				}
			}
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(H, W, map));
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
	
	private static String calc(int H, int W, int[][] map) {
		StringBuffer buffer = new StringBuffer();
		int[][] resMap = new int[H][W];
		resMap[0][0] = 'a';
		
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				int value = map[h][w];
				int min = value;
				if(h-1 > 0) {
					int north = map[h-1][w];
					if(north < min) {
						min = north;
					}
				}
				if(w-1 > 0) {
					int west = map[h][w-1];
					if(west < min) {
						min = west;
					}
				}
				if(h+1 < H) {
					int east = map[h+1][w];
					if(east < min) {
						min = east;
					}
				}
				if(w+1 < W) {
					int south = map[h][w+1];
					if(south < min) {
						min = south;
					}
				}
			}
		}
		
		for(int h = 0; h < H; h++) {
			buffer.append("\n");
			for(int w = 0; w < W; w++) {
				buffer.append(resMap[h][w] + " ");
			}
		}
		
		return buffer.toString();
	}
}
