/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10852 {
    public static void main(String[] args) //throws FileNotFoundException 
    {
        Scanner sc=new Scanner(System.in);
//        Scanner sc=new Scanner(new FileInputStream(new File("10852.txt")));
        int t=sc.nextInt();
        for (int n = 0; n <t; n++) {
            int num=sc.nextInt();
            int half=num/2+1;
            while(!isPrime(half)){
                half++;
            }       
            System.out.println(half);
        }
    }
    
    static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
