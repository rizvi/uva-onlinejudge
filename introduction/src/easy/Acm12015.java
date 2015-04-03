/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.util.Scanner;

public class Acm12015 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            String[] URls = new String[10];
            int[] valu = new int[10];
            for (int j = 0; j < valu.length; j++) {
                URls[j] = input.next();
                valu[j] = input.nextInt();
            }
            int max = 0;
            for (int j = 0; j < valu.length; j++) {
                if (valu[j] > max) {
                    max = valu[j];
                }
            }
            System.out.printf("Case #%d:\n", i);
            for (int j = 0; j < valu.length; j++) {
                if (valu[j] == max) {
                    System.out.println(URls[j]);
                }
            }
        }

    }
}
