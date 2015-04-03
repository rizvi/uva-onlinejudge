/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class Acm10334 {

    public static void main(String[] args) throws IOException {
        int n = 1002;
        BigInteger[] fib = new BigInteger[n];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        fib[2] = new BigInteger("2");
        for (int i = 3; i < n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = in.readLine()) != null) {
            int index = Integer.parseInt(input);
            System.out.println(fib[index+1]);
        }
    }
}
