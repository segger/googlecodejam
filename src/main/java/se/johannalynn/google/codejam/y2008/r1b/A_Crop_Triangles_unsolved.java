package se.johannalynn.google.codejam.y2008.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_Crop_Triangles_unsolved {

	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2008/r1b/";
	private static final String OUT_PATH = "out/y2008/r1b/";
	private static final String IN_FILE = "A-large-practice.in";
	private static final String OUT_FILE = "A-large-practice.out";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String inFileName = IN_PATH + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));

		StringBuffer buffer = new StringBuffer();
		
		// read in start
		int N = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < N; i++) {
			String[] tmp = in.nextLine().split(" ");
			int n = Integer.valueOf(tmp[0]);
			int A = Integer.valueOf(tmp[1]);
			int B = Integer.valueOf(tmp[2]);
			int C = Integer.valueOf(tmp[3]);
			int D = Integer.valueOf(tmp[4]);
			int x = Integer.valueOf(tmp[5]);
			int y = Integer.valueOf(tmp[6]);
			int M = Integer.valueOf(tmp[7]);
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(solve(n, A, B, C, D, x, y, M));
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

	private static int solve(int n, int A, int B, int C, int D, int x0, int y0, int M) {
		List<long[]> coords = new ArrayList<long[]>();
		long[] coord = new long[2];
		coord[0] = x0;
		coord[1] = y0;
		coords.add(coord);
		for(int q = 0; q < n; q++) {
			long x = (A * coord[0] + B) % M;
			long y = (C * coord[1] + D) % M;
			coord = new long[2];
			coord[0] = x;
			coord[1] = y;
			coords.add(coord);
		}
		
		int nbr = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					long[] a = coords.get(i);
					long[] b = coords.get(j);
					long[] c = coords.get(k);
					//System.out.println(i + ": (" + a[0] + ", " + a[1] + ")");
					//System.out.println(j + ": (" + b[0] + "," + b[1] + ")");
					//System.out.println(k + ": (" + c[0] + ", " + c[1] + ")");
					double center_x = (a[0] + b[0] + c[0]) / 3.0;
					double center_y = (a[1] + b[1] + c[1]) / 3.0;
					if(isGrid(center_x, center_y)) {
						//System.out.println(center_x + ", " + center_y);
						nbr++;
					}
				}
			}
		}
		return nbr;
	}
	
	private static boolean isGrid(double x, double y) {
		if(Math.floor(x) == x && !Double.isInfinite(x)) {
			if(Math.floor(y) == y && !Double.isInfinite(y)) {
				return true;
			}
		}
		return false;
	}
}
