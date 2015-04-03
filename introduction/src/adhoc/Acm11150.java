/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 11150
 * @problemName Cola
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 10/01/2012
 *
 */
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class Acm11150 {

    static int[] arr = new int[]{1, 3, 9, 27, 81, 243, 729};
    static int[][][] mem = new int[245][245][245];

    static int f(int ll, int v, int d) {
        if (d > ll + v) {
            return MIN_VALUE;
        }
        if ((ll + v) / 3 == ll && (ll + v) % 3 == v) {
            return ll;
        }
        if (mem[ll][v][d] != 0) {
            return mem[ll][v][d];
        }
        if (Arrays.binarySearch(arr, ll + v) >= 0) {
            return mem[ll][v][d] = f((ll + v) / 3, (ll + v) % 3, d) + ll;
        }
        return mem[ll][v][d] = max(f(ll, v + 1, d + 1), f((ll + v) / 3, (ll + v) % 3, d) + ll);
    }

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null;) {
            System.out.println(f(parseInt(ln.trim()), 0, 0));
        }
    }
}
