/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Acm763 {

    static BigInteger fibonaci[] = new BigInteger[250];

    public static void run() {
        fibonaci[0] = BigInteger.ONE;
        fibonaci[1] = new BigInteger("2");
        for (int i = 2; i < 250; i++) {
            fibonaci[i] = fibonaci[i - 1].add(fibonaci[i - 2]);
        }
    }

    public static void main(String[] args) throws IOException {
        run();
        Scanner in = new Scanner(System.in);
        boolean started = false;
        while (in.hasNext()) {
            if (!started) {
                started = true;
            } else {
                System.out.println();
            }

            BigInteger a = unFib(in.next()), b = unFib(in.next()), sum = a.add(b);
            System.out.println(Fib(sum));
        }
    }

    private static String Fib(BigInteger sum) {
        String ans = "";
        for (int i = 249; i >= 0; i--) {
            if (sum.compareTo(fibonaci[i]) > -1) {
                ans += "1";
                sum = sum.subtract(fibonaci[i]);
            } else {
                ans += ans.length() > 0 ? "0" : "";
            }
        }
        return ans + (ans.length() == 0 ? "0" : "");
    }

    private static BigInteger unFib(String next) {
        BigInteger ans = BigInteger.ZERO;
        char[] a = reverse(next).toCharArray();
        for (int i = 0; i < a.length; i++) {
            ans = ans.add(fibonaci[i].multiply(new BigInteger(a[i] + "")));
        }
        return ans;
    }

    private static String reverse(String next) {
        String a = "";
        for (char c : next.toCharArray()) {
            a = c + a;
        }
        return a;
    }
}
