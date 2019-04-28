package se.johannalynn.google.codejam.y2019.r1b.manhattancrepecart;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Solution {

    public static void testResult() {
        String data = "3\n" +
                "1 10\n" +
                "5 5 N\n" +
                "4 10\n" +
                "2 4 N\n" +
                "2 6 S\n" +
                "1 5 E\n" +
                "3 5 W\n" +
                "8 10\n" +
                "0 2 S\n" +
                "0 3 N\n" +
                "0 3 N\n" +
                "0 4 N\n" +
                "0 5 S\n" +
                "0 5 S\n" +
                "0 8 S\n" +
                "1 5 W\n";

        /*
                "Case #1: 0 6\n" +
                "Case #2: 2 5\n" +
                "Case #3: 0 4\n" +
         */
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            result();

        } finally {
            System.setIn(stdin);
        }
    }

    static class Person {
        public int x;
        public int y;
        public String d;

        public int maxY;
        public int minY;
        public int maxX;
        public int minX;

        public void setD(int Q1) {
            switch(d) {
                case "N":
                    maxY = Q1;
                    minY = y + 1;
                    maxX = Q1;
                    minX = 0;
                    break;
                case "S":
                    maxY = y - 1;
                    minY = 0;
                    maxX = Q1;
                    minX = 0;
                    break;
                case "E":
                    maxY = Q1;
                    minY = 0;
                    maxX = Q1;
                    minX = x + 1;
                    break;
                case "W":
                    maxY = Q1;
                    minY = 0;
                    maxX = x - 1;
                    minX = 0;
                    break;
            }
        }

        public List<String> getIntersections() {
            //System.out.println(x + ", " + y + " : " + d +":: " + minX + ", " + maxX + " - " + minY + ", " + maxY);
            List<String> intersections = new ArrayList<>();
            for(int i = minX; i <= maxX; i++) {
                for(int j = minY; j <= maxY; j++) {
                    intersections.add(i+" "+j);
                }
            }
            return intersections;
        }
    }

    public static void result() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String[] input1 = in.nextLine().split(" ");
            int P = Integer.valueOf(input1[0]);
            int Q = Integer.valueOf(input1[1]);

            List<Person> personList = new ArrayList<>();
            for(int j = 0; j < P; j++) {
                String[] input2 = in.nextLine().split(" ");
                Person p = new Person();
                p.x = Integer.valueOf(input2[0]);
                p.y = Integer.valueOf(input2[1]);
                p.d = input2[2];
                p.setD(Q);
                personList.add(p);
            }
            System.out.println("Case #" + i + ": " + result2(P, Q, personList));
        }
    }

    public static void main(String[] args) {
        //testResult();
        result();
    }

    private static String print(int P, int Q, List<Person> personList) {
        int[][] manhattan = new int[Q+1][Q+1];
        for(int i = 0; i <= Q; i++) {
            for(int j = 0; j <= Q; j++) {
                for(Person person: personList) {
                    if (j >= person.minX && j <= person.maxX) {
                        if (i >= person.minY && i <= person.maxY) {
                            //System.out.println(person.x + ", " + person.y + ": " + person.d + " - " + person.minX + ", " + person.maxX + " - " + person.minY + ", " + person.maxY);
                            manhattan[i][j]++;
                        }
                    }
                }
            }
        }

        for(int i = 0; i <= Q; i++) {
            for(int j = 0; j<= Q; j++) {
                System.out.print(manhattan[i][j] + " ");
            }
            System.out.println();
        }

        return "printed";
    }

    static class SortIntersection implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] one = o1.split(" ");
            String[] two = o2.split(" ");
            Integer oneX = Integer.valueOf(one[0]);
            Integer oneY = Integer.valueOf(one[1]);
            Integer twoX = Integer.valueOf(two[0]);
            Integer twoY = Integer.valueOf(two[1]);

            int compareX = oneX.compareTo(twoX);
            if(compareX != 0) {
                return compareX;
            } else {
                return oneY.compareTo(twoY);
            }
        }
    }

    private static String result2(int P, int Q, List<Person> personList) {
        List<String> intersections = new ArrayList<>();
        for(Person person : personList) {
            List<String> tmp = person.getIntersections();
            intersections.addAll(tmp);
        }

        Map<String, Long> counts =
                intersections.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        LinkedHashMap<Long, List<String>> sortedMap = new LinkedHashMap<>();
        counts.entrySet().stream().sorted(comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> {
                    List<String> candidates = sortedMap.get(entry.getValue());
                    if(candidates == null) candidates = new ArrayList<>();
                    candidates.add(entry.getKey());
                    sortedMap.put(entry.getValue(), candidates);
                });

        Map.Entry<Long, List<String>> highestVoted = sortedMap.entrySet().stream().findFirst().get();
        String winner = highestVoted.getValue().stream().sorted(new SortIntersection()).findFirst().get();
        return winner;
    }
}
