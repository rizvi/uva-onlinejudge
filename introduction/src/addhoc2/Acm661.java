/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

/**
 *
 * @author Masudul Haque
 */
import static java.lang.Integer.*;
import java.io.*;
import java.util.StringTokenizer;

public class Acm661 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int caso = 1;; caso++) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), C = parseInt(st.nextToken());
            if (N == 0 && M == 0 && C == 0) {
                break;
            }
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = parseInt(in.readLine().trim());
            }
            boolean[] prendidos = new boolean[N];
            int max = 0, va = 0;
            for (int i = 0; i < M; i++) {
                int aparato = parseInt(in.readLine()) - 1;
                va += arr[aparato] * (prendidos[aparato] ? -1 : 1);
                prendidos[aparato] = !prendidos[aparato];
                max = Math.max(max, va);
            }
            System.out.println("Sequence " + caso);
            if (max > C) {
                System.out.println("Fuse was blown.");
            } else {
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was " + max + " amperes.");
            }
            System.out.println();
        }
    }
}
