/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10473 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String hexSymbol = "0x";
            String input = sc.nextLine();
            if (input.startsWith(hexSymbol)) {
                System.out.println(Integer.parseInt(input.substring(2), 16));
            } else {
                int dec = Integer.parseInt(input);
                if (dec < 0) {
                    break;
                }
                System.out.println(hexSymbol + Integer.toHexString(dec).toUpperCase());
            }
        }
    }
}
