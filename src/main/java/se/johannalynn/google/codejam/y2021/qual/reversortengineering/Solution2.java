package se.johannalynn.google.codejam.y2021.qual.reversortengineering;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

    /*
Case #1: 4 2 1 3
Case #2: 1 2
Case #3: 7 6 5 4 3 2 1
Case #4: IMPOSSIBLE
Case #5: IMPOSSIBLE
     */

    private static Map<String, String> myMap = new HashMap<String, String>() {{
        put("2:1", "1 2 ");
        put("2:2", "2 1 ");
        put("3:2", "1 2 3 ");
        put("3:3", "1 3 2 ");
        put("3:4", "3 2 1 ");
        put("3:5", "2 3 1 ");
        put("4:3", "1 2 3 4 ");
        put("4:4", "1 2 4 3 ");
        put("4:5", "1 4 3 2 ");
        put("4:6", "4 3 2 1 ");
        put("4:7", "4 2 3 1 ");
        put("4:8", "2 3 4 1 ");
        put("4:9", "2 4 3 1 ");
        put("5:4", "1 2 3 4 5 ");
        put("5:5", "1 2 3 5 4 ");
        put("5:6", "1 2 5 3 4 ");
        put("5:7", "1 5 2 3 4 ");
        put("5:8", "5 4 3 2 1 ");
        put("5:9", "4 5 3 2 1 ");
        put("5:10", "5 2 3 4 1 ");
        put("5:11", "2 3 4 5 1 ");
        put("5:12", "3 5 2 4 1 ");
        put("5:13", "2 5 3 4 1 ");
        put("5:14", "2 4 5 3 1 ");
        put("6:5", "1 2 3 4 5 6 ");
        put("6:6", "1 2 3 4 6 5 ");
        put("6:7", "1 2 3 6 5 4 ");
        put("6:8", "2 1 3 6 5 4 ");
        put("6:9", "1 2 5 6 3 4 ");
        put("6:10", "6 5 4 3 2 1 ");
        put("6:11", "6 5 4 2 3 1 ");
        put("6:12", "6 4 5 2 3 1 ");
        put("6:13", "4 5 6 2 3 1 ");
        put("6:14", "4 5 2 3 6 1 ");
        put("6:15", "5 2 4 3 6 1 ");
        put("6:16", "2 5 4 3 6 1 ");
        put("6:17", "2 4 5 3 6 1 ");
        put("6:18", "3 2 5 4 6 1 ");
        put("6:19", "2 5 4 6 3 1 ");
        put("6:20", "2 4 6 5 3 1 ");
        put("7:6", "1 2 3 4 5 6 7 ");
        put("7:7", "1 2 3 4 5 7 6 ");
        put("7:8", "1 2 3 4 7 5 6 ");
        put("7:9", "2 1 3 4 7 5 6 ");
        put("7:10", "3 2 1 4 7 5 6 ");
        put("7:11", "1 7 4 3 2 5 6 ");
        put("7:12", "7 6 5 4 3 2 1 ");
        put("7:13", "7 6 5 4 2 3 1 ");
        put("7:14", "7 6 5 2 3 4 1 ");
        put("7:15", "7 5 6 2 3 4 1 ");
        put("7:16", "7 2 3 4 5 6 1 ");
        put("7:17", "7 2 4 3 5 6 1 ");
        put("7:18", "7 4 3 2 5 6 1 ");
        put("7:19", "2 3 4 7 5 6 1 ");
        put("7:20", "7 3 2 4 5 6 1 ");
        put("7:21", "2 7 3 4 5 6 1 ");
        put("7:22", "3 7 2 4 5 6 1 ");
        put("7:23", "4 3 2 7 5 6 1 ");
        put("7:24", "3 7 2 5 4 6 1 ");
        put("7:25", "3 2 4 7 5 6 1 ");
        put("7:26", "2 6 7 5 3 4 1 ");
        put("7:27", "2 4 6 7 5 3 1 ");
    }};

    public static void main(String[] args) {
        String data = "5\n" +
                "4 6\n" +
                "2 1\n" +
                "7 12\n" +
                "7 2\n" +
                "2 1000\n";
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

        String list = myMap.get(N + ":" + C);
        if (list == null) {
            buffer.append("IMPOSSIBLE");
        } else {
            buffer.append(list);
        }
        return buffer.toString();
    }

    private static String output(List<Integer> list) {
        StringBuffer buffer = new StringBuffer();
        list.forEach((nbr) -> {
            buffer.append(nbr + " ");
        });
        return buffer.toString();
    }
}
