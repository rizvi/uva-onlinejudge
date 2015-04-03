/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

import java.util.Scanner;
import java.util.TreeSet;

public class Acm443 {

    static TreeSet<Integer> store = new TreeSet<Integer>();

    static void generator() {
        // store.add(1);

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                for (int k = 0; k < 32; k++) {
                    for (int l = 0; l < 32; l++) {
                        store.add((int) (Math.pow(7, l) * Math.pow(5, k)
                                * Math.pow(3, j) * Math.pow(2, i)));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        generator();
        StringBuilder sb = new StringBuilder("");

        Object[] arr = store.toArray();

        while (true) {
            int n = s.nextInt();
            if (n == 0) {
                System.out.print(sb);
                return;
            }

            if (n % 100 >= 10 && n % 100 <= 19) {
                sb.append("The " + n + "th humble number is " + arr[n - 1]
                        + ".\n");
            } else if (n % 10 == 1) {
                sb.append("The " + n + "st humble number is " + arr[n - 1]
                        + ".\n");
            } else if (n % 10 == 2) {
                sb.append("The " + n + "nd humble number is " + arr[n - 1]
                        + ".\n");
            } else if (n % 10 == 3) {
                sb.append("The " + n + "rd humble number is " + arr[n - 1]
                        + ".\n");
            } else {
                sb.append("The " + n + "th humble number is " + arr[n - 1]
                        + ".\n");
            }

        }
    }
}
