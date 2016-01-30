package se.johannalynn.google.codejam.y2008.qual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B_TrainTable {

	private static final String IN_FILE = "B-large-practice.in";
	private static final String OUT_FILE = "B-large-practice.out";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String inPath = "src/main/resources/se/johannalynn/google/codejam/y2008/qual/";
		String inFileName = inPath + IN_FILE;
		Scanner in = new Scanner(new File(inFileName));
		
		StringBuffer buffer = new StringBuffer();
		
		int n = Integer.valueOf(in.nextLine());
		//System.out.println(n);
		for(int i = 0; i < n; i++) {
			int t = Integer.valueOf(in.nextLine());
			//System.out.println(t);
			String[] n_tmp = in.nextLine().split(" ");
			int na = Integer.valueOf(n_tmp[0]);
			int nb = Integer.valueOf(n_tmp[1]);
			//System.out.println(na + " " + nb);
			List<String> aDeps = new ArrayList<String>();
			List<String> aArrs = new ArrayList<String>();
			for(int x = 0; x < na; x++) {
				String[] a_tmp = in.nextLine().split(" ");
				String aDep = a_tmp[0];
				aDeps.add(aDep);
				String aArr = a_tmp[1];
				aArrs.add(addMinutes(aArr, t));
				//System.out.println(aDep + " " + aArr);
			}
			Collections.sort(aDeps, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(before(o1, o2)) {
						return -1;
					} else {
						return 1;
					}
				}
				
			});
			List<String> bDeps = new ArrayList<String>();
			List<String> bArrs = new ArrayList<String>();
			for(int y = 0; y < nb; y++) {
				String[] b_tmp = in.nextLine().split(" ");
				String bDep = b_tmp[0];
				bDeps.add(bDep);
				String bArr = b_tmp[1];
				bArrs.add(addMinutes(bArr, t));
				//System.out.println(bDep + " " + bArr);
			}
			Collections.sort(bDeps, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(before(o1, o2)) {
						return -1;
					} else {
						return 1;
					}
				}
				
			});
			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": " + trains(aDeps, aArrs, bDeps, bArrs) + "\n");
			
		}
		
		//print to file
		String outPath = "out/y2008/qual/";
		String outFileName = outPath + OUT_FILE;
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(outFileName)));
		out.write(buffer.toString());
		out.close();
	}

	private static String trains(List<String> aDeps, List<String> aArrs, List<String> bDeps, List<String> bArrs) {
		int aTrains = 0;
		int bTrains = 0;
		
		if(aDeps.isEmpty() || bDeps.isEmpty()) {
			if(!aDeps.isEmpty() && bDeps.isEmpty()) {
				aTrains++;
				aDeps.remove(0);
			} else if (!bDeps.isEmpty() && aDeps.isEmpty()) {
				bTrains++;
				bDeps.remove(0);
			}
		} else {
			String aFirst = aDeps.get(0);
			String bFirst = bDeps.get(0);
			if(before(aFirst, bFirst)) {
				aTrains++;
				aDeps.remove(0);
			} else {
				bTrains++;
				bDeps.remove(0);
			}
		}
		
		for(String aDep : aDeps) {
			String remove = "";
			boolean found = false;
			for(String bArr : bArrs) {
				if(before(bArr, aDep)) {
					remove = bArr;
					found = true;
					break;
				}
			}
			if(found) {
				bArrs.remove(remove);
			} else {
				aTrains++;
			}
		}
		
		for(String bDep : bDeps) {
			String remove = "";
			boolean found = false;
			for(String aArr : aArrs) {
				if(before(aArr, bDep)) {
					remove = aArr;
					found = true;
					break;
				}
			}
			if(found) {
				aArrs.remove(remove);
			} else {
				bTrains++;
			}
		}
		
		return aTrains + " " + bTrains;
	}
	
	private static int[] toInt(String time) {
		int[] retTime = new int[2];
		String[] tmp = time.split(":");
		retTime[0] = Integer.valueOf(tmp[0]);
		retTime[1] = Integer.valueOf(tmp[1]);
		return retTime;
	}
	
	private static boolean before(String time1, String time2) {
		int[] time1Tmp = toInt(time1);
		int[] time2Tmp = toInt(time2);
		
		if(time2Tmp[0] < time1Tmp[0]) {
			return false;
		} else if(time2Tmp[0] > time1Tmp[0]) {
			return true;
		} else {
			if(time2Tmp[1] < time1Tmp[1]) {
				return false;
			} else {
				return true; //equals -> before
			}
		}
	}
	
	private static String addMinutes(String time, int add) {
		int[] timeTmp = toInt(time);
		int hour = timeTmp[0];
		int min = timeTmp[1];
		int tmp = min + add;
		
		while(tmp >= 60) {
			tmp -= 60;
			hour++;
		}
		
		return hour + ":" + tmp;
	}
}
