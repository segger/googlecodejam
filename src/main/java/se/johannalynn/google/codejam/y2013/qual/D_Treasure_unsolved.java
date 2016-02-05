package se.johannalynn.google.codejam.y2013.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Following an old map, you have stumbled upon the Dread Pirate Larry's secret treasure trove!

The treasure trove consists of N locked chests, each of which can only be opened by a key of a specific type.
Furthermore, once a key is used to open a chest, it can never be used again. Inside every chest, you will of
course find lots of treasure, and you might also find one or more keys that you can use to open other chests.
A chest may contain multiple keys of the same type, and you may hold any number of keys.

You already have at least one key and your map says what other keys can be found inside the various chests.
With all this information, can you figure out how to unlock all the chests?

For example, suppose the treasure trove consists of four chests as described below, and you began with exactly
one key of type 1:

Chest Number  |  Key Type To Open Chest  |  Key Types Inside
--------------+--------------------------+------------------
1             |  1                       |  None
2             |  1                       |  1, 3
3             |  2                       |  None
4             |  3                       |  2
You can open all the chests in this example if you do them in the order 2, 1, 4, 3. If you start by opening
chest #1 first, then you will have used up your only key, and you will be stuck.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins
with a single line containing two positive integers K and N, representing the number of keys you start with
and the number of chests you need to open.

This is followed by a line containing K integers, representing the types of the keys that you start with.

After that, there will be N lines, each representing a single chest. Each line will begin with integers
Ti and Ki, indicating the key type needed to open the chest and the number of keys inside the chest.
These two integers will be followed by Ki more integers, indicating the types of the keys contained within
the chest.

Output

For each test case, output one line containing "Case #x: C1 C2 ... CN", where x is the case number
(starting from 1), and where Ci represents the index (starting from 1) of the ith chest that you should open.

If there are multiple ways of opening all the chests, choose the "lexicographically smallest" way.
In other words, you should choose to make C1 as small as possible, and if there are multiple ways of
making C1 as small as possible, choose the one that makes C2 as small as possible, and so on.

If there is no way to open all the chests, you should instead output one line containing "Case #x: IMPOSSIBLE".

Limits

1 ≤ T ≤ 25.
1 ≤ K.
All key types will be integers between 1 and 200 inclusive.
Small dataset

1 ≤ N ≤ 20.
In each test case, there will be at most 40 keys altogether.
Large dataset

1 ≤ N ≤ 200.
In each test case, there will be at most 400 keys altogether.
 * @author segger
 *
 */
public class D_Treasure_unsolved {
	private static final String YEAR = "y2013";
	private static final String ROUND = "qual";
	
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = "out/" + YEAR + "/" + ROUND + "/";
	
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
		int T = Integer.valueOf(in.nextLine());
		// System.out.println(n);
		
		for (int i = 0; i < T; i++) {
			String[] tmp = in.nextLine().split(" ");
			//int K = Integer.valueOf(tmp[0]);
			int N = Integer.valueOf(tmp[1]);
			
			List<String> keys = Arrays.asList(in.nextLine().split(" "));
			Map<String, List<String>> unopenChests = new HashMap<String, List<String>>();
			
			for(int n = 0; n < N; n++) {
				String[] chests = in.nextLine().split(" ");
				List<String> tmpList = Arrays.asList(chests);
				String type = chests[0];
				//int k = Integer.valueOf(chests[1]);
				List<String> contentList = tmpList.subList(2, tmpList.size()-1);
				unopenChests.put(type, contentList);
			}
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(N, keys, unopenChests));
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
	
	private static String calc(int N, List<String> keys, Map<String, List<String>> unopenChests) {
		for(String key : keys) {
			List<String> newKeys = unopenChests.get(key);
			if(newKeys != null) {
				
			}
		}
		return "";
	}
}