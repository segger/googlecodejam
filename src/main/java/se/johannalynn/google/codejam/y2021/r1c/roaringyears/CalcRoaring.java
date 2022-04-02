package se.johannalynn.google.codejam.y2021.r1c.roaringyears;

import java.util.HashSet;
import java.util.Set;

public class CalcRoaring {

    public static void main(String[] args) {
        int value = 10000000;
        Set<String> isRoaring = new HashSet<>();
        for(int i = 1; i < value; i++) {
            String year = String.valueOf(i);
            boolean roaring = isRoaring(year);
            if (roaring) {
                isRoaring.add(year);
            }
        }
        isRoaring.forEach(year -> {
            System.out.print(year + "L, ");
        });
    }

    private static boolean isRoaring(String year) {
        int firstNbrSplits = year.length() / 2;
        int idx = 0;
        String regex1 = "(?<=\\G";
        String regex2 = ")";
        String regex = regex1 + "." + regex2;
        while (idx < firstNbrSplits) {
            String[] splitted = year.split(regex);

            long currentNbr = Long.parseLong(splitted[0]);
            int nbrIdx = 1;
            boolean sorted = true;
            while(nbrIdx < splitted.length && sorted) {
                long nextNbr = Long.parseLong(splitted[nbrIdx]);
                if (currentNbr + 1 != nextNbr) {
                    sorted = false;
                }
                currentNbr = nextNbr;
                nbrIdx++;
            }

            if (sorted) {
                return true;
            }

            idx++;
            StringBuilder dots = new StringBuilder(".");
            for(int i = 0; i < idx; i++) {
                dots.append(".");
            }
            regex = regex1 + dots + regex2;
        }
        return false;
    }
}
