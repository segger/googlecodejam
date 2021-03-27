package se.johannalynn.google.codejam.y2021.qual.reversortengineering;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {

    /*
Case #1: 4 2 1 3
Case #2: 1 2
Case #3: 7 6 5 4 3 2 1
Case #4: IMPOSSIBLE
Case #5: IMPOSSIBLE
     */

    public static void main(String[] args) {
        String data = "6\n" +
                "4 6\n" +
                "2 1\n" +
                "7 12\n" +
                "7 2\n" +
                "2 1000\n" +
                "7 13\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                String[] input = in.nextLine().split(" ");
                int N = Integer.parseInt(input[0]);
                int C = Integer.parseInt(input[1]);
                System.out.println("Case #" + i + ": " + result(N, C));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main2(String[] args) {
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

        int pythagoreans = (N * (N + 1)) / 2;
        if (C > pythagoreans) {
            return "IMPOSSIBLE";
        }

        List<Integer> list = recurse(C, N, 1);

        int sort = calcSort(list.size() - 1, list);
        System.out.println("SORT: " + sort);
        buffer.append(output(list));
        return buffer.toString();
    }

    private static List<Integer> recurse(int C, int N, int S) {
        System.out.println("C: " + C + ", N: " + N + ", S: " + S);
        if (C < N) {
            // in order
            return IntStream.rangeClosed(S, N).boxed().collect(Collectors.toList());
        } else if (C - 2*(N-1) > 0) {
            // recurse first and last
            System.out.println("recurse S: " + S);
            List<Integer> middleList = recurse((C - N), (N - 1), (S + 1));
            middleList.add(0, N);
            middleList.add(S);
            return middleList;
        } else {
            // swap
            List<Integer> list = IntStream.rangeClosed(S, N).boxed().collect(Collectors.toList());
            Collections.swap(list, 0, (C - (N-1)));
            return list;
        }
    }

    private static String output(List<Integer> list) {
        StringBuffer buffer = new StringBuffer();
        list.forEach((nbr) -> {
            buffer.append(nbr + " ");
        });
        return buffer.toString();
    }

    private static int calcSort(int N, List<Integer> L) {
        int sum = 0;
        for(int i = 0; i < N - 1; i++) {
            Integer nbr = L.get(i);
            // System.out.println("i: " + i + ", nbr: " + nbr);
            List<Integer> firstPart = L.subList(0, i);

            List<Integer> rest = L.subList(i, N);
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

            L = newList;
        }
        return sum;
    }
}
