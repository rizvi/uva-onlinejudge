/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrecent;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p10633 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long Y = sc.nextLong();
            if (Y == 0) {
                break;
            }
            long N = (10 * Y) / 9;
            if (Y % 9 == 0) {
                System.out.println((N - 1) + " " + N);
            } else {
                System.out.println(N);
            }
        }
    }
}
