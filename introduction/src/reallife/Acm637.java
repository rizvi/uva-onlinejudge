/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reallife;

import java.util.Scanner;

public class Acm637 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int coeff = n / 4;
            int remainder = n % 4;
            int m = n;
            if (remainder != 0) {
                m = (coeff * 4) + 4;
            }
            int book[] = new int[m];


            for (int i = 0; i < coeff * 4 + remainder; i++) {
                book[i] = i + 1;
            }


            System.out.println("Printing order for " + n + " pages:");
            boolean front = true;
            for (int i = 0, counter = 0; i < m / 2; i++) {
                if (front) {
                    counter++;
                    if (book[m - i - 1] == 0) {
                        System.out.println("Sheet " + counter + ", front: Blank, " + book[i]);
                    } else {
                        System.out.println("Sheet " + counter + ", front: " + book[m - i - 1] + ", " + book[i]);
                    }
                    front = false;
                } else {
                    if (book[m - i - 1] == 0 && book[i] == 0) {
                    } else if (book[m - i - 1] == 0) {
                        System.out.println("Sheet " + counter + ", back : " + book[i] + ", " + "Blank");
                    } else {
                        System.out.println("Sheet " + counter + ", back : " + book[i] + ", " + book[m - i - 1]);
                    }
                    front = true;
                }
            }
        }
    }
}