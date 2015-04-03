/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametheory;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 847
 * @problemName A Multiplication Game
 * @judge http://uva.onlinejudge.org/
 * @category memoization
 * @level easy
 * @date 22/12/2011
 *
 */
import java.io.*;
import java.util.*;
import static java.lang.Long.*;

public class Acm847 {

    static long N;
    static TreeMap<Long, Integer> mem;

    static int f(long l, int j) {
        if (l >= N) {
            return -j;
        }
        if (mem.containsKey(l * j)) {
            return mem.get(l * j);
        }
        for (int i = 2; i < 10; i++) {
            if (j == f(l * i, -j)) {
                mem.put(l * j, j);
                return j;
            }
        }
        mem.put(l * j, -j);
        return -j;
    }

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null;) {
            mem = new TreeMap<Long, Integer>();
            N = parseLong(ln.trim());
            System.out.println((f(1, 1) == 1 ? "Stan" : "Ollie") + " wins.");
        }
    }
}
