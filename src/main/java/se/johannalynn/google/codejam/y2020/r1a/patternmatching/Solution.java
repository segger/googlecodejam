package se.johannalynn.google.codejam.y2020.r1a.patternmatching;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        String data = "7\n" +
                "5\n" +
                "*CONUTS\n" +
                "*COCONUTS\n" +
                "*OCONUTS\n" +
                "*CONUTS\n" +
                "*S\n" +
                "4\n" +
                "H*O\n" +
                "HELLO*\n"+
                "*HELLO\n"+
                "HE*\n"+
                "2\n" +
                "*XYZ\n" +
                "*XZ\n"+
                "2\n" +
                "*ABC\n" +
                "*K\n"+
                "2\n" +
                "CO*DE\n" +
                "J*AM\n"+
                "2\n" +
                "COJ*DE\n" +
                "J*AM\n"+
                "2\n" +
                "CODE*\n" +
                "*JAM\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.valueOf(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                int N = Integer.valueOf(in.nextLine());
                List<String> patterns = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    String pattern = in.nextLine();
                    patterns.add(pattern);
                }
                System.out.println("Case #" + i + ": " + result(N, patterns));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int N = Integer.valueOf(in.nextLine());
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String pattern = in.nextLine();
                patterns.add(pattern);
            }
            System.out.println("Case #" + i + ": " + result(N, patterns));
        }
    }

    private static String result1(int N, List<String> patterns) {
        // part 1 - sort length, contains
        // part 1 fix - have to match from the right
        patterns.sort(Comparator.comparingInt(String::length));

        //String regex = patterns.get(N - 1).replace("*",".*");
        String longest = patterns.get(N - 1).substring(1);
        //System.out.println(longest);
        for(int i = N - 2; i >= 0; i--) {
            String pattern = patterns.get(i).replace("*",".*");
            //System.out.println(pattern);
            if (!Pattern.matches(pattern, longest)) {
                return "*";
            }
        }
        return longest;
    }

    private static String result(int N, List<String> patterns) {
        // part 2
        /*
        List<String> pList = new ArrayList<>();
        for (String pattern : patterns) {
            String[] pLetters = pattern.split("\\*");
            for(String p : pLetters) {
                if(!p.isEmpty()) {
                    pList.add(p);
                }
            }
        }
        pList.sort(Comparator.comparingInt(String::length));
        String longest = pList.get(pList.size() - 1);
        System.out.println(longest);

        for(String p : patterns) {
            String pattern = p.replace("*",".*");
            pattern = "^" + pattern + "$";
            System.out.println(pattern);
            if (!Pattern.matches(pattern, longest)) {
                return "*";
            }
        }

        return longest;*/

        for (String org : patterns) {
            String[] splitted = org.split("\\*");
            List<String> parts = new ArrayList<>();
            for(String split : splitted) {
                if(!split.isEmpty()) {
                    parts.add(split);
                }
            }
            for (String pat : patterns) {
                String regex = pat.replace("*",".*");
                System.out.println(regex);
                for(String part : parts) {
                    System.out.println(part);
                    if (!Pattern.matches(regex, part)) {
                        return "*";
                    }
                }
            }
        }
        return "";
    }
}
