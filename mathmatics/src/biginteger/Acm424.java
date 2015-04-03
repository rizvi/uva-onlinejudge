/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm424 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        BigInteger res = new BigInteger("0");
        while (!(input = sc.nextLine()).equals("0")) {
            res = res.add(new BigInteger(input));
        }
        System.out.println(res);
    }
}
