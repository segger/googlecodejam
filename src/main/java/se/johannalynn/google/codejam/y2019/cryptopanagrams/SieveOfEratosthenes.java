package se.johannalynn.google.codejam.y2019.cryptopanagrams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        List<Integer> primes = sieveOfEratosthenes(10000);
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
                System.out.print(i + ", ");
            }
        }
        return primeNumbers;
    }

    public static List<Integer> sieveOfEratosthenes3(int from, boolean[] froms, int n) {
        boolean prime[] = new boolean[n + 1];
        System.arraycopy(froms, 0, prime, from, froms.length);
        for (int a = from + froms.length; a < prime.length; a++) {
            prime[a] = true;
        }
        for (int p = from; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
