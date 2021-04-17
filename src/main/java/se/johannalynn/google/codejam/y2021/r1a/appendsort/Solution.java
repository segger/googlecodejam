package se.johannalynn.google.codejam.y2021.r1a.appendsort;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private static final boolean debug = true;

    public static void main(String[] args) {
        if (debug) {
            String data = "6\n" +
                    "3\n" +
                    "100 7 10\n" +
                    "2\n" +
                    "10 10\n" +
                    "4\n" +
                    "4 19 1 101\n" +
                    "3\n" +
                    "1 2 3\n" +
                    "20\n" +
                    "10 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3\n" +
                    "10\n" +
                    "10000000000 10000000000 10000000000 10000000000 10000000000 10000000000 10000000000 10000000000 10000000000 10000000000";
            InputStream stdin = System.in;
            try {
                System.setIn(new ByteArrayInputStream(data.getBytes()));
                run(args);
            } finally {
                System.setIn(stdin);
            }
        } else {
            run(args);
        }
    }

    public static void run(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(in.nextLine());
            String[] X = in.nextLine().split(" ");
            System.out.println("Case #" + i + ": " + result(N, X));
        }
    }

    private static String result(int N, String[] X) {
        StringBuilder buffer = new StringBuilder();
        int sum = 0;
        long nbr = Long.parseLong(X[0]);
        for(int i = 1; i < N; i++) {
            long next = Long.parseLong(X[i]);
            while (next <= nbr) {
                String tmp = X[i];
                long test1 = Long.parseLong(tmp + "0");
                long test2 = Long.parseLong(tmp + "9");
                if (test1 <= nbr && test2 > nbr) {
                    long test = nbr + 1;
                    String testAsString = String.valueOf(test);
                    String lastNbr = testAsString.substring(testAsString.length() - 1);
                    X[i] = X[i] + lastNbr;
                    next = Long.parseLong(X[i]);
                    sum++;
                } else {
                    X[i] = X[i] + "0";
                    next = Long.parseLong(X[i]);
                    sum++;
                }
            }
            nbr = next;
        }
        buffer.append(sum);
        return buffer.toString();
    }
}
