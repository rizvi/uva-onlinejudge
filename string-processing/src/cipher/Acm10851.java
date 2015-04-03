/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10851
 * @problemName 2D Hieroglyphs decoder
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 22/12/2010
 *
 */
import static java.lang.Integer.*;
import java.io.*;

public class Acm10851 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int c = 0, C = parseInt(in.readLine().trim()); c < C; c++) {
            if (c > 0) {
                in.readLine();
            }
            char[][] matriz = new char[8][];
            in.readLine();
            for (int i = 0; i < matriz.length; i++) {
                matriz[i] = in.readLine().trim().toCharArray();
            }
            for (int i = 1; i < matriz[0].length - 1; i++) {
                int sol = 0;
                for (int j = 0, mult = 1; j < matriz.length; j++, mult *= 2) {
                    sol += (matriz[j][i] == '\\' ? mult : 0);
                }
                sb.append((char) sol);
            }
            in.readLine();
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
