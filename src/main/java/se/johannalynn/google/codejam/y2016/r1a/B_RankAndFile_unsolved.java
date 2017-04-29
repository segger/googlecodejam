package se.johannalynn.google.codejam.y2016.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * When Sergeant Argus's army assembles for drilling, they stand in the shape of an N by N square grid,
 * with exactly one soldier in each cell. Each soldier has a certain height.

Argus believes that it is important to keep an eye on all of his soldiers at all times. Since he likes
to look at the grid from the upper left, he requires that:

Within every row of the grid, the soldiers' heights must be in strictly increasing order, from left to right.
Within every column of the grid, the soldiers' heights must be in strictly increasing order, from top to bottom.
Although no two soldiers in the same row or column may have the same height, it is possible for multiple
soldiers in the grid to have the same height.

Since soldiers sometimes train separately with their row or their column, Argus has asked you to make a
report consisting of 2*N lists of the soldiers' heights: one representing each row (in left-to-right order)
and column (in top-to-bottom order). As you surveyed the soldiers, you only had small pieces of paper to
write on, so you wrote each list on a separate piece of paper. However, on your way back to your office,
you were startled by a loud bugle blast and you dropped all of the pieces of paper, and the wind blew one
away before you could recover it! The other pieces of paper are now in no particular order, and you can't
even remember which lists represent rows and which represent columns, since you didn't write that down.

You know that Argus will make you do hundreds of push-ups if you give him an incomplete report. Can you
figure out what the missing list is?


 * @author segger
 *
 */
public class B_RankAndFile_unsolved {
	private static final String YEAR = "y2016";
	private static final String ROUND = "r1a";
	
	private static final String BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	private static final String OUT_PATH = BASE_PATH + "/" + YEAR + "/" + ROUND + "/";
	//private static final String OUT_PATH = "out/";
	
	//private static final String FILE = "B-small-practice";
	private static final String FILE = "B";
	private static final String IN_FILE = FILE + ".in";
	private static final String OUT_FILE = FILE + ".out";

	static class Notes {
		List<String[]> notes;
		
		Notes(String[] note) {
			notes = new ArrayList<>();
			notes.add(note);
		}
		
		void addNote(String[] note) {
			notes.add(note);
		}
		
		String[] getFirstNote() {
			return notes.get(0);
		}
		
		String[] getSecondNote() {
			if(nbrOfNotes() == 1) {
				return null;
			}
			return notes.get(1);
		}
		
		int nbrOfNotes() {
			return notes.size();
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
			int N = Integer.valueOf(in.nextLine());
			
			Map<String, Notes> firstMap = new HashMap<>();
			for(int j = 0; j < 2*N-1; j++) {
				String[] input = in.nextLine().split(" ");
				String first = input[0];
				Notes notes = firstMap.get(first);
				if(notes == null) {
					notes = new Notes(input);
				} else {
					notes.addNote(input);
				}
				firstMap.put(first, notes);
			}
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			String result = calc(N, firstMap);
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
	
	private static String calc(int N, Map<String, Notes> map) {
		System.out.println("N: " + N + ", map.size: " + map.size());
		
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext()) {
			String mapKey = itr.next();
			Notes notes = map.get(mapKey);
			System.out.println("mapKey: " + mapKey + ", notes.size(): " + notes.nbrOfNotes());
		}
		
		String[][] matrix = new String[N][N];
		
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
			}
			
		});
		String upperLeft = keys.get(0);
		System.out.println("upperLeft: " + upperLeft);
		Notes upperLeftNotes = map.get(upperLeft);
		
		boolean foundMissingNote = false;
		int missingNoteRowNbr = -1;
		if(upperLeftNotes.nbrOfNotes() == 1) {
			foundMissingNote = true;
			missingNoteRowNbr = 0;
		}
		String[] firstNote = upperLeftNotes.getFirstNote();
		String[] secondNote = upperLeftNotes.getSecondNote();
		
		for(int i = 0; i < N; i++) {
			matrix[i][0] = firstNote[i];
			if(!foundMissingNote) {
				matrix[0][i] = secondNote[i];
			}
		}
		
		for(int w = 0; w < N; w++) {
			for(int x = 0; x < N; x++) {
				System.out.print(matrix[w][x] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < N; i++) {
			String first = matrix[i][0];
			
			Notes nextNotes = map.get(first);
			if(nextNotes.nbrOfNotes() == 1) {
				foundMissingNote = true;
				missingNoteRowNbr = i;
			}
			String[] notes1 = nextNotes.getFirstNote();
			String[] notes2 = nextNotes.getSecondNote();
			
			if(testRow(N, notes1, matrix[i])) {
				matrix[i] = notes1;
				if(missingNoteRowNbr != i) {
					for(int k = 0; k < N; k++) {
						matrix[i][k] = notes2[k];
					}
				}
			} else {
				if(missingNoteRowNbr != i) {
					matrix[i] = notes2;
					for(int k = 0; k < N; k++) {
						matrix[i][k] = notes1[k];
					}
				}
			}
		}
		
		/*
		for(int w = 0; w < N; w++) {
			for(int x = 0; x < N; x++) {
				System.out.print(matrix[w][x] + " ");
			}
			System.out.println();
		}*/
		StringBuffer buffer = new StringBuffer();
		for(int w = 0; w < N; w++) {
			buffer.append(matrix[w][missingNoteRowNbr] + " ");
		}
		
		return buffer.toString();
	}
	
	private static boolean testRow(int N, String[] notes, String[] matrix) {
		for(int j = 0; j < N; j++) {
			if(matrix[j] != null && !matrix[j].equals(notes[j])) {
				return false;
			}
		}
		return true;
	}
}
