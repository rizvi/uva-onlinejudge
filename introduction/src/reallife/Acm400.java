/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Masudul Haque
 */
public class Acm400 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null;) {
            int N = Integer.parseInt(ln.trim()), max = 0, C, R;
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                max = Math.max(max, (arr[i] = in.readLine()).length());
            }
            Arrays.sort(arr);
            C = (60 - max) / (max + 2) + 1;
            R = (int) Math.ceil(1. * N / C);
            for (int i = 0; i < 60; i++) {
                sb.append("-");
            }
            sb.append("\n");
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (j * R + i < N) {
                        sb.append((j > 0 ? "  " : "") + arr[j * R + i]);
                        for (int h = arr[j * R + i].length(); h < max; h++) {
                            sb.append(" ");
                        }
                    }
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
