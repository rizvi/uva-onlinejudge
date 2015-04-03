/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.util.Scanner;

public class p12342 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int income = sc.nextInt();
            int tax = (int) tax(income);
            System.out.println("Case " + t + ": " + tax);
        }
    }

    static double tax(int x) {
        if (x < 180001) {
            return 0;
        }
        if (x < 200001) {
            return 2000;
        }
        if (x < 480001) {
            return Math.ceil((x - 180000) * 0.1);
        }
        double temp = 0;
        if (x < 880001) {
            x -= 480000;
            temp = 30000;
            return Math.ceil((x * 0.15) + temp);
        }
        if (x < 1180001) {
            x -= 880000;
            temp = 90000;
            return Math.ceil((x * 0.2) + temp);
        }
        x -= 1180000;
        temp = 150000;
        return Math.ceil((x * 0.25) + temp);
    }
}
