package se.johannalynn.google.codejam.y2021.r1c.closestpick;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static final boolean debug = true;

    public static void main(String[] args) {
        if (debug) {
            String data = "7\n" +
                    "3 10\n" +
                    "1 3 7\n" +
                    "4 10\n" +
                    "4 1 7 3\n" +
                    "4 3\n" +
                    "1 2 3 2\n" +
                    "4 4\n" +
                    "1 2 4 2\n" +
                    "1 30\n" +
                    "1\n" +
                    "2 1000000000\n" +
                    "1 1000\n"+
                    "30 1000000000\n" +
                    "1 1000 10000 3 3 1000000000 70 90 10 1000 748 94839 76463 85 924 84 92 99999 857839 748393 84839 85738 488389 584 48483 3838 485838 833 48483 4848\n";
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
            String[] input = in.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            List<Long> P = Arrays.stream(in.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            System.out.println("Case #" + i + ": " + result(N, K, P));
        }
    }

    private static String result(int N, int K, List<Long> P) {
        StringBuffer buffer = new StringBuffer();
        // win for 1/K per number owned
        // if all numbers taken -> 0.0
        // biggest distance between already selected numbers

        // or if both of your tickets are the same distance to c and strictly closer than all other tickets
        Collections.sort(P);

        List<Long> distances = new ArrayList<>();
        List<Long> doubleDistance = new ArrayList<>();

        long before = P.get(0);
        for(int i = 1; i < N; i++) {
            long nbr = P.get(i);
            long distance = nbr - before;
            long p = distance / 2;
            distances.add(p);
            doubleDistance.add(distance-1);
            before = nbr;
        }

        long first = P.get(0) - 1;
        long last = K - before;
        distances.add(first);
        distances.add(last);

        Collections.sort(distances);
        Collections.sort(doubleDistance);

        long ticket1 = distances.get(N);
        long ticket2 = distances.get(N-1);
        double twoTickets = ticket1 + ticket2;

        long tickets = doubleDistance.isEmpty() ? 0 : doubleDistance.get(doubleDistance.size() - 1);

        double winningNbrs = Math.max(tickets, twoTickets);

        double p = winningNbrs / K;

        buffer.append(p);
        return buffer.toString();
    }
}
