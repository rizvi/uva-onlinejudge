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
public class Acm10812 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            if (s < d) {
                System.out.println("impossible");
            } else {
                int total = s + d;
                if (total % 2 == 0) {
                    int a = total / 2;
                    int b = s - a;
                    System.out.println(a + " " + b);
                } else {
                    System.out.println("impossible");
                }
            }
        }
    }
}
