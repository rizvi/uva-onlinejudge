/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10450 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(buf.readLine());
        for (int i = 1; i <= nCases; i++) {
            int n = Integer.parseInt(buf.readLine());
            long[] Fib = new long[n + 2];
            Fib[0] = 1;
            Fib[1] = 1;
            for (int j = 2; j < n + 2; j++) {
                Fib[j] = Fib[j - 1] + Fib[j - 2];
            }
            System.out.println("Scenario #" + i + ":");
            System.out.println(Fib[n + 1]);
            System.out.println();
        }
    }
}
