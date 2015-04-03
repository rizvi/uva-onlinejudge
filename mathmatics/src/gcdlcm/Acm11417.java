/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11417 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            int G = 0;

            for (int i = 1; i < num; i++) {
                for (int j = i + 1; j <= num; j++) {
                    G += gcd(i, j);
                }
            }
            System.out.println(G);
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
