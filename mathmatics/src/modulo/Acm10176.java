/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10176 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String S = input.nextLine();
            BigInteger N = BigInteger.valueOf(0);
            BigInteger n = BigInteger.valueOf(1);
            for (int i = 0; i < S.length() - 1; i++) {
                if (S.charAt(i) == '1') {
                    N = N.add(n);
                }
                n = n.multiply(BigInteger.valueOf(2));
            }
            if (N.mod(BigInteger.valueOf(131071)) == BigInteger.valueOf(0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
