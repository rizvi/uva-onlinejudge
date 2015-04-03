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
public class Acm10523 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int i=sc.nextInt();
            int ex=sc.nextInt();
            BigInteger sum=new BigInteger("0"),temp=BigInteger.valueOf(ex);
            for (int j = 1; j <= i; j++) {
                sum=sum.add(BigInteger.valueOf(j).multiply(temp.pow(j)));                
            }
            System.out.println(sum);
        }
    }
}
