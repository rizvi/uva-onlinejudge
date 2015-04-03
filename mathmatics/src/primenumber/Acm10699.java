/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Masudul Haque
 */
public class Acm10699 {

    public static void main(String[] args)// throws FileNotFoundException 
    {
        Scanner sc = new Scanner(System.in);
//        Scanner sc=new Scanner(new FileInputStream(new File("10699.txt")));
        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            Set<Integer> primeSet = primeFactors(num);
            System.out.println(num + " : " + primeSet.size());
        }
    }

    public static Set<Integer> primeFactors(int numbers) {
        int n = numbers;
        Set<Integer> primeSet = new HashSet<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                primeSet.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            primeSet.add(n);
        }

        return primeSet;
    }
}
