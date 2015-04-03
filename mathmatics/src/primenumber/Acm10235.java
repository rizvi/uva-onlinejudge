/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10235 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = buff.readLine()) != null) {
            int num = Integer.parseInt(input);
            if (isPrime(num)) {
                if (isEmirp(input)) {
                    System.out.println(num + " is emirp.");
                } else {
                    System.out.println(num + " is prime.");
                }
            } else {
                System.out.println(num + " is not prime.");
            }
        }
    }

    static boolean isEmirp(String numStr) {
        StringBuilder sb = new StringBuilder(numStr);
        String revStr=sb.reverse().toString();
        if(numStr.equals(revStr)){
            return false;
        }
        int revNum = Integer.parseInt(revStr);
        return isPrime(revNum);
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
