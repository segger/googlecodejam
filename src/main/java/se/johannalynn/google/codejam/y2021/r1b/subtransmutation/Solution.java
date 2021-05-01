package se.johannalynn.google.codejam.y2021.r1b.subtransmutation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final boolean debug = true;

    public static void main(String[] args) {
        if (debug) {
            String data = "3\n" +
                    "2 1 2\n" +
                    "1 2\n" +
                    "5 1 2\n" +
                    "2 0 0 0 1\n" +
                    "3 1 2\n" +
                    "1 1 1\n";
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
            String[] input = in.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int A = Integer.parseInt(input[1]);
            int B = Integer.parseInt(input[2]);
            String[] U = in.nextLine().split(" ");
            System.out.println("Case #" + i + ": " + result(N, A, B, U));
        }
    }

    private static String result(int N, int A, int B, String[] U) {
        StringBuffer buffer = new StringBuffer();
        System.out.println("N: " + N + ", A: " + A + ", B: " + B);
        Arrays.asList(U).forEach(System.out::println);

        return buffer.toString();
    }
}
