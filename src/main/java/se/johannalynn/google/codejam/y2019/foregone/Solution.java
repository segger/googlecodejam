package se.johannalynn.google.codejam.y2019.foregone;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String input = in.nextLine();
            System.out.println("Case #" + i + ": " + result(input));
        }
    }

    private static String result(String number) {
        StringBuffer one = new StringBuffer();
        StringBuffer two = new StringBuffer();

        number.chars().forEach(c -> {
            if(c == '4') {
                one.append('3');
                two.append('1');
            } else {
                one.append((char)c);
                two.append('0');
            }
        });
        String returnValue = one.toString() + " " + two.toString().replaceFirst("^0+(?!$)", "");
        return returnValue;
    }
}

