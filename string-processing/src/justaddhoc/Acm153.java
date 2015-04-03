/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acm153 {

    public static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public static int perm(int[] m) {
        int i, j, k;
        int n;
        int value;
        int prime;
        int[] num = new int[10]; // åˆ†å­å› å¼åˆ†è§£æŒ‡æ•¸
        int[] den = new int[10]; // åˆ†æ¯å› å¼åˆ†è§£æŒ‡æ•¸

        // æ±‚ n
        n = 0;
        for (i = 0; i < 26; i++) {
            n += m[i];
        }

        // åˆ†è§£åˆ†å­
        for (i = 2; i <= n; i++) {
            j = 0;
            prime = primes[j];
            value = i;
            while (value > 1) {
                if (value % prime == 0) {
                    value /= prime;
                    num[j]++;
                } else {
                    j++;
                    prime = primes[j];
                }
            }
        }

        // åˆ†è§£åˆ†æ¯
        for (i = 0; i < m.length; i++) {
            for (j = 2; j <= m[i]; j++) {
                k = 0;
                prime = primes[k];
                value = j;
                while (value > 1) {
                    if (value % prime == 0) {
                        value /= prime;
                        den[k]++;
                    } else {
                        k++;
                        prime = primes[k];
                    }
                }
            }
        }

        // è¨ˆç®—ç´„åˆ†çµæžœ
        int p = 1;
        for (i = 0; i < 10; i++) {
            prime = primes[i];
            p *= Math.pow(prime, num[i] - den[i]);
        }

        return p;
    }

    // è¨ˆç®—å­—ä¸²é †åºå€¼
    public static int rank(String s) {
        int i;
        int r = 1;
        int[] lcs = new int[26];

        // è¨ˆç®—å­—æ¯å€‹æ•¸
        for (i = 0; i < s.length(); i++) {
            lcs[s.charAt(i) - 'a']++;
        }

        // æŽ’åˆ—å…¬å¼æ±‚ä½ç½®
        for (int selected = 0; selected < s.length(); selected++) {
            char ch_lead = s.charAt(selected);
            char ch_used;

            for (ch_used = 'a'; ch_used < ch_lead; ch_used++) {
                if (lcs[ch_used - 'a'] > 0) {
                    lcs[ch_used - 'a']--;
                    r += perm(lcs);
                    lcs[ch_used - 'a']++;
                }
            }

            lcs[ch_lead - 'a']--;
        }

        return r;
    }

    public static void main(String[] args) throws IOException {
        char[] rank;
        char[] row = new char[10];
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = buff.readLine()).equals("#")) {
            rank = Long.toString(rank(line)).toCharArray();
            Arrays.fill(row, ' ');
            System.arraycopy(rank, 0, row, 10 - rank.length, rank.length);
            System.out.println(row);
        }
    }
}