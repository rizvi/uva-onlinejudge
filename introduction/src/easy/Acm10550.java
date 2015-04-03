/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10550 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int i = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (i == 0 && b == 0 && b == 0 && c == 0) {
                break;
            }
            int deg = 720 + 360 + (((a > i ? (40 - a) + i : (i - a)) + (b < a ? (40 - a) + b : (b - a)) + (c > b ? (40 - c) + b : (b - c)))) * 9;
            System.out.println(deg);
        }
    }
}
