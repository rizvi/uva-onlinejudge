/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10703
 * @problemName Free spots
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 03/01/2010
 *
 */
import static java.lang.Integer.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class Acm10703 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine().trim()) != null;) {
            StringTokenizer st = new StringTokenizer(ln);
            int W = parseInt(st.nextToken()), H = parseInt(st.nextToken()), N = parseInt(st.nextToken());
            if (W == 0 && H == 0 && N == 0) {
                break;
            }
            boolean[][] t = new boolean[W][H];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine().trim());
                int x1 = parseInt(st.nextToken()) - 1, y1 = parseInt(st.nextToken()) - 1, x2 = parseInt(st.nextToken()) - 1, y2 = parseInt(st.nextToken()) - 1;
                for (int j = min(x1, x2); j <= max(x2, x1); j++) {
                    for (int h = min(y1, y2); h <= max(y2, y1); h++) {
                        t[j][h] = true;
                    }
                }
            }
            int cont = 0;
            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t[i].length; j++) {
                    if (!t[i][j]) {
                        cont++;
                    }
                }
            }
            in.readLine();
            if (cont == 0) {
                System.out.println("There is no empty spots.");
            } else if (cont == 1) {
                System.out.println("There is one empty spot.");
            } else {
                System.out.println("There are " + cont + " empty spots.");
            }
        }
    }
}
