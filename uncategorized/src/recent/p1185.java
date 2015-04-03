/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p1185 {
    static int[] arr = new int[10000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        generate();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(arr[n]+1);      
        }
    }
    private static void generate() {
        double last=0;
        for (int j = 1; j <= 10000000; j++) {
            last+=Math.log10(j);
            arr[j] = (int) last;
        }
    }
}
