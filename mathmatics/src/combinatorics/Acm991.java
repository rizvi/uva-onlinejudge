/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm991 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        long[] cat = new long[11];
        cat[0] = 1;
        for (int i = 0; i < 10; i++) {
            cat[i + 1] = cat[i] * ((2 * i + 2) * (2 * i + 1))
                    / ((i + 2) * (i + 1));
        }

        String out = "";
        while (true) {
            String line = buf.readLine();
            int n = Integer.parseInt(line);
            out += cat[n] + "\n\n";
            line = buf.readLine();
            if (line == null) {
                break;
            }
        }
        System.out.print(out.substring(0, out.length() - 1));
    }
}
