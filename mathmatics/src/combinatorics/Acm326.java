/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm326 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            String line = buf.readLine();
            if (line.equals("0")) {
                break;
            }
            String[] in = line.split(" ");
            int n = Integer.parseInt(in[0]);
            int[] a = new int[n];
            int[][] start = new int[n][n];
            for (int i = 0; i < n; i++) {
                start[i][0] = Integer.parseInt(in[i + 1]);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    start[j][i] = start[j + 1][i - 1] - start[j][i - 1];
                }
            }
            for (int i = 0; i < n; i++) {
                a[i] = start[n - i - 1][i];
            }
            int k = Integer.parseInt(in[in.length - 1]);
            for (int i = 0; i < k; i++) {
                for (int j = a.length - 2; j >= 0; j--) {
                    a[j] += a[j + 1];
                }
            }
            System.out.println("Term " + (n + k) + " of the sequence is " + a[0]);

        }
    }
}
