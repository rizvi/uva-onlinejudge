/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 11678
 * @problemName Cards' Exchange
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 20/04/2012
 *
 */
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class Acm11678 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (StringTokenizer st; (st = new StringTokenizer(in.readLine())) != null;) {
            int A = parseInt(st.nextToken()), B = parseInt(st.nextToken());
            if (A == 0 && B == 0) {
                break;
            }
            st = new StringTokenizer(in.readLine());
            TreeSet<Integer> a = new TreeSet<Integer>(), b = new TreeSet<Integer>(), tmp = new TreeSet<Integer>();
            for (int i = 0, n; i < A; i++) {
                a.add(n = parseInt(st.nextToken()));
                tmp.add(n);
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < B; i++) {
                b.add(parseInt(st.nextToken()));
            }
            a.removeAll(b);
            b.removeAll(tmp);
            System.out.println(min(a.size(), b.size()));
        }
    }
}
