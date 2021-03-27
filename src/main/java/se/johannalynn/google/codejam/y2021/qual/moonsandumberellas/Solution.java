package se.johannalynn.google.codejam.y2021.qual.moonsandumberellas;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    /*
    Case #1: 5
Case #2: 10
Case #3: 1
Case #4: 0
     */

    public static void main(String[] args) {
        /* String data = "4\n" +
                "2 3 CJ?CC?\n" +
                "4 2 CJCJ\n" +
                "1 3 C?J\n" +
                "2 5 ??J???\n"; */
        String data = "1\n" +
                "2 -5 ??JJ??\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                String[] input = in.nextLine().split(" ");
                int X = Integer.parseInt(input[0]);
                int Y = Integer.parseInt(input[1]);
                String art = input[2];
                System.out.println("Case #" + i + ": " + result(X, Y, art));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String[] input = in.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String art = input[2];
            System.out.println("Case #" + i + ": " + result(X, Y, art));
        }
    }

    private static String resultOne(int X, int Y, String art) {
        StringBuilder buffer = new StringBuilder();

        // System.out.println("X: " + X + ", Y: " + Y + ", art: " + art);

        int[] charArray = art.chars().toArray();
        // Map<String, Integer> prices = new HashMap<>();
        // List<Integer> prices = new ArrayList<>();
        List<StringBuffer> tryArt = new ArrayList<>();

        int former = charArray[0];

        if (former == 'C' || former == 'J') {
            StringBuffer newBuffer = new StringBuffer();
            newBuffer.append((char) former);
            tryArt.add(newBuffer);
        } else {
            StringBuffer buffer1 = new StringBuffer();
            buffer1.append("C");
            tryArt.add(buffer1);

            StringBuffer buffer2 = new StringBuffer();
            buffer2.append("J");
            tryArt.add(buffer2);
        }

        for (int i = 1; i < charArray.length; i++) {
            int current = charArray[i];
            if (current == 'C' || current == 'J') {
                tryArt.forEach((buff) -> buff.append((char)current));
            } else {
                List<StringBuffer> newTryArts = new ArrayList<>();
                for(StringBuffer tmp : tryArt) {
                    StringBuffer copy = new StringBuffer();
                    copy.append(tmp.toString());
                    copy.append("J");
                    newTryArts.add(copy);

                    tmp.append("C");
                }
                tryArt.addAll(newTryArts);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(StringBuffer artsy : tryArt) {

            int cost = 0;

            char[] tmp = artsy.toString().toCharArray();
            char formerChar = tmp[0];
            for (int k = 1; k < tmp.length; k++) {
                char currentChar = tmp[k];
                if (formerChar == 'J' && currentChar == 'C') {
                    cost += Y;
                } else if (formerChar == 'C' && currentChar == 'J') {
                    cost += X;
                }

                formerChar = currentChar;
            }

            if (cost < minCost) {
                minCost = cost;
            }
        }

        buffer.append(minCost);
        return buffer.toString();
    }

    private static String result(int X, int Y, String art) {
        StringBuilder buffer = new StringBuilder();

        // System.out.println("X: " + X + ", Y: " + Y + ", art: " + art);

        int[] charArray = art.chars().toArray();

        int former = charArray[0];
        int currentCost = 0;
        for (int i = 1; i < charArray.length; i++) {
            int current = charArray[i];
            if (current == 'J' || current == 'C') {
                if (former == 'C' && current == 'J') {
                    currentCost += X;

                } else if (former == 'J' && current == 'C') {
                    currentCost += Y;
                } else if (former == '?') {
                    if (current == 'J') {
                        if (X > 0) { // no payout

                        } else { // CJ
                            currentCost += X;
                        }
                    } else if (current == 'C') {
                        if (Y > 0) { // no payout

                        } else { // JC
                            currentCost += Y;
                        }
                    }
                }
                former = current;
            } else if (former != '?' && current == '?') {
                if (former == 'C') {
                    if (X > 0) { // no payout
                        former = 'C';
                    } else { // CJ
                        currentCost += X;
                        former = 'J';
                    }
                } else if (former == 'J') {
                    if (Y > 0) { // no payout
                        former = 'J';
                    } else { // JC
                        currentCost += Y;
                        former = 'C';
                    }
                }
            } else if (former == '?' && current == '?') {
                // extra credit
                former = current;
            }
        }

        buffer.append(currentCost);
        return buffer.toString();
    }
}
