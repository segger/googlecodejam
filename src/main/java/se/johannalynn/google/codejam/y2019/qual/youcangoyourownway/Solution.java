package se.johannalynn.google.codejam.y2019.qual.youcangoyourownway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    /*
    public static void main(String[] args) {
        String data = "2\n" +
                "2\n" +
                "SE\n" +
                "5\n" +
                "EESSSESE\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.valueOf(in.nextLine());
            for (int i = 1; i <= T; ++i) {
                int dimensions = Integer.valueOf(in.nextLine());
                String lydia = in.nextLine();
                System.out.println("Case #" + i + ": " + result(dimensions, lydia));
            }

        } finally {
            System.setIn(stdin);
        }
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int dimensions = Integer.valueOf(in.nextLine());
            String lydia = in.nextLine();
            System.out.println("Case #" + i + ": " + result(dimensions, lydia));
        }
    }

    private static String result(int dimensions, String lydia) {
        StringBuffer buffer = new StringBuffer();
        lydia.chars().forEach(c -> {
            if(c == 'E') {
                buffer.append('S');
            } else if (c == 'S') {
                buffer.append('E');
            } else {
                System.out.println("Something went wrong");
            }
        });
        return buffer.toString();
    }
}
