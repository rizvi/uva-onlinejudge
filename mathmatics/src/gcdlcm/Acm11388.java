/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11388 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int n = 0; n < t; n++) {
            int gcd=sc.nextInt();
            int lcm=sc.nextInt();
            if(lcm%gcd==0){
                System.out.println(gcd+" "+lcm);
            }
            else{
                System.out.println("-1");
            }
        }
    }
}
