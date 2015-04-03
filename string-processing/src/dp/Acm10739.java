/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acm10739 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(buf.readLine());
        int tc = 0;
        while (t-- > 0) {
            tc++;
            char[] c = buf.readLine().toCharArray();
            int n = c.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            int min = go(dp, c, 0, n - 1);
            System.out.printf("Case %d: %d\n", tc, min);
        }
    }

    private static int go(int[][] dp, char[] c, int i, int j) {
        if (i >= j) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int min = Integer.MAX_VALUE;
            if (c[i] == c[j]) {
                min = go(dp, c, i + 1, j - 1);
            } else {
                min = Math.min(min, 1 + go(dp, c, i + 1, j));
                min = Math.min(min, 1 + go(dp, c, i, j - 1));
                min = Math.min(min, 1 + go(dp, c, i + 1, j - 1));
            }
            return dp[i][j] = min;
        }

    }
}
