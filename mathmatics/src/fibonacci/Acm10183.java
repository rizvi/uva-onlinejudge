/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Acm10183 {

    public static void main(String[] args) throws IOException {
        int n = 500;
        BigInteger[] fib = new BigInteger[n];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        fib[2] = new BigInteger("2");
        for (int i = 3; i < n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = in.readLine().split(" ");
            if (line[0].equals("0") && line[1].equals("0")) {
                break;
            }
            BigInteger a = new BigInteger(line[0]);
            if (a.toString().equals("0")) {
                a = a.add(new BigInteger("1"));
            }
            BigInteger b = new BigInteger(line[1]);
            int j = 0, i = 0;
            while (fib[i].compareTo(a) == -1) {
                i++;
            }
            j = i;
            while (fib[j].compareTo(b) == -1) {
                j++;
            }
            if (fib[j].compareTo(b) == 0) {
                j++;
            }
            System.out.println(j - i);
        }

    }
}
