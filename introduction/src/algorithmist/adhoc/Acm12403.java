/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmist.adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm12403 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int amount = 0;
        for (int n = 0; n < t; n++) {
            String string = sc.nextLine();
            if (string.startsWith("donate")) {
                String[] in = string.split(" ");
                amount += Integer.parseInt(in[1]);
            } else if (string.startsWith("report")) {
                System.out.println(amount);
            }
        }
    }
}
