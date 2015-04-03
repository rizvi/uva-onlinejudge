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
public class Acm10212 {

    public static void main(String[] args) {

        int  k, l;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] str = input.split(" ");
            int i = Integer.parseInt(str[0]);
            int j = Integer.parseInt(str[1]);

            int res = 1,t = 0,f = 0;
                for (k = i; k > i - j; k--) {
                    l = k;
                  
                    while (l % 5 == 0) {
                        l /= 5;
                        f++;
                    }
                    res = (res * l) % 10;
                }
                for (i = t; i < f; i++) {
                    res = (res * 5) % 10;
                }
                for (i = f; i < t; i++) {
                    res = (res * 2) % 10;
                }
                System.out.printf("%d\n", res % 10);

            }
        }
    }
