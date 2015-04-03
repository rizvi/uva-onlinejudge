/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10193 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("10193.txt")));
        int t = Integer.parseInt(buff.readLine());
        for (int n = 1; n <= t; n++) {
            int a = Integer.parseInt(buff.readLine(), 2);
            int b = Integer.parseInt(buff.readLine(), 2);
            if (gcd(a, b) != 1) {
                System.out.println("Pair #" + n + ": All you need is love!");
            } else {
                System.out.println("Pair #" + n + ": Love is not all you need!");
            }
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
