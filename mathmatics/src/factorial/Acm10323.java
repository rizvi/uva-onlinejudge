/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10323 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = buff.readLine()) != null) {
            int n = Integer.parseInt(input);
            if (n < 0 && n % 2 != 0) {
                System.out.println("Overflow!");
            } else if (n < 0 && n % 2 == 0) {
                System.out.println("Underflow!");
            }
            else if (n < 8) {
                System.out.println("Underflow!");
            } else if (n > 13) {
                System.out.println("Overflow!");
            } else {
                long fact = 1;
                for (int i = 1; i <= n; i++) {
                    fact = fact * i;
                }
                System.out.println(fact);
            }
        }
    }
}
