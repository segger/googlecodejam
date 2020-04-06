package se.johannalynn.google.codejam.y2020.qual.esabetad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GuessB {
//public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = in.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        //System.out.println("T: " + T);
        //System.out.println("B: " + B);

        for (int i = 1; i <= T; ++i) {

            int g = 0;
            while(g < 5) {
                int guess1 = 1;
                int guess2 = B;

                System.out.println(guess1);
                System.out.flush();

                String answer1 = in.nextLine();

                System.out.println(guess2);
                System.out.flush();

                String answer2 = in.nextLine();
                g++;
            }

            StringBuffer buffer = new StringBuffer();
            System.out.println(buffer.toString());
            System.out.flush();

            String result = in.nextLine();
            if ("N".equalsIgnoreCase(result)) {
                System.exit(0);
            }
        }
        System.exit(0);
    }
}
