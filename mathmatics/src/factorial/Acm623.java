/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm623 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger fact = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            System.out.printf("%d!\n",n);
            System.out.println(fact);
        }
    }
}
