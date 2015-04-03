/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm160 {

    public static void main(String[] args) {
        int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            int[] factors = new int[101];
            for (int i = 0; i < primes.length; i++) {
                factors[primes[i]] = count(N, primes[i]);
            }
            int i = 0;
            System.out.printf("%3d! =", N);
            for (i = 0; i < primes.length && factors[primes[i]] != 0; i++) {
                if (i == 15) {
                    System.out.print("\n      ");
                }
                System.out.printf("%3d", factors[primes[i]]);
            }
            System.out.println("");
        }

    }

    static int count(int N, int x) {
        int count = 0;
        for (int i = x; i <= N; i *= x) {
            count += N / i;
        }
        return count;
    }
}
