package se.johannalynn.google.codejamio.y2021.impartialofferings;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private static final boolean debug = true;

    /*
    Case #1: 7
Case #2: 5
Case #3: 3
     */

    public static void main(String[] args) {
        if (debug) {
            String data = "3\n" +
                    "4\n" +
                    "10 20 10 25\n" +
                    "5\n" +
                    "7 7 7 7 7\n" +
                    "2\n" +
                    "100 1\n";
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
            int N = Integer.parseInt(in.nextLine());
            String[] S = in.nextLine().split(" ");
            System.out.println("Case #" + i + ": " + result(N, S));
        }
    }

    private static String result(int N, String[] S) {
        StringBuffer buffer = new StringBuffer();

        List<Integer> intList = Arrays.stream(S).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.sort(intList);
        int nbrOfTreats = 1;
        int totTreats = 1;
        int smallAnimal = intList.get(0);

        for(int i = 1; i < N; i++) {
            int animal = intList.get(i);
            if (animal > smallAnimal) {
                nbrOfTreats++;
            }
            totTreats += nbrOfTreats;
            smallAnimal = animal;
        }
        buffer.append(totTreats);
        return buffer.toString();
    }
}
