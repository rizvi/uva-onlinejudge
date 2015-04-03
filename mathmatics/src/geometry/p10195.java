/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p10195 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            double s = (a + b + c) / 2.0;
            double res = 0.0;
            if (s > 0.0) {
                res = Math.sqrt(((s - a) * (s - b) * (s - c)) / s);
            }
            System.out.printf("The radius of the round table is: %.3f\n", res);
        }
    }
}
