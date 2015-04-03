/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 *
 * @author Masudul Haque
 */
public class Acm10591 {

    static boolean f(long N) {
        TreeSet<Long> set = new TreeSet<Long>();
        for (; N != 1;) {
            if (set.contains(N)) {
                break;
            }
            set.add(N);
            char[] s = (N + "").toCharArray();
            N = 0;
            for (int i = 0; i < s.length; i++) {
                N += (s[i] - '0') * (s[i] - '0');
            }
        }
        return N == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (long t = 0, N, T = Integer.parseInt(in.readLine().trim()); t++ < T;) {
            if (f(N = Integer.parseInt(in.readLine().trim()))) {
                System.out.println("Case #" + t + ": " + N + " is a Happy number.");
            } else {
                System.out.println("Case #" + t + ": " + N + " is an Unhappy number.");
            }
        }
    }
}
