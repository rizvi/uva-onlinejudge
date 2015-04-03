/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10127 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int ones = 1, acc = 1, n = in.nextInt();
            while (acc != 0) {
                if (n > acc) {
                    ones++;
                }
                acc = n > acc ? acc * 10 + 1 : acc % n;
            }
            System.out.println(ones);
        }
    }
}