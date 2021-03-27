package se.johannalynn.google.codejam.y2021.qual.reversort;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    /*
    Case #1: 6
Case #2: 1
Case #3: 12
     */

    public static void main(String[] args) {
        String data = "3\n" +
                "4\n" +
                "4 2 1 3\n" +
                "2\n" +
                "1 2\n" +
                "7\n" +
                "7 6 5 4 3 2 1\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                int N = Integer.parseInt(in.nextLine());
                String[] input = in.nextLine().split(" ");
                List<Integer> L = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
                System.out.println("Case #" + i + ": " + result(N, L));
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
            List<Integer> L = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println("Case #" + i + ": " + result(N, L));
        }
    }

    private static String result(int N, List<Integer> L) {
        StringBuilder buffer = new StringBuilder();

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

            /*
            System.out.println();
            System.out.println("L: ");
            L.forEach(System.out::print);
            System.out.println();*/
        }

        buffer.append(sum);
        return buffer.toString();
    }
}
