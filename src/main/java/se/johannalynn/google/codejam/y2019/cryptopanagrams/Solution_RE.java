package se.johannalynn.google.codejam.y2019.cryptopanagrams;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution_RE {

    public static void testResult() {
        String data =
                "3\n" +
                        "103 31\n" +
                        "217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989 3053\n" +
                        "10000 25\n" +
                        "3292937 175597 18779 50429 375469 1651121 2102 3722 2376497 611683 489059 2328901 3150061 829981 421301 76409 38477 291931 730241 959821 1664197 3057407 4267589 4729181 5335543\n" +
                        "1000000000000000 31\n" +
                        "6999881 217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989\n" +
                        "10000 25\n" +
                        "3292937 175597 18779 50429 375469 1651121 2102 3722 2376497 611683 489059 2328901 3150061 829981 421301 76409 38477 291931 730241 959821 1664197 3057407 4267589 4729181 5335543\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            result();

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        //testResult();
        result();
    }

    private static void result() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String[] line = in.nextLine().split(" ");
            BigInteger N = new BigInteger(line[0]);
            int L = Integer.parseInt(line[1]);
            String message = in.nextLine();
            System.out.println("Case #" + i + ": " + calc2(N, L, message));
        }
    }

    private static String calc2(BigInteger N, int L, String message) {
        String[] products = message.split(" ");

        Map<BigInteger, Character> map = new HashMap<>();
        List<BigInteger> primeMessage = new ArrayList<>();

        BigInteger first = new BigInteger(products[0]);
        BigInteger second = new BigInteger(products[1]);
        boolean found = false;
        int c = 0;
        BigInteger divisor = BigInteger.ZERO;

        BigInteger prime = new BigInteger("2");
        while(!found) {
            if(first.mod(prime).compareTo(BigInteger.ZERO) == 0) {
                found = true;
                divisor = first.divide(prime);
                if(second.mod(prime).compareTo(BigInteger.ZERO) == 0) {
                    primeMessage.add(divisor);
                    primeMessage.add(prime);
                    divisor = prime;
                } else {
                    primeMessage.add(prime);
                    primeMessage.add(divisor);
                }
            }
            prime = prime.nextProbablePrime();
        }

        for(int i = 1; i < products.length; i++) {
            BigInteger next = new BigInteger(products[i]);
            BigInteger nextPrime = next.divide(divisor);
            divisor = nextPrime;
            primeMessage.add(nextPrime);
        }

        Set<BigInteger> usedPrimes = new HashSet<>(primeMessage);
        List<BigInteger> sortedList = new ArrayList<>(usedPrimes);
        Collections.sort(sortedList);

        char nextChar = 'A';
        for(BigInteger p : sortedList) {
            map.put(p, nextChar++);
        }

        StringBuilder builder = new StringBuilder();
        for(BigInteger m : primeMessage) {
            builder.append(map.get(m));
        }

        return builder.toString();
    }
}
