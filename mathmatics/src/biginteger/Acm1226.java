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
public class Acm1226 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        for (int t=  0; t < T; t++) {
            BigInteger divisor=new BigInteger(sc.nextLine());
            BigInteger dividant=new BigInteger(sc.nextLine());
            dividant=dividant.mod(divisor);
            System.out.println(dividant);
        }
    }
}
