/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm10191 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caso = 1;
        for (String ln; (ln = in.readLine()) != null; caso++) {
            int N = Integer.parseInt(ln.trim());
            boolean[] s = new boolean[480];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                String desde = st.nextToken(), hasta = st.nextToken();
                st = new StringTokenizer(desde, ":");
                int hDesde = Integer.parseInt(st.nextToken()) - 10, mDesde = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(hasta, ":");
                int hHasta = Integer.parseInt(st.nextToken()) - 10, mHasta = Integer.parseInt(st.nextToken());
                for (int k = hDesde * 60 + mDesde; k < hHasta * 60 + mHasta; k++) {
                    s[k] = true;
                }
            }
            int max = 0, p = -1, d = -1;
            for (int i = 0; i < 480; i++) {
                if (!s[i] && d == -1) {
                    d = i;
                }
                if (s[i]) {
                    if (d > -1 && max < i - d) {
                        max = i - d;
                        p = d;
                    }
                    d = -1;
                }
            }
            if (d > -1 && 480 - d > max) {
                max = 480 - d;
                p = d;
            }
            sb.append("Day #" + caso + ": the longest nap starts at " + (p / 60 + 10) + ":" + (p % 60 < 10 ? "0" + p % 60 : p % 60) + " and will last for " + (max >= 60 ? max / 60 + " hours and " + max % 60 : max) + " minutes.\n");
        }
        System.out.print(new String(sb));
    }
}
