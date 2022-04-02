package se.johannalynn.google.codejam.y2022.qual.punchedcards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main2(String[] args) {
        String data = "3\n" +
                "2 2\n" +
                "10 10\n" +
                "2 3\n";

        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                String[] input = in.nextLine().split(" ");
                int R = Integer.parseInt(input[0]);
                int C = Integer.parseInt(input[1]);
                System.out.println("Case #" + i + ":\n" + result(R, C));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String[] input = in.nextLine().split(" ");
            int R = Integer.parseInt(input[0]);
            int C = Integer.parseInt(input[1]);
            System.out.println("Case #" + i + ":\n" + result(R, C));
        }
    }

    private static String result(int R, int C) {
        StringBuilder buffer = new StringBuilder();

        StringBuilder row1 = new StringBuilder();
        StringBuilder row2 = new StringBuilder();
        for (int i = 0; i <= R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 && j == 0) {
                    row1.append("..");
                    row2.append("..");
                } else {
                    row1.append("+-");
                    row2.append("|.");
                }
            }
            row1.append("+");
            row2.append("|");
            if (i == R) {
                buffer.append(row1);
            } else {
                buffer.append(row1 + "\n" + row2 + "\n");
            }

            row1 = new StringBuilder();
            row2 = new StringBuilder();
        }

        return buffer.toString();
    }
}
