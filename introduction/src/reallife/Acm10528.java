/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm10528 {

    public static void main(String[] args) throws Throwable {
        String[][] escalas = new String[12][];
        escalas[0] = new String[]{"C", "C", "D", "E", "F", "G", "A", "B"};
        escalas[1] = new String[]{"C#", "C#", "D#", "F", "F#", "G#", "A#", "C"};
        escalas[2] = new String[]{"D", "D", "E", "F#", "G", "A", "B", "C#"};
        escalas[3] = new String[]{"D#", "D#", "F", "G", "G#", "A#", "C", "D"};
        escalas[4] = new String[]{"E", "E", "F#", "G#", "A", "B", "C#", "D#"};
        escalas[5] = new String[]{"F", "F", "G", "A", "A#", "C", "D", "E"};
        escalas[6] = new String[]{"F#", "F#", "G#", "A#", "B", "C#", "D#", "F"};
        escalas[7] = new String[]{"G", "G", "A", "B", "C", "D", "E", "F#"};
        escalas[8] = new String[]{"G#", "G#", "A#", "C", "C#", "D#", "F", "G"};
        escalas[9] = new String[]{"A", "A", "B", "C#", "D", "E", "F#", "G#"};
        escalas[10] = new String[]{"A#", "A#", "C", "D", "D#", "F", "G", "A"};
        escalas[11] = new String[]{"B", "B", "C#", "D#", "E", "F#", "G#", "A#"};
        for (String[] a : escalas) {
            Arrays.sort(a, 1, a.length);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        for (String ln; !(ln = in.readLine().trim().toUpperCase()).equals("END");) {
            boolean primero = true;
            for (int i = 0; i < escalas.length; i++) {
                boolean ws = true;
                StringTokenizer st = new StringTokenizer(ln);
                for (; st.hasMoreTokens() && ws;) {
                    ws = Arrays.binarySearch(escalas[i], 1, escalas[i].length, st.nextToken()) >= 0;
                }
                if (ws) {
                    if (!primero) {
                        sb.append(" ");
                    }
                    primero = false;
                    sb.append(escalas[i][0]);
                }
            }
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
