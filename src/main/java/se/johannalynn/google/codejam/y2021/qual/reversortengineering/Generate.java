package se.johannalynn.google.codejam.y2021.qual.reversortengineering;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generate {

    private static Map<Integer, String> tmp = new HashMap<>();

    public static void main(String[] args) {
        int N = 7;
        int[] start = IntStream.rangeClosed(1, N).toArray();
        printAllRecursive(start.length, start);

        tmp.keySet().forEach((key) -> System.out.println("put(\"" + N + ":" + key + "\", \"" + tmp.get(key) + "\");"));
    }

    public static void printAllRecursive(
            int n, int[] elements) {

        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static void printArray(int[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        List<Integer> L = Arrays.stream(input).boxed().collect(Collectors.toList());
        int sum = calcSum(L.size(), L);
        System.out.println("SUM: " + sum);

        StringBuffer buffer = new StringBuffer();
        for (Integer nbr : input) {
            buffer.append(nbr + " ");
        }
        String list = buffer.toString();

        tmp.put(sum, list);
    }

    public static int calcSum(int N, List<Integer> L) {
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
        return sum;
    }
}
