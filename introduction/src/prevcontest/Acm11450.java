/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prevcontest;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 11450
 * @problemName Wedding shopping
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 26/04/2010
 *
 */

import java.io.*;
import java.util.*;
import static java.lang.Integer.*;

public class Acm11450 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0, N = parseInt(in.readLine().trim()); i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int C = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            TreeSet<Integer> mem = new TreeSet<Integer>();
            mem.add(0);
            for (int j = 0; j < M; j++) {
                TreeSet<Integer> memNew = new TreeSet<Integer>();
                st = new StringTokenizer(in.readLine().trim());
                int K = parseInt(st.nextToken());
                for (int k = 0; k < K; k++) {
                    int v = parseInt(st.nextToken());
                    for (int m : mem) {
                        if (m + v <= C) {
                            memNew.add(m + v);
                        }
                    }
                }
                mem = memNew;
            }
            System.out.println(mem.size() > 0 ? mem.last() : "no solution");
        }
    }
}