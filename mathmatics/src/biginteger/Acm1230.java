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
public class Acm1230 {
    public static void main(String[] args) throws IOException {
       
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(buff.readLine());
        for (int t = 0; t < T; t++) {
            String[] input=buff.readLine().split(" ");
            BigInteger x=new BigInteger(input[0]);
            BigInteger y=new BigInteger(input[1]);
            BigInteger n=new BigInteger(input[2]);
            x=x.modPow(y, n);
            System.out.println(x);
        }
    }
   
}
