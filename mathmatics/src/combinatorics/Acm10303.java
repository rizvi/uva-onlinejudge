/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

import java.math.BigInteger;
import java.util.Scanner;

public class Acm10303 {

    static BigInteger[] list = new BigInteger[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        preprocess();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(list[n]);
        }
    }

    private static void preprocess() {
        list[1] = BigInteger.ONE;
        for (int i = 2; i <= 1000; i++) {
            list[i] = list[i - 1].multiply(new BigInteger((2 * (2 * (i - 1) + 1) + "")));
            list[i] = list[i].divide(new BigInteger((i + 1) + ""));
        }
    }
}
