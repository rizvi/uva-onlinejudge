/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Beautiful Number.
 * @author Masudul Haque
 */
public class Acm11472 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            int m = sc.nextInt();
            if (m < n) {
                System.out.println(0);
            } else {
                long[][][] dp = new long[m][(1 << n) + 1][21];
                for (int i = 0; i < dp.length; i++) {
                    for (int j = 0; j < dp[0].length; j++) {
                        Arrays.fill(dp[i][j], -1);
                    }
                }

                long sum = 0;
                sum += find(1, 0, 0, dp, true) % 1000000007;
                for (int i = 1; i < n; i++) {
                    sum += find(1, 1 << i, i, dp, false) % 1000000007;
                }
                System.out.println(sum % 1000000007);
            }
        }
    }
    static int n;

    private static long find(int place, int bitmask, int prev, long[][][] dp,
            boolean leading) {
        if (prev == -1 || prev == n) {
            return 0;
        }

        if (place == dp.length && bitmask == (1 << n) - 1) {
            return 1;
        }
        if (place == dp.length) {
            return 0;
        }
        if (dp[place][bitmask][prev] != -1) {
            return dp[place][bitmask][prev];
        } else {
            long sum = 0;
            if (prev == 0 && leading) {
                sum += find(place + 1, bitmask, 0, dp, true) % 1000000007;
                for (int i = 1; i < n; i++) {
                    sum += find(place + 1, 1 << i, i, dp, false) % 1000000007;
                }
            } else {
                sum += find(place + 1, bitmask | (1 << (prev + 1)), prev + 1,
                        dp, false) % 1000000007;
                sum += find(place + 1, bitmask | (1 << (prev - 1)), prev - 1,
                        dp, false) % 1000000007;

            }
            return dp[place][bitmask][prev] = sum % 1000000007;
        }
    }
}
