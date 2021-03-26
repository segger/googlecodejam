package se.johannalynn.google.codejam.y2020.r1c.overrandomized;

import kotlin.Pair;

import java.io.*;
import java.util.*;

public class Solution {

    static class LetterNumber {
        boolean[] discarded = new boolean[10];

        LetterNumber(boolean removeZero) {
            if(removeZero) {
                discarded[0] = true;
            }
        }

        boolean isZero() {
            return !discarded[0];
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            for(int i = 0; i < discarded.length; i++) {
                buffer.append(i + ": " + discarded[i] + ", ");
            }
            return buffer.toString();
        }
    }

    public static void main(String[] args) {
        try {
            String inFile = "src/main/resources/se/johannalynn/google/codejam/y2020/sample.in.txt";

            Scanner in = new Scanner(new File(inFile));
            int T = Integer.valueOf(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                int U = Integer.valueOf(in.nextLine());
                Map<String, LetterNumber> letters = new HashMap<>();
                List<Pair<Long, String>> requests = new ArrayList<>();
                int length = 10000;
                //int length = 30;
                for (int j = 0; j < length; j++) {
                    String[] test = in.nextLine().split(" ");
                    long Q = Long.parseLong(test[0]);
                    String R = test[1];
                    //System.out.println("Q -> R " + Q + " -> " + R);
                    String[] rParts = R.split("");
                    for(int k = 0; k < rParts.length; k++) {
                        if (k == 0) {
                            LetterNumber letterNumber = letters.get(rParts[k]);
                            if (letterNumber == null) {
                                letters.put(rParts[k], new LetterNumber(true));
                            } else {
                                letterNumber.discarded[0] = true;
                            }
                        } else {
                            LetterNumber letterNumber = letters.get(rParts[k]);
                            if (letterNumber == null) {
                                letters.put(rParts[k], new LetterNumber(false));
                            }
                        }
                    }
                    requests.add(new Pair<>(Q, R));

                }
                System.out.println("Case #" + i + ": " + result(U, letters, requests));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int U = Integer.valueOf(in.nextLine());
            Map<String, LetterNumber> letters = new HashMap<>();
            List<Pair<Long, String>> requests = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                String[] test = in.nextLine().split(" ");
                long Q = Long.parseLong(test[0]);
                String R = test[1];
                String[] rParts = R.split("");
                for(int k = 0; k < rParts.length; k++) {
                    if (k == 0) {
                        LetterNumber letterNumber = letters.get(rParts[k]);
                        if (letterNumber == null) {
                            letters.put(rParts[k], new LetterNumber(true));
                        }
                    }
                }
                requests.add(new Pair<>(Q, R));
            }
            System.out.println("Case #" + i + ": " + result(U, letters, requests));
        }
    }

    private static String result(int U, Map<String, LetterNumber> letters, List<Pair<Long, String>> requests) {
        Iterator<Map.Entry<String, LetterNumber>> itr = letters.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, LetterNumber> tmp = itr.next();
            System.out.println(tmp.getKey() + ", " + tmp.getValue());
        }
        return "";
    }
}
