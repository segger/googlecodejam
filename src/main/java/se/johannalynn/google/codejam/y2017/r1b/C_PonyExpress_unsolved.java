package se.johannalynn.google.codejam.y2017.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C_PonyExpress_unsolved {
	private static final String YEAR = "y2017";
	private static final String ROUND = "r1b";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/";
	
	private static final String FILE = "C";
	private static final String IN_FILE = FILE + ".in";
	private static final String OUT_FILE = FILE + ".out";
	
	static class CityNode {
		int nbr;
		List<CityNode> nextCities = new ArrayList<>();
		BigDecimal travelTime = null;
		CityNode prevCity = null;
		
		public CityNode(BigDecimal travelTime, CityNode prevCity) {
			this.travelTime = travelTime;
			this.prevCity = prevCity;
		}
		
		public void setParent(CityNode city) {
			this.prevCity = city;
		}
		
		public void addNextCity(CityNode nextCity) {
			nextCity.setParent(this);
			nextCities.add(nextCity);
		}
	}
	
	static class Mail {
		int U;
		int V;
		
		Mail(int U, int V) {
			this.U = U;
			this.V = V;
		}
	}
	
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
			int N = Integer.valueOf(tmp[0]);
			int Q = Integer.valueOf(tmp[1]);
			
			//List<Horse> horses = new ArrayList<>();
			int[][] horses = new int[N][2];
			for(int j = 0; j < N; j++) {
				String[] tmp2 = in.nextLine().split(" ");
				int[] horse = new int[2];
				int E = Integer.valueOf(tmp2[0]);
				int S = Integer.valueOf(tmp2[1]);
				horse[0] = E;
				horse[1] = S;
				horses[j] = horse;
				//horses.add(new Horse(E, S));
			}
			int[][] matrix = new int[N][N];
			for(int n = 0; n < N; n++) {
				String[] tmp3 = in.nextLine().split(" ");
				for(int m = 0; m < N; m++) {
					matrix[n][m] = Integer.valueOf(tmp3[m]);
				}
			}
			List<Mail> mails = new ArrayList<>();
			for(int q = 0; q < Q; q++) {
				String[] tmp4 = in.nextLine().split(" ");
				int U = Integer.valueOf(tmp4[0]);
				int V = Integer.valueOf(tmp4[1]);
				mails.add(new Mail(U, V));
			}
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			//String result = calc(N, Q, horses, matrix, mails);
			String result = calcSmall(N, horses, matrix);
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
	
	private static String calcSmall(int N, int[][] horses, int[][] matrix) {
		System.out.println("N: " + N);
	
		int distance = matrix[0][1];
		BigDecimal travelDistance = new BigDecimal(distance);
		BigDecimal travelVelocity = new BigDecimal(horses[0][1]);
		BigDecimal travelTime = travelDistance.divide(travelVelocity, 10, RoundingMode.HALF_UP);
		CityNode root = new CityNode(travelTime, null);
		
		return "SMALL";
	}
	
	private static BigDecimal travelTime(int s, int horse, int[][] horses) {
		BigDecimal travelDistance = new BigDecimal(s);
		BigDecimal travelVelocity = new BigDecimal(horses[horse][1]);
		return travelDistance.divide(travelVelocity, 10, RoundingMode.HALF_UP);
	}
	
	private static String calc(int N, int Q, int[][] horses, int[][] matrix, List<Mail> mails) {
		System.out.println("N: " + N + ", Q: " + Q);
		for(int[] horse : horses) {
			System.out.println(horse[0] + ", " + horse[1]);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		for(Mail mail : mails) {
			System.out.println(mail.U + " -> " + mail.V);
		}
		return "RESULT";
	}
}
