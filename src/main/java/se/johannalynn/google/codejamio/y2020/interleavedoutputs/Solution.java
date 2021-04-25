package se.johannalynn.google.codejamio.y2020.interleavedoutputs;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    private static final boolean debug = true;

    public static void main(String[] args) {
        if (debug) {
            String data = "5\n" +
                    "IiOioIoO\n" +
                    "IiOOIo\n" +
                    "IoiOiO\n" +
                    "io\n" +
                    "IIIIOOOO\n";
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
            String S = in.nextLine();
            System.out.println("Case #" + i + ": " + result(S));
        }
    }

    private static String result(String S) {
        StringBuffer buffer = new StringBuffer();
        AtomicInteger Is = new AtomicInteger();
        AtomicInteger IOs = new AtomicInteger();
        S.chars().forEach(c -> {
            if(c == 'I') {
                Is.getAndIncrement();
            } else if (c == 'O') {
                if (Is.get() > 0) {
                    IOs.getAndIncrement();
                    Is.getAndDecrement();
                }
            }
        });
        buffer.append(IOs.get());
        return buffer.toString();
    }
}
