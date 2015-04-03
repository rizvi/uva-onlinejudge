/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11547 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long res = (n * 567 / 9 + 7492) * 235 / 47 - 498;
            String resStr = "" + res;
            int digit = resStr.charAt(resStr.length() - 2) - '0';
            System.out.println(digit);
        }
    }
}
