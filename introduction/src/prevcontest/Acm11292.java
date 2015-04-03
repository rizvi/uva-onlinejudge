/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prevcontest;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 11292
 * @probleName Dragon of Loowater
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 22/07/2010
 *
 */
import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

public class Acm11292 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            if (M == 0 && N == 0) {
                break;
            }
            int[] heads = new int[N], knights = new int[M];
            for (int i = 0; i < N; i++) {
                heads[i] = parseInt(in.readLine().trim());
            }
            for (int i = 0; i < M; i++) {
                knights[i] = parseInt(in.readLine().trim());
            }
            long res = 0;
            Arrays.sort(heads);
            Arrays.sort(knights);
            int k = 0;
            for (int i = 0; i < knights.length && k < heads.length; i++) {
                if (knights[i] >= heads[k]) {
                    res += knights[i];
                    k++;
                }
            }
            if (k < heads.length) {
                System.out.println("Loowater is doomed!");
            } else {
                System.out.println(res);
            }
        }
    }
}
