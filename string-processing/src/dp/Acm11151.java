/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.*;

public class Acm11151 {

    static char[] arr;
    static int mem[][];

    static int function(int i, int j) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int max = Integer.MIN_VALUE;
        if (arr[i] == arr[j]) {
            max = function(i + 1, j - 1) + 2;
        }
        return mem[i][j] = Math.max(max, Math.max(function(i, j - 1), Math.max(function(i + 1, j), function(i + 1, j - 1))));
    }

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0, N = Integer.parseInt(in.readLine().trim()); i < N; i++) {
            arr = in.readLine().toCharArray();
            mem = new int[arr.length][arr.length];
            System.out.println(function(0, arr.length - 1));
        }
    }
}