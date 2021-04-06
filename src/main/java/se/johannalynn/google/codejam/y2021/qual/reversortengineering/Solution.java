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
            /*
            String data = "9\n" +
                    "4 6\n" +
                    "2 1\n" +
                    "7 12\n" +
                    "7 2\n" +
                    "2 1000\n" +
                    "7 27\n"+
                    "7 28\n"+
                    "4 9\n"+
                    "5 7\n";*/
/*
            String data = "9\n" +
                    "3 3\n" +
                    "4 4\n" +
                    "7 4\n" +
                    "5 5\n" +
                    "5 12\n" +
                    "6 6\n"+
                    "6 11\n"+
                    "6 15\n"+
                    "6 18\n";*/

            String data = "61\n"+
                    "2 1\n"+
            "2 2\n"+
            "3 2\n"+
            "3 3\n"+
            "3 4\n"+
            "3 5\n"+
            "4 3\n"+
            "4 4\n"+
            "4 5\n"+
            "4 6\n"+
            "4 7\n"+
            "4 8\n"+
            "4 9\n"+
            "5 4\n"+
            "5 5\n"+
            "5 6\n"+
            "5 7\n"+
            "5 8\n"+
            "5 9\n"+
            "5 10\n"+
            "5 11\n"+
            "5 12\n"+
            "5 13\n"+
            "5 14\n"+
            "6 5\n"+
            "6 6\n"+
            "6 7\n"+
            "6 8\n"+
            "6 9\n"+
            "6 10\n"+
            "6 11\n"+
            "6 12\n"+
            "6 13\n"+
            "6 14\n"+
            "6 15\n"+
            "6 16\n"+
            "6 17\n"+
            "6 18\n"+
            "6 19\n"+
            "6 20\n"+
            "7 6\n"+
            "7 7\n"+
            "7 8\n"+
            "7 9\n"+
            "7 10\n"+
            "7 11\n"+
            "7 12\n"+
            "7 13\n"+
            "7 14\n"+
            "7 15\n"+
            "7 16\n"+
            "7 17\n"+
            "7 18\n"+
            "7 19\n"+
            "7 20\n"+
            "7 21\n"+
            "7 22\n"+
            "7 23\n"+
            "7 24\n"+
            "7 25\n"+
            "7 26\n"+
            "7 27\n";
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

        int cost = sum(list.size(), list);
        if (cost != C) {
            System.out.println("C: " + C + ", N: " + N);
            System.out.println("cost: " + cost + " => " + (cost == C));
        }

        buffer.append(output(list));
        return buffer.toString();
    }

    private static List<Integer> generate(int C, int N) {
        // System.out.println("C: " + C + ", N: " + N);
        /*
        if (C == N) {
            List<Integer> list = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
            Collections.reverse(list);
            return list;
        } else */ if (C < N) {
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

            // System.out.println("x: " + x + ", reverseIdx: " + reverseIdx);
            List<Integer> reverseList = list.subList(0, reverseIdx);
            List<Integer> rest = list.subList(reverseIdx, list.size());

            Collections.reverse(reverseList);

            List<Integer> retList = new ArrayList<>();
            retList.addAll(reverseList);
            retList.addAll(rest);

            /*
            System.out.println();
            retList.forEach(System.out::print);
            System.out.println();*/
            return retList;
        }
    }

    private static int sum(int N, List<Integer> L) {

        List<Integer> copy = new ArrayList<>();
        copy.addAll(L);

        int sum = 0;
        for(int i = 0; i < N - 1; i++) {
            Integer nbr = copy.get(i);
            // System.out.println("i: " + i + ", nbr: " + nbr);
            List<Integer> firstPart = copy.subList(0, i);

            List<Integer> rest = copy.subList(i, N);
            int minValue = rest.stream().mapToInt(v -> v).min().orElse(nbr);
            int indexOfMin = rest.indexOf(minValue);
            int j = i + indexOfMin;

            int count = (j - i) + 1;
            // System.out.println("count " + count);
            sum += count;

            List<Integer> reversed = rest.subList(0, indexOfMin + 1);
            Collections.reverse(reversed);
            List<Integer> restOfRest = rest.subList(indexOfMin + 1, rest.size());

            List<Integer> newList = new ArrayList<>();
            newList.addAll(firstPart);
            newList.addAll(reversed);
            newList.addAll(restOfRest);

            copy = newList;

            /*
            System.out.println();
            System.out.println("L: ");
            L.forEach(System.out::print);
            System.out.println();*/
        }

        return sum;
    }

    private static String output(List<Integer> list) {
        StringBuffer buffer = new StringBuffer();
        list.forEach((nbr) -> {
            buffer.append(nbr + " ");
        });
        return buffer.toString();
    }
}
