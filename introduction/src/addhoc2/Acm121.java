/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

/**
 *
 * @author Masudul Haque
 */
import java.io.*;
import java.util.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Acm121 {

    static int normal(double a, double b) {
        return (int) floor(a) * (int) floor(b);
    }

    static int skew(double a, double b) {
        int s = (int) ((a - 1) / (Math.sqrt(3) / 2)) + (a >= 1 ? 1 : 0), even = (int) ceil(s / 2.), odd = s / 2;
        return even * (int) floor(b) + odd * ((int) floor(b - 0.5));
    }

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null;) {
            StringTokenizer st = new StringTokenizer(ln);
            double a = parseDouble(st.nextToken()), b = parseDouble(st.nextToken());
            int max = normal(a, b);
            boolean ws = true;
            if (max < skew(a, b) || max < skew(b, a)) {
                ws = false;
                max = max(skew(a, b), skew(b, a));
            }
            sb.append(max + " " + (ws ? "grid" : "skew") + "\n");
        }
        System.out.print(new String(sb));
    }
}
