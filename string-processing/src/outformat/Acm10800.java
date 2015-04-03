/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package outformat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10800 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(buff.readLine());
        for (int t = 1; t <= T; t++) {
            String input = buff.readLine();
            char[] ln = input.trim().toCharArray();
            int up = 0;
            int down = 0;
            int pos = 0;
            for (int i = 0; i < ln.length; i++) {
                if (ln[i] == 'R') {
                    pos++;
                }
                if (ln[i] == 'F') {
                    pos--;
                }
                up = Math.max(up, pos);
                down = Math.min(down, pos);
            }
            char[][] res = new char[Math.abs(down) + Math.abs(up) + 5][ln.length + 3];
            down = res.length + down - 2;
            pos = 2;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = ' ';
                }
            }
            for (int i = 0; i < res.length; i++) {
                res[i][0] = '|';
            }
            for (int i = 0; i < res[0].length; i++) {
                res[res.length - 1][i] = '-';
            }
            res[res.length - 1][0] = '+';
            for (int i = 0; i < ln.length; i++, pos++) {
                if (ln[i] == 'R') {
                    res[down--][pos] = '/';
                }
                if (ln[i] == 'F') {
                    if (i > 0 && ln[i - 1] == 'R') {
                        res[++down][pos] = '\\';
                    } else {
                        res[++down][pos] = '\\';
                    }
                }
                if (ln[i] == 'C') {
                    res[down][pos] = '_';
                }
            }
            sb.append("Case #").append( t).append(":\n");
            for (int i = 0; i < res.length; i++) {
                if (!new String(res[i]).trim().equals("|")) {
                    sb.append(new String(res[i]).trim() + "\n");
                }
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}
