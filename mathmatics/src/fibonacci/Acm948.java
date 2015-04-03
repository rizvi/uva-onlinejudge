/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm948 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int[] Fib = new int[39];
        Fib[0] = 1;
        Fib[1] = 2;
        for (int i = 2; i <= 38; i++) {
            Fib[i] = Fib[i - 1] + Fib[i - 2];
        }
        int nCases = Integer.parseInt(buf.readLine());
        for (int i = 0; i < nCases; i++) {
            int n = Integer.parseInt(buf.readLine());
            String out = n + " = ";
            boolean taken = false;
            for (int j = 38; j >= 0; j--) {

                if (n / Fib[j] == 1) {
                    out += "1";
                    n %= Fib[j];
                    taken = true;
                } else if (taken) {
                    out += "0";
                }
            }
            System.out.println(out + " (fib)");
        }
    }
}
