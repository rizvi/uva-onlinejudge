/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class Acm11448 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(buff.readLine());
        for (int t = 0; t < T; t++) {
            String[] str=buff.readLine().split(" ");
            BigInteger first=new BigInteger(str[0]);
            BigInteger second=new BigInteger(str[1]);
            first=first.subtract(second);
            System.out.println(first);
        }
    }
   
}
