/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acm686 {

    static int[] purePrimes;
    static int Top;

    static void sieve(int x) {
        int[] numbers = new int[x];
        boolean[] primes = new boolean[x];
        Arrays.fill(primes, true);
        purePrimes = new int[x];
        Top = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        primes[0] = false;
        primes[1] = false;

        int m = (int) Math.sqrt(numbers.length);
        for (int i = 2; i <= m; i++) {
            if (primes[i]) {
                purePrimes[Top++] = numbers[i];
                for (int j = i * i; j < numbers.length; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = (int) Math.sqrt(numbers.length); i < numbers.length; i++) {
            if (primes[i]) {
                purePrimes[Top++] = numbers[i];
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        sieve(35000);
        while (true) {
            int n = Integer.parseInt(r.readLine());
            if (n == 0) {
                return;
            }
            int count = 0;

            for (int i = 0; i < Top - 1; i++) {
                for (int k = i; k < Top; k++) {
                    if (purePrimes[k] + purePrimes[i] == n) {
                        count++;
                    } else if (purePrimes[k] + purePrimes[i] > n) {
                        break;
                    }
                }
            }
            System.out.println(count);

        }

    }
}