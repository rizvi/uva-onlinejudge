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
public class Acm10519 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=buff.readLine())!=null){
           BigInteger num=new BigInteger(input);
           if(num.equals(BigInteger.ZERO)){
               System.out.println(1);
               continue;
           }
           BigInteger res=num.pow(2).subtract(num).add(BigInteger.valueOf(2));
            System.out.println(res);
        }
    }
}
