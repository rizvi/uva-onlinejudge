/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author Masudul Haque
 */
public class Acm353 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            String line = buf.readLine();
            if (line == null) {
                break;
            }
            char[] c = line.toCharArray();
            int count = 0;
            int n = c.length;
            int[] alp = new int[26];
            for (int i = 0; i < c.length; i++) {
                alp[c[i] - 'a'] = 1;
            }
            for (int i = 0; i < 26; i++) {
                count += alp[i];
            }
            HashSet<String> hash = new HashSet<String>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!hash.contains(line.substring(i, j)) && isPal(c, i, j)) {
                        hash.add(line.substring(i, j));
                        count++;
                    }
                }
            }
            System.out.println("The string '" + line + "' contains " + count
                    + " palindromes.");
        }
    }

    private static boolean isPal(char[] c, int i, int j) {
        for (int k = i; k <= i + (j - i + 1) / 2; k++) {
            if (c[k] != c[j - k + i]) {
                return false;
            }
        }
        return true;
    }
}
