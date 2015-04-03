/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prevcontest;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10911
 * @problemName Forming Quiz Teams
 * @judge http://uva.onlinejudge.org/
 * @category dynamic program
 * @level medium
 * @date 21/07/2010
 *
 */
import java.awt.*;
import java.io.*;
import java.util.*;
import static java.lang.Double.*;

public class Acm10911 {

    static Point puntos[];
    static double[] mem;

    static double function(int estado) {
        if (mem[estado] > -1) {
            return mem[estado];
        }
        double min = MAX_VALUE;
        for (int i = 0; i < puntos.length; i++) {
            boolean ws1, ws2;
            if (ws1 = (estado >> i) % 2 == 0) {
                for (int j = i + 1; j < puntos.length; j++) {
                    if (ws2 = (estado >> j) % 2 == 0) {
                        if (ws1) {
                            estado = estado | (1 << i);
                        }
                        if (ws2) {
                            estado = estado | (1 << j);
                        }
                        double val = function(estado);
                        min = Math.min(min, (val == MAX_VALUE ? 0 : val) + puntos[i].distance(puntos[j]));
                        if (ws1) {
                            estado = estado ^ (1 << i);
                        }
                        if (ws2) {
                            estado = estado ^ (1 << j);
                        }
                    }
                }
            }
        }
        return mem[estado] = min;
    }

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long t = System.currentTimeMillis();
        for (double N, caso = 1; (N = parseDouble(in.readLine())) != 0; caso++) {
            puntos = new Point[2 * (int) N];
            for (int i = 0; i < 2 * N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine().trim());
                st.nextToken();
                puntos[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            mem = new double[1 << 16];
            Arrays.fill(mem, -1);
            double res = function(0);
            System.out.printf(Locale.US, "Case %d: %.2f%n", (int) caso, res);
        }
    }
}
