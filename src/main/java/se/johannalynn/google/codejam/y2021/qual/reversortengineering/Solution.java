package se.johannalynn.google.codejam.y2021.qual.reversortengineering;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static boolean debug = true;

    public static void main(String[] args) {
        if (debug) {
            String data = "9\n" +
                    "4 6\n" +
                    "2 1\n" +
                    "7 12\n" +
                    "7 2\n" +
                    "2 1000\n" +
                    "7 27\n"+
                    "7 28\n"+
                    "4 9\n"+
                    "5 7\n";

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
            int C = Integer.parseInt(input[1]);
            System.out.println("Case #" + i + ": " + result(N, C));
        }
    }

    private static String result(int N, int C) {
        StringBuilder buffer = new StringBuilder();

        if (N - 1 > C) {
            return "IMPOSSIBLE";
        }

        int max = (N*(N+1))/2 - 1;
        if (C > max) {
            return "IMPOSSIBLE";
        }

        List<Integer> list = generate(C, N);

        buffer.append(output(list));
        return buffer.toString();
    }

    private static List<Integer> generate(int C, int N) {
        // System.out.println("C: " + C + ", N: " + N);
        if (C < N) {
            if (C == (N-1)) {
                return IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
            } else {
                throw new RuntimeException();
            }
        } else {
            int x = N; // between 1 and N
            int cost = C - x;

            while (cost < (N - 2)) {
                x--;
                cost = C - x;
            }

            List<Integer> list = generate(cost, N - 1);

            int reverseIdx = x;
            for(int i = 0; i < list.size(); i++) {
                Integer nbr = list.get(i);
                list.set(i, ++nbr);
            }
            list.add(0, 1);
            List<Integer> reverseList = list.subList(0, reverseIdx);
            List<Integer> rest = list.subList(reverseIdx, list.size());

            Collections.reverse(reverseList);

            List<Integer> retList = new ArrayList<>();
            retList.addAll(reverseList);
            retList.addAll(rest);

            return retList;
        }
    }

    private static String output(List<Integer> list) {
        StringBuffer buffer = new StringBuffer();
        list.forEach((nbr) -> {
            buffer.append(nbr + " ");
        });
        return buffer.toString();
    }
}
