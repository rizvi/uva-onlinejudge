/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

/**
 * State
 *
 * Basically the state would be width, height of the current chocolate bar and a
 * bitmask that indicates which friends where served and which were not. Soon we
 * figure out that we don’t really need width and height as elements of state we
 * only need one of them and we can recover the other as
 * sum[unserved]/width,sum[unserved]/height where unserved are the zero bits in
 * bitmask. Transition
 *
 * We split the unserved into two subsets and check if both subsets are either
 * divisible by width or divisible by height ,this is actually the same of
 * splitting chocolate piece vertically or horizontally. Optimizations
 *
 * We may avoid iterating over the bitmask calculate sum[unserved]. We may avoid
 * iterating over the same subset twice,to handle this we may restrict that one
 * subset integer value is greater than the other see (i > next^i ) in the code.
 * We may avoid doing extra iterations if we already found that splitting the
 * current bar over unserved is possible.
 *
 * @author Masudul Haque
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class p1099 {
    static int[] sum;
    static int[] a;
    static int n;
    static byte[][] dp;
 
    public static byte go(int d, int m) {
        int next = ((1 << n) - 1) ^ m;
        int d2 = sum[next] / d;
        if ((next & (next - 1)) == 0)
            return dp[d][m] = 1;
        if (dp[d][m] != -1)
            return dp[d][m];
        byte res = 0;
        for (int i = (next - 1) & next; i > (next ^ i) && res == 0; i = (i - 1)
                & next) {
            if (sum[i] % d == 0 && sum[i ^ next] % d == 0)
                res |= go(d, m | i) & go(d, m | (i ^ next));
            if (res == 0 && sum[i] % d2 == 0 && sum[i ^ next] % d2 == 0)
                res |= go(sum[i] / d2, m | (i ^ next))
                        & go(sum[i ^ next] / d2, m | i);
        }
        return dp[d][m] = res;
    }
 
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        int cc = 1;
        while (true) {
            n = in.nextInt();
            if (n == 0)
                break;
            int x = in.nextInt();
            int y = in.nextInt();
            a = new int[n];
            int tsum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                tsum += a[i];
            }
            if (tsum != x * y) {
                System.out.println("Case " + (cc++) + ": " + "No");
                continue;
            }
            sum = new int[1 << n];
            sum[0] = 0;
            for (int i = 0; i < n; i++) {
                sum[1 << i] = a[i];
            }
            for (int i = 1; i < 1 << n; i++) {
                int last = i & -i;
                sum[i] = sum[last] + sum[i ^ last];
            }
            dp = new byte[Math.min(x, y) + 1][1 << n];
            for (int i = 0; i < dp.length; i++)
                Arrays.fill(dp[i], (byte) -1);
            if (go(Math.min(x, y), 0) == 1)
                System.out.println("Case " + (cc++) + ": " + "Yes");
            else
                System.out.println("Case " + (cc++) + ": " + "No");
        }
    }
 
    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}