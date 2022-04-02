package se.johannalynn.google.codejam.y2022.qual.dprinting;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String data = "6\n" +
                "300000 200000 300000 500000\n" +
                "300000 200000 500000 300000\n" +
                "300000 500000 300000 200000\n" +
                "1000000 1000000 0 0\n" +
                "0 1000000 1000000 1000000\n" +
                "999999 999999 999999 999999\n" +
                "768763 148041 178147 984173\n" +
                "699508 515362 534729 714381\n" +
                "949704 625054 946212 951187\n" +
                "1000000 1000000 1000000 1000000\n" +
                "1000000 1000000 1000000 1000000\n" +
                "1000000 1000000 1000000 1000000\n" +
                "0 1000000 999999 999999\n" +
                "1000000 0 999999 1000000\n" +
                "1000000 1000000 999999 1000000\n" +
                "999999 1000000 1000000 1000000\n" +
                "999999 1000000 1000000 1000000\n" +
                "999999 1000000 1000000 1000000\n";

        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                List<int[]> printers = new ArrayList<>();
                for (int p = 0; p < 3; p++) {
                    String[] input = in.nextLine().split(" ");
                    int[] printer = new int[4];
                    printer[0] = Integer.parseInt(input[0]);
                    printer[1] = Integer.parseInt(input[1]);
                    printer[2] = Integer.parseInt(input[2]);
                    printer[3] = Integer.parseInt(input[3]);
                    printers.add(printer);
                }
                System.out.println("Case #" + i + ": " + result(printers));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            List<int[]> printers = new ArrayList<>();
            for (int p = 0; p < 3; p++) {
                String[] input = in.nextLine().split(" ");
                int[] printer = new int[4];
                printer[0] = Integer.parseInt(input[0]);
                printer[1] = Integer.parseInt(input[1]);
                printer[2] = Integer.parseInt(input[2]);
                printer[3] = Integer.parseInt(input[3]);
                printers.add(printer);
            }
            System.out.println("Case #" + i + ": " + result(printers));
        }
    }

    private static String result(List<int[]> printers) {
        StringBuilder buffer = new StringBuilder();

        int[] firstPrinter = printers.get(0);
        int maxC = firstPrinter[0];
        int maxM = firstPrinter[1];
        int maxY = firstPrinter[2];
        int maxK = firstPrinter[3];
        for(int i = 1; i < printers.size(); i++) {
            int[] printer = printers.get(i);
            if (printer[0] < maxC) {
                maxC = printer[0];
            }
            if (printer[1] < maxM) {
                maxM = printer[1];
            }
            if (printer[2] < maxY) {
                maxY = printer[2];
            }
            if (printer[3] < maxK) {
                maxK = printer[3];
            }
        }

        int loggo = 1000000;

        if (maxC + maxM + maxY + maxK >= loggo) {
            int curr = 0;
            if (maxC < loggo) {
                buffer.append(maxC + " ");
                curr += maxC;
            } else {
                return loggo + " 0 0 0";
            }

            if (curr + maxM < loggo) {
                buffer.append(maxM + " ");
                curr += maxM;
            } else {
                int rest = loggo - curr;
                buffer.append(rest + " 0 0");
                return buffer.toString();
            }

            if (curr + maxY < loggo) {
                buffer.append(maxY + " ");
                curr += maxY;
            } else {
                int rest = loggo - curr;
                buffer.append(rest + " 0");
                return buffer.toString();
            }

            int rest = loggo - curr;
            buffer.append(rest);
            return buffer.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }
}
