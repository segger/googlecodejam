package se.johannalynn.google.codejam.y2013.r1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Armin is playing Osmos, a physics-based puzzle game developed by Hemisphere
 * Games. In this game, he plays a "mote", moving around and absorbing smaller
 * motes.
 * 
 * A "mote" in English is a small particle. In this game, it's a thing that
 * absorbs (or is absorbed by) other things! The game in this problem has a
 * similar idea to Osmos, but does not assume you have played the game.
 * 
 * When Armin's mote absorbs a smaller mote, his mote becomes bigger by the
 * smaller mote's size. Now that it's bigger, it might be able to absorb even
 * more motes. For example: suppose Armin's mote has size 10, and there are
 * other motes of sizes 9, 13 and 19. At the start, Armin's mote can only absorb
 * the mote of size 9. When it absorbs that, it will have size 19. Then it can
 * only absorb the mote of size 13. When it absorbs that, it'll have size 32.
 * Now Armin's mote can absorb the last mote.
 * 
 * Note that Armin's mote can absorb another mote if and only if the other mote
 * is smaller. If the other mote is the same size as his, his mote can't absorb
 * it.
 * 
 * You are responsible for the program that creates motes for Armin to absorb.
 * The program has already created some motes, of various sizes, and has created
 * Armin's mote. Unfortunately, given his mote's size and the list of other
 * motes, it's possible that there's no way for Armin's mote to absorb them all.
 * 
 * You want to fix that. There are two kinds of operations you can perform, in
 * any order, any number of times: you can add a mote of any positive integer
 * size to the game, or you can remove any one of the existing motes. What is
 * the minimum number of times you can perform those operations in order to make
 * it possible for Armin's mote to absorb every other mote?
 * 
 * For example, suppose Armin's mote is of size 10 and the other motes are of
 * sizes [9, 20, 25, 100]. This game isn't currently solvable, but by adding a
 * mote of size 3 and removing the mote of size 100, you can make it solvable in
 * only 2 operations. The answer here is 2.
 * 
 * Input
 * 
 * The first line of the input gives the number of test cases, T. T test cases
 * follow. The first line of each test case gives the size of Armin's mote, A,
 * and the number of other motes, N. The second line contains the N sizes of the
 * other motes. All the mote sizes given will be integers.
 * 
 * Output
 * 
 * For each test case, output one line containing "Case #x: y", where x is the
 * case number (starting from 1) and y is the minimum number of operations
 * needed to make the game solvable.
 * 
 * Limits
 * 
 * 1 ≤ T ≤ 100. Small dataset
 * 
 * 1 ≤ A ≤ 100. 1 ≤ all mote sizes ≤ 100. 1 ≤ N ≤ 10.
 * 
 * Large dataset
 * 
 * 1 ≤ A ≤ 106. 1 ≤ all mote sizes ≤ 106. 1 ≤ N ≤ 100.
 * 
 * @author segger
 * 
 */
public class A_Osmos_unsolved {
	private static final String YEAR = "y2013";
	private static final String ROUND = "r1b";

	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/"
			+ ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";

	private static final String FILE = "A-large-practice";
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

		for (int i = 0; i < T; i++) {
			String[] tmp = in.nextLine().split(" ");
			int A = Integer.valueOf(tmp[0]);
			int N = Integer.valueOf(tmp[1]);
			String[] tmpMotes = in.nextLine().split(" ");
			Integer[] motes = new Integer[N];
			for (int j = 0; j < N; j++) {
				motes[j] = Integer.valueOf(tmpMotes[j]);
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(A, N, motes));
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

	private static String calc(int A, int N, Integer[] motes) {
		System.out.println(" ======= ");
		Arrays.sort(motes);
		BigInteger theA = new BigInteger(String.valueOf(A));
		int index = 0;
		int max = N;
		//int result = 0;
		BigInteger result = BigInteger.ZERO;
		while (index < max) {
			System.out.println("index " + index + ", max " + max);
			BigInteger next = new BigInteger(String.valueOf(motes[index]));
			//int next = motes[index];
			
			//if(A > next) {
			if(theA.compareTo(next) >= 1) {
				theA = theA.add(next);
				//A += next;
				index++;
			} else {
				BigInteger addResult = tryAdd(theA, index, max, motes);
				//int addResult = tryAdd(theA, index, max, motes);
				//int addResult = trySmallAdd(A, index, max, motes);
				//if(addResult >= 1 && theA.compareTo(BigInteger.ONE) != 0) {
				//if(addResult >= 1) {
				if(addResult.compareTo(BigInteger.ONE) >= 0) {
					BigInteger A_tmp = new BigInteger(String.valueOf(theA));
					//int A_tmp = A;
					for(BigInteger i = BigInteger.ZERO; i.compareTo(addResult) < 0; i = i.add(BigInteger.ONE)) {
						BigInteger theAddedMote = A_tmp.subtract(BigInteger.ONE); //added = A_tmp - 1
						A_tmp = A_tmp.add(theAddedMote); //A_tmp += added
						//A_tmp += (A_tmp - 1);
					}
					theA = A_tmp;
					//A = A_tmp;
					result = result.add(addResult);
					//result += addResult;
				} else {
					result = result.add(BigInteger.ONE);
					//result++;
					max--;
				}
			}
		}
		return String.valueOf(result);
	}

	private static int trySmallAdd(int A, int index, int max, Integer[] motes) {
		int removes = max - index;
		int next = motes[index];
		
		int add = 1;
		int A_tmp = A + (A-1);
		while(A_tmp <= next) {
			if(add >= removes) {
				return 0;
			}
			add++;
			A_tmp += (A_tmp - 1);
		}
		return add;
	}
	
	private static BigInteger tryAdd(BigInteger A, int index, int max, Integer[] motes) {
		//int removes = max - index;
		BigInteger theMax = new BigInteger(String.valueOf(max));
		BigInteger theIndex = new BigInteger(String.valueOf(index));
		BigInteger removes = theMax.subtract(theIndex);
		BigInteger next = new BigInteger(String.valueOf(motes[index]));
		
		//int add = 1;
		BigInteger add = BigInteger.ONE;
		BigInteger A_tmp = A.add(A.subtract(BigInteger.ONE));
		//while(A_tmp <= next) {
		while(A_tmp.compareTo(next) <= 0) {
			//if(add >= removes) {
			if(add.compareTo(removes) >= 0) {
				return BigInteger.ZERO;
			}
			add = add.add(BigInteger.ONE);
			//add++;
			A_tmp = A_tmp.add(A_tmp.subtract(BigInteger.ONE));
		}
		return add;
	}
}