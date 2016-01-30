package se.johannalynn.google.codejam.y2014.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class A_Unsolved {
	private static final String IN_BASE_PATH = "src/main/resources/se/johannalynn/google/codejam";
	private static final String IN_PATH = IN_BASE_PATH + "/y2014/r1a/";
	private static final String OUT_PATH = "out/y2014/r1a/";
	private static final String IN_FILE = "A-small-attempt0.in";
	private static final String OUT_FILE = "A-small-attempt0.out";

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
			String[] tmp = in.nextLine().split(" ");
			int N = Integer.valueOf(tmp[0]);
			int L = Integer.valueOf(tmp[1]);
			String[] tmp2 = in.nextLine().split(" ");
			String[] tmp3 = in.nextLine().split(" ");

			int caseNbr = i + 1;
			buffer.append("Case #" + caseNbr + ": ");
			buffer.append(calc(N, L, tmp2, tmp3));
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

	private static boolean possible(String[] devices, HashSet<String> switched) {
		for (String device : devices) {
			if (!switched.contains(device)) {
				return false;
			}
		}
		return true;
	}

	private static String calc(int N, int L, String[] initial, String[] devices) {
		System.out.println("calc");
		final String NOT_POSSIBLE = "NOT POSSIBLE";
		int maxNbr = (int)Math.pow(2, L);
		
		int countSwitches = 0;

		HashSet<String> switched = new HashSet<String>();
		for (String charge : initial) {
			switched.add(charge);
		}
		
		if (possible(devices, switched)) {
			return String.valueOf(countSwitches);
		}
		
		List<HashSet<String>> switchList = new ArrayList<HashSet<String>>();
		switchList.add(switched);
		
		while(countSwitches < L) {
			countSwitches++;
			
			List<HashSet<String>> howManyList = new ArrayList<HashSet<String>>();
			int tmp = 0;
			for(HashSet<String> switched2 : switchList) {
				List<HashSet<String>> sList = switchSet(L, maxNbr, switched2, devices);
				System.out.println("sList: " + sList.size());
				for(HashSet<String> s : sList) {
					if(possible(devices, s)) {
						return String.valueOf(countSwitches);
					}
				}
				if(tmp < 2) {
					howManyList.addAll(sList);
					tmp++;
				}
				System.out.println("howManyLsit: " + howManyList.size());
				System.out.println("count: " + countSwitches);
			}
			
			switchList = howManyList;
			System.out.println("switchList: " + switchList.size());
		}
		
		return NOT_POSSIBLE;
	}

	/*
	private static String tryNext(int L, int maxNbr, String[] devices, int countSwitches, HashSet<String> one) {
		List<HashSet<String>> switchOne = switchSet(L, maxNbr, one);
		for(HashSet<String> s : switchOne) {
			if(possible(devices, s)) {
				return String.valueOf(countSwitches);
			} else {
				tryNext(L, maxNbr, devices, countSwitches++, s);
			}
		}
	}*/
	
	private static HashSet<String> tmp(int i, int L, int max, HashSet<String> switchMe) {
		HashSet<String> switchDone = new HashSet<String>();
		Iterator<String> itr = switchMe.iterator();
		while (itr.hasNext()) {
			String charge = itr.next();
			int add = (int)Math.pow(2, i);
			int nbr = Integer.parseInt(charge, 2);
			int nextNbr = nbr + add;
			
			if(nextNbr >= max) {
				nextNbr = nextNbr % max;
			}
			String binaryNextNbr = Integer.toBinaryString(nextNbr);
			if(binaryNextNbr.length() < L) {
				StringBuffer buffer = new StringBuffer();
				for(int j=L-binaryNextNbr.length(); j>0; j--) {
					buffer.append("0");
				}
				buffer.append(binaryNextNbr);
				binaryNextNbr = buffer.toString();
			}
			//System.out.println(charge + " -> " + binaryNextNbr);
			
			switchDone.add(binaryNextNbr);
		}
		return switchDone;
	}
	
	private static List<HashSet<String>> switchSet(int L, int max, HashSet<String> switchMe, String[] devices) {
		List<HashSet<String>> switchedList = new ArrayList<HashSet<String>>();
		int i = 0;
		while(i < L) {
			HashSet<String> switchDone = tmp(i, L, max, switchMe);
			
			boolean missmatch = false;
			int deviceCount = 0;
			boolean startMatch = switchDone.contains(devices[deviceCount]);
			deviceCount++;
			while(!missmatch && deviceCount < devices.length) {
				boolean tmpMatch = switchDone.contains(devices[deviceCount]);
				if(startMatch) {
					if(!tmpMatch) {
						missmatch = true;
					}
				} else {
					if(tmpMatch) {
						missmatch = true;
					}
				}
				
				deviceCount++;
			}
			if(!missmatch) {
				switchedList.add(switchDone);
			}
			
			i++;
		}
		return switchedList;
	}
}
