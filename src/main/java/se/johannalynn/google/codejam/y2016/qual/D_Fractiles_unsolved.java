package se.johannalynn.google.codejam.y2016.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Problem

Long ago, the Fractal civilization created artwork consisting of linear rows of tiles. They had two types of tile that they could use: gold (G) and lead (L).

Each piece of Fractal artwork is based on two parameters: an original sequence of K tiles, and a complexity C. For a given original sequence, the artwork with complexity 1 is just that original sequence, and the artwork with complexity X+1 consists of the artwork with complexity X, transformed as follows:

replace each L tile in the complexity X artwork with another copy of the original sequence
replace each G tile in the complexity X artwork with K G tiles
For example, for an original sequence of LGL, the pieces of artwork with complexity 1 through 3 are:

C = 1: LGL (which is just the original sequence)
C = 2: LGLGGGLGL
C = 3: LGLGGGLGLGGGGGGGGGLGLGGGLGL
Here's an illustration of how the artwork with complexity 2 is generated from the artwork with complexity 1:



You have just discovered a piece of Fractal artwork, but the tiles are too dirty for you to tell what they are made of. Because you are an expert archaeologist familiar with the local Fractal culture, you know the values of K and C for the artwork, but you do not know the original sequence. Since gold is exciting, you would like to know whether there is at least one G tile in the artwork. Your budget allows you to hire S graduate students, each of whom can clean one tile of your choice (out of the KC tiles in the artwork) to see whether the tile is G or L.

Is it possible for you to choose a set of no more than S specific tiles to clean, such that no matter what the original pattern was, you will be able to know for sure whether at least one G tile is present in the artwork? If so, which tiles should you clean?

Input 
  
5
2 3 2
1 1 1
2 1 1
2 1 2
3 2 3

Output 
Case #1: 2
Case #2: 1
Case #3: IMPOSSIBLE
Case #4: 1 2
Case #5: 2 6
 * @author segger
 *
 */
public class D_Fractiles_unsolved {
	private static final String YEAR = "y2016";
	private static final String ROUND = "qual";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	
	private static final String FILE = "C";
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
			
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			//buffer.append(calc());
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
}
