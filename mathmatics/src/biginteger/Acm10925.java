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
public class Acm10925 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=1;
        while (true) {
            int n = sc.nextInt();
            int f = sc.nextInt();
            if (n == 0 && f == 0) {
                break;
            }
            BigInteger sum=BigInteger.ZERO,v=BigInteger.valueOf(f);
            for(int i=1;i<=n;i++){
                BigInteger cost=sc.nextBigInteger();
                sum=sum.add(cost);                
            }
            System.out.println("Bill #"+count+" costs "+sum+": each friend should pay "+sum.divide(v));
            System.out.println();
            count++;
        }
    }
}
