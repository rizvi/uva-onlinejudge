/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acm10533 {

    static boolean[] sieve;
    static int[] ref = new int[1000001];

    private static void sieve(int n) {
        sieve = new boolean[n + 1];
        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    sieve[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(
                System.in));
        StringTokenizer st;

        int nCases = Integer.parseInt(buff.readLine());
        StringBuilder ans = new StringBuilder("");
        sieve(1000000);
        preCalculate();
        for (int i = 0; i < nCases; i++) {
            st = new StringTokenizer(buff.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            ans.append(ref[t2] - ref[t1 - 1] + "\n");
        }
        System.out.print(ans);
    }

    private static void preCalculate() {
        for (int i = 2; i <= 1000000; i++) {
            if (!sieve[i]) {
                int sum = 0, curr = i;
                while (curr != 0) {
                    sum += curr % 10;
                    curr /= 10;
                }
                if (!sieve[sum]) {
                    ref[i] = 1;
                }
            }
        }
        for (int i = 1; i <= 1000000; i++) {
            ref[i] += ref[i - 1];
        }
    }
}
