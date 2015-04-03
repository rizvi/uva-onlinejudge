/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.util.Scanner;

/**
 * Solved
 * @author Masudul Haque
 */
public class p12459 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] ans = new long[128];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < 81; ++i) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        while (true) {
            int in = sc.nextInt();
            if (in == 0) {
                break;
            }
            System.out.println(ans[in]);
        }
    }
}
