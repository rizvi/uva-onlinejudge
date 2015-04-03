/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acm11258 {

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        StringBuilder ans = new StringBuilder("");
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(buf.readLine());
        for (int i = 0; i < t; i++) {
            String line = buf.readLine();
            if (line.length() <= 10
                    && Long.parseLong(line) <= Integer.MAX_VALUE) {
                ans.append(Long.parseLong(line) + "\n");
            } else {

                char[] a = line.toCharArray();
                long[] dp = new long[a.length];
                Arrays.fill(dp, -1);
                long sum = find(0, a, dp);
                ans.append(sum + "\n");
            }
        }
        System.out.print(ans);
    }

    private static long find(int i, char[] a, long[] dp) {
        if (i == dp.length) {
            return 0;
        } else if (dp[i] != -1) {
            return dp[i];
        } else {
            long max = 0;
            for (int j = i; j - i <= 9 && j < a.length; j++) {
                if (j - i == 9) {
                    long x = Long.parseLong(get(i, j, a));
                    if (x <= Integer.MAX_VALUE) {
                        max = Math.max(max, x + find(j + 1, a, dp));
                    }
                } else {
                    long x = Long.parseLong(get(i, j, a));
                    max = Math.max(max, x + find(j + 1, a, dp));
                }
            }
            return dp[i] = max;
        }

    }

    private static String get(int i, int j, char[] a) {
        StringBuilder s = new StringBuilder("");
        for (int k = i; k <= j; k++) {
            s.append(a[k] + "");
        }
        return s.toString();
    }
}
