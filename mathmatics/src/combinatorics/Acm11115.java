/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11115 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int n=sc.nextInt();
            int d=sc.nextInt();
            if(n==0 && d==0){
                break;
            }
            BigInteger res=new BigInteger(""+n).pow(d);
            System.out.println(res);
        }
    }
}
