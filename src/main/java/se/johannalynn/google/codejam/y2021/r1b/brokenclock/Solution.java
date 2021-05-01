package se.johannalynn.google.codejam.y2021.r1b.brokenclock;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final boolean debug = true;

    public static void main(String[] args) {
        if (debug) {
            String data = "3\n" +
                    "0 0 0\n" +
                    "0 21600000000000 23400000000000\n" +
                    "1476000000000 2160000000000 3723000000000\n" +
                    "36000000000000 36000000000000 36000000000000\n";
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
            String[] clock = in.nextLine().split(" ");
            long A = Long.parseLong(clock[0]);
            long B = Long.parseLong(clock[1]);
            long C = Long.parseLong(clock[2]);
            System.out.println("Case #" + i + ": " + result(A, B, C));
        }
    }


    private static String testClock2(long h, long m, long s) {
        // long nanosecondsSinceMidnight = h;
        long hours = h / (60*60) / (1000*1000*1000);
        long minutesLeft = (h - (hours * 3600 * (1000*1000*1000)));
        if (minutesLeft == 0 && m == 0 || minutesLeft > 0) {
            
            System.out.println("calc");
            return "";
        } else {
            return null;
        }
    }

    /*

    if (s % 720 == 0) {
            long seconds = s / 720 / (1000*1000*1000);
            long ticks = seconds * 720;
            if (ticks == 0) {
                if (m % 12 == 0) {
                    long minutes = m / 12 / (1000*1000*1000);
                    long hours = h / (1000*1000*1000);
                    System.out.println("HOURS: " + (hours % (1000*1000*1000)));
                    return hours + " " + minutes + " " + seconds + " 0";
                }
            } else {
                long minuteAngle = ticks * 12;
                System.out.println("minutesAngle: " + minuteAngle);
                if ((m/12) % minuteAngle == 0) {
                    long realMinutes = m / 12 / (1000*1000*1000);
                    long hourAngle = ticks;
                    if (h % hourAngle == 0) {
                        long realHours = h / (1000*1000*1000);
                        return realHours + " " + realMinutes + " " + seconds + " 0";
                    }
                } else {
                    System.out.println("abc");
                }
            }
        }
        return null;
     */

    private static long hours(long angle, long seconds) {
        long ticks = seconds * 720;
        long current = angle * ticks;
        System.out.println("current: " + current);
        long mod = current % 3600;
        if (mod > 0) {
            System.out.println("hours");
            return -1;
        }
        return angle / (60*60) / (1000*1000*1000);
    }

    private static long minutes(long angle, long seconds) {
        long ticks = seconds * 720;
        long current = (angle / 12) * ticks;
        long mod = current % 60;
        System.out.println("current: " + current);

        if (mod > 0) {
            System.out.println("mod: " + mod);
            return -1;
        }
        return angle / 12 / 60 / (1000*1000*1000);
    }

    private static long seconds(long angle) {
        long mod = angle % 720;
        if (mod > 0) {
            return -1;
        }
        return angle / 720 / (1000*1000*1000);
    }

    private static String testClock(long h, long m, long s) {
        long seconds = seconds(s);
        if (seconds != -1) {
            System.out.println(seconds);
            long minutes = minutes(m, seconds);
            System.out.println(minutes);
            long hours = hours(h, seconds);

            return hours + " " + minutes + " " + seconds + " 0";
        }
        return null;
    }

    private static String resultTestCase1(long A, long B, long C) {

        // if A = h, B = m, C = s
        String clock = testClock(A, B, C);
        if (clock != null) {
            return clock;
        }
        // if A = h, C = m, B = s
        clock = testClock(A, C, B);
        if (clock != null) {
            return clock;
        }

        // if B = h, A = m, C = s
        clock = testClock(B, A, C);
        if (clock != null) {
            return clock;
        }

        // if B = h, C = m, A = s
        clock = testClock(B, C, A);
        if (clock != null) {
            return clock;
        }

        // if C = h, A = m, B = s
        // 1 2 3
        System.out.println("TEST");
        System.out.println(C / (60*60) / (1000*1000*1000));
        System.out.println(A / (12*60) / (1000*1000*1000));
        System.out.println(B / (720) / (1000*1000*1000));
        clock = testClock(C, A, B);
        System.out.println("CLOCK");
        if (clock != null) {
            return clock;
        }

        // if C = h, B = m, A = s
        clock = testClock(C, B, A);
        if (clock != null) {
            return clock;
        }

        return "Something went wrong";
    }

    private static String result(long A, long B, long C) {

        // if A = h, B = m, C = s
        String clock = testClock2(A, B, C);
        if (clock != null) {
            return clock;
        }
        // if A = h, C = m, B = s
        clock = testClock2(A, C, B);
        if (clock != null) {
            return clock;
        }

        // if B = h, A = m, C = s
        clock = testClock2(B, A, C);
        if (clock != null) {
            return clock;
        }

        // if B = h, C = m, A = s
        clock = testClock2(B, C, A);
        if (clock != null) {
            return clock;
        }

        // if C = h, A = m, B = s
        // 1 2 3
        System.out.println("TEST");
        // System.out.println(C / (60*60) / (1000*1000*1000));
        // System.out.println(A / (12*60) / (1000*1000*1000));
        // System.out.println(B / (720) / (1000*1000*1000));
        clock = testClock2(C, A, B);
        System.out.println("CLOCK");
        if (clock != null) {
            return clock;
        }

        // if C = h, B = m, A = s
        clock = testClock2(C, B, A);
        if (clock != null) {
            return clock;
        }

        return "Something went wrong";
    }
}

