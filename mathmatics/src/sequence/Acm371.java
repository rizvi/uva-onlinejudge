/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm371 {
    static long mem[] = new long[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
            if (A == 0 && B == 0) {
                break;
            }
            long max = 0, val = A;
            for (long i = Math.min(A, B); i <= Math.max(A, B); i++) {
                if (function(i) > max) {
                    val = i;
                }
                max = Math.max(function(i), max);
            }
            if (Math.min(A, B) <= 1) {
                if (max <= 3) {
                    val = 1;
                }
                max = Math.max(3, max);
            }

            System.out.println("Between " + Math.min(A,B) + " and " + Math.max(A,B) + ", " + val + " generates the longest sequence of " + max + " values.");
        }
    }

    static long function(long n) {
        if (n == 1) {
            return 0;
        }
        if (n < mem.length && mem[(int) n] > 0) {
            return mem[(int) n];
        }
        if (n % 2 == 0) {
            return n < mem.length ? (mem[(int) n] = function(n / 2) + 1) : (function(n / 2) + 1);
        }
        return n < mem.length ? (mem[(int) n] = function(3 * n + 1) + 1) : (function(3 * n + 1) + 1);
    }
}
