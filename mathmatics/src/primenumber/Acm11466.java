/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11466 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            long num = sc.nextLong();
            if (num == 0) {
                break;
            }
            if(num<0){
                num= -num;
            }
            long lpd = largestDivisor(num);
            System.out.println(lpd);

        }
    }

    private static long largestDivisor(long num) {
        long n = num;
        long max = 0;
        int counter = 0;
        for (long i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                if (i > max) {
                    max = i;
                }
                counter++;
                n /= i;
            }
        }
        if (n > 1 && n > max) {
            max = n;
            counter++;
        }
        if (counter <= 1) {
            max = -1;
        }

        return max;
    }
}
