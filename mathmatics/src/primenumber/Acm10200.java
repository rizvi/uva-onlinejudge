/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10200 {

    public static void main(String[] args) throws IOException {
        int primes[] = new int[10 * 1000 + 1];
        int counter = 0;
        for (int i = 0; i < primes.length; i++) {
            if (isPrime((i * i) + i + 41)) {
                counter++;
            }
            primes[i] = counter;
        }

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = buff.readLine()) != null) {
            String[] str = input.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            float counterA = 0;
            if (a != 0 && primes[a] - primes[a - 1] != 1) {
                counterA = primes[b] - primes[a];
            } else {
                counterA = primes[b] - primes[a] + 1;
            }
            float temp = counterA * 100 / (b - a + 1);
            System.out.printf("%.2f", temp);
            System.out.println();
        }
    }

    static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
