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
import java.util.StringTokenizer;
import static java.lang.Integer.*;

public class Acm11507 {
    /* No: -1, +x: 0, -x: 1, +y: 2, -y: 3, +z: 4, -z: 5 */
    static int val(String st) {
        if (st.equals("+x")) {
            return 0;
        }
        if (st.equals("-x")) {
            return 1;
        }
        if (st.equals("+y")) {
            return 2;
        }
        if (st.equals("-y")) {
            return 3;
        }
        if (st.equals("+z")) {
            return 4;
        }
        if (st.equals("-z")) {
            return 5;
        }
        return -1;
    }

    static String val(int n) {
        if (n == 0) {
            return "+x";
        }
        if (n == 1) {
            return "-x";
        }
        if (n == 2) {
            return "+y";
        }
        if (n == 3) {
            return "-y";
        }
        if (n == 4) {
            return "+z";
        }
        if (n == 5) {
            return "-z";
        }
        return "";
    }

    static int function(int desde, int hasta) {
        int[][] arr = new int[][]{{0, 0, 2, 3, 4, 5}, {0, 0, 3, 2, 5, 4}, {0, 0, 1, 0, 2, 2}, {0, 0, 0, 1, 3, 3}, {0, 0, 4, 4, 1, 0}, {0, 0, 5, 5, 0, 1}};
        if (hasta == -1) {
            return desde;
        }
        return arr[desde][hasta];
    }

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int N; (N = parseInt(in.readLine().trim())) != 0;) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int resultado = 0;
            for (int i = 0; i < N - 1; i++) {
                resultado = function(resultado, val(st.nextToken()));
            }
            System.out.println(val(resultado));
        }
    }
}
