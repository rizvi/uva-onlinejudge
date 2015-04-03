/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm332 {

    public static void main(String[] args)  throws FileNotFoundException 
    {
//        Scanner sc=new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream(new File("332.txt")));
        while (true) {
            int j = sc.nextInt();
            if (j == -1) {
                break;
            }
            double fr = sc.nextDouble();
            String frStr = "" + fr;
            int frLen = frStr.length() - 1 - frStr.indexOf('.');

            int k = frLen - j;
            long neo = (long) ((Math.pow(10, frLen) - Math.pow(10, k)));
            long deno = (long) (fr*Math.pow(10, frLen) - fr*Math.pow(10, k));
            System.out.println(deno +" "+neo);
            long g = gcd(deno, neo);

            System.out.println((deno / g) + "/" + (neo / g));
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
