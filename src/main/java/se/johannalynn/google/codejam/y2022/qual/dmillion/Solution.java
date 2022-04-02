package se.johannalynn.google.codejam.y2022.qual.dmillion;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String data = "8\n" +
                "4\n" +
                "6 10 12 8\n" +
                "6\n" +
                "5 4 5 4 4 4\n" +
                "10\n" +
                "10 10 7 6 7 4 4 5 7 4\n" +
                "1\n" +
                "10\n" +
                "10\n" +
                "1 1 1 1 1 1 1 1 1 1\n"+
                "10\n" +
                "1 2 2 2 2 2 2 2 2 3\n"+
                "20\n" +
                "20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20\n"+
                "20\n" +
                "1 2 2 2 2 2 3 3 3 3 4 5 6 7 8 8 8 8 8 20\n";

        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                int N = Integer.parseInt(in.nextLine());
                String[] input = in.nextLine().split(" ");
                int[] max = new int[N];
                for (int j = 0; j < N; j++) {
                    max[j] = Integer.parseInt(input[j]);
                }
                System.out.println("Case #" + i + ": " + result(N, max));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(in.nextLine());
            String[] input = in.nextLine().split(" ");
            int[] max = new int[N];
            for (int j = 0; j < N; j++) {
                max[j] = Integer.parseInt(input[j]);
            }
            System.out.println("Case #" + i + ": " + result(N, max));
        }
    }

    private static String result(int N, int[] max) {
        StringBuilder buffer = new StringBuilder();
        Arrays.sort(max);
        int maxLength = 1;
        int length = 0;
        int nbr = 0;
        int c = 0;

        while(c < N) {
            nbr++;
            // System.out.println("c: " + c + ", nbr: " + nbr + ", max[c]: " + max[c]);
            if (max[c] >= nbr) {
                length++;
            } else {
                nbr--;
            }
            c++;
        }

        if (length > maxLength) {
            maxLength = length;
        }




        buffer.append(maxLength);
        return buffer.toString();
    }
}
