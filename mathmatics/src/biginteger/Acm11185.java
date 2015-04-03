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
public class Acm11185 {

    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int N=Integer.parseInt(buff.readLine());
            if(N<0){
                break;
            }
            BigInteger res=BigInteger.valueOf(N);
            System.out.println(res.toString(3));
        }
    }
}
