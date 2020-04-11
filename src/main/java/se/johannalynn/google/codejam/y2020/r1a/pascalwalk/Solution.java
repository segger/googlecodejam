package se.johannalynn.google.codejam.y2020.r1a.pascalwalk;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String data = "4\n" +
                "1\n" +
                "4\n" +
                "19\n" +
                "501\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.valueOf(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                int N = Integer.valueOf(in.nextLine());
                System.out.println("Case #" + i + ":\n" + result(N));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int N = Integer.valueOf(in.nextLine());
            System.out.println("Case #" + i + ":\n" + result(N));
        }
    }

    private static String result(int N) {
        StringBuffer buffer = new StringBuffer();
        if (N == 501) {
            buffer.append("1 1\n"); // 1
            buffer.append("2 1\n"); // 2
            buffer.append("3 1\n"); // 3
            buffer.append("4 1\n"); // 4
            buffer.append("5 2\n"); // 8
            buffer.append("5 1\n"); // 9
            int sum = 9;
            for (int i = 6; i <= 495; i++) {
                buffer.append(i + " 1\n");
                sum++;
            }

        } else {
            for (int i = 1; i <= N; i++) {
                buffer.append(i + " 1");
                if(i != N) {
                    buffer.append("\n");
                }
            }
        }
        return buffer.toString();
    }
}
