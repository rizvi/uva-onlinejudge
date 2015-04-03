/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * @author Masudul Haque
 */
public class Acm10142 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int c = 0, C = Integer.parseInt(in.readLine().trim()); c < C; c++) {
            if (c == 0) {
                in.readLine();
            }
            int N = 0;
            String[] nombres = new String[N = Integer.parseInt(in.readLine().trim())];
            for (int i = 0; i < N; i++) {
                nombres[i] = in.readLine();
            }
            List<int[]> boletos = new ArrayList<int[]>();
            for (;;) {
                String ln = in.readLine();
                if (ln == null || ln.trim().equals("")) {
                    break;
                }
                StringTokenizer st = new StringTokenizer(ln.trim());
                int[] boleto = new int[N];
                for (int i = 0; i < N; i++) {
                    boleto[i] = Integer.parseInt(st.nextToken()) - 1;
                }
                boletos.add(boleto);
            }
            TreeSet<Integer> eliminados = new TreeSet <Integer>();
            for (;;) {
                int[] puntos = new int[N];
                for (int[] boleto : boletos) {
                    for (int i = 0; i < boleto.length; i++) {
                        if (!eliminados.contains(boleto[i])) {
                            puntos[boleto[i]]++;
                            break;
                        }
                    }
                }
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int i = 0; i < puntos.length; i++) {
                    if (!eliminados.contains(i)) {
                        max = Math.max(max, puntos[i]);
                        min = Math.min(min, puntos[i]);
                    }
                }
                if (min == max) {
                    for (int i = 0; i < puntos.length; i++) {
                        if (!eliminados.contains(i)) {
                            System.out.println(nombres[i]);
                        }
                    }
                    break;
                }
                if (max * 100.0 / boletos.size() > 50) {
                    for (int i = 0; i < puntos.length; i++) {
                        if (puntos[i] == max) {
                            System.out.println(nombres[i]);
                            break;
                        }
                    }
                    break;
                }
                for (int i = 0; i < puntos.length; i++) {
                    if (puntos[i] == min) {
                        eliminados.add(i);
                    }
                }
            }
            if (c < C - 1) {
                System.out.println();
            }
        }
    }
}
