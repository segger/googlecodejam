package se.johannalynn.google.codejamio.y2021.inconstantordering;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final boolean debug = true;

    /*
Case #1: ABDCBA
Case #2: ABCDEFA
Case #3: ABC

     */

    public static void main(String[] args) {
        if (debug) {
            String data = "4\n" +
                    "2\n" +
                    "2 3\n" +
                    "2\n" +
                    "5 1\n" +
                    "1\n" +
                    "2\n" +
                    "5\n" +
                    "5 25 4 4 10\n";
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
            String[] L = in.nextLine().split(" ");
            System.out.println("Case #" + i + ": " + result(N, L));
        }
    }

    private static String result(int N, String[] L) {
        StringBuilder buffer = new StringBuilder();

        // List<Integer> intList = Arrays.stream(S).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        // Collections.sort(intList);
        buffer.append("A");
        for(int i = 0; i < N; i++) {
            int Lrule = Integer.parseInt(L[i]);
            if (i % 2 != 0) { // even
                StringBuilder evenBuilder = new StringBuilder();
                for (int m = 0; m < Lrule; m++) {
                    int letter = 'A' + m;
                    evenBuilder.append((char)letter);
                }
                evenBuilder.reverse();
                buffer.append(evenBuilder);
            } else {
                StringBuilder oddBuffer = new StringBuilder();
                for (int n = 1; n < Lrule; n++) {
                    int letter = 'A' + n;
                    oddBuffer.append((char)letter);
                }
                if (i + 1 < N) { // not the last one
                    int nextL = Integer.parseInt(L[i + 1]);
                    if (Lrule < nextL) {
                        // jump
                        int diff = nextL - Lrule;
                        int letter = 'A' + Lrule + diff;
                        oddBuffer.append((char)letter);
                    } else {
                        int letter = 'A' + Lrule;
                        oddBuffer.append((char)letter);
                    }
                } else { // last block
                    int letter = 'A' + Lrule;
                    oddBuffer.append((char)letter);
                }
                buffer.append(oddBuffer);
            }
        }
        return buffer.toString();
    }
}
