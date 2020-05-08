package se.johannalynn.google.codejam.y2020.r1c.overexcitedfan;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String data = "2\n" +
                "3 2 SSSW\n" +
                "4 0 NESW\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.valueOf(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                String[] input = in.nextLine().split(" ");
                int X = Integer.parseInt(input[0]);
                int Y = Integer.parseInt(input[1]);
                String M = input[2];
                System.out.println("Case #" + i + ": " + result(X, Y, M));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String[] input = in.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String M = input[2];
            System.out.println("Case #" + i + ": " + result(X, Y, M));
        }
    }

    private static String result(int X, int Y, String M) {
        String result = "IMPOSSIBLE";
        //System.out.println("x: " + X + ", y: " + Y + ", m: " + M);
        int tour = M.length();

        int ax = 0;
        int ay = 0;

        int bx = X;
        int by = Y;

        int c = 0;
        while(c < tour) {
            switch(M.charAt(c)) {
                case 'N': by++; break;
                case 'S': by--; break;
                case 'W': bx--; break;
                case 'E': bx++; break;
            }

            //System.out.println(bx + ", " + by);
            int distance = Math.abs(ax - bx) + Math.abs(ay - by);
            //System.out.println("distance: " + distance + ", c: " + c);

            int time = c + 1;
            if (distance <= time) {
                return String.valueOf(time);
            }
            c++;
        }
        return result;
    }
}
