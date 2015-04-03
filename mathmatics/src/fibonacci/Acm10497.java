/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Acm10497 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] fib = new BigInteger[801];
        fib[1] = new BigInteger("0");
        fib[0] = new BigInteger("0");
        for (int i = 2; i < 801; i++) {
            fib[i] = fib[i - 1].multiply(BigInteger.valueOf(i));
            fib[i] = fib[i].add((i % 2 == 0) ? BigInteger.valueOf(1) : BigInteger.valueOf(-1));
        }
        while (true) {
            int n = Integer.parseInt(buf.readLine());
            if (n == -1) {
                break;
            }
            System.out.println(fib[n]);
        }
    }
}
