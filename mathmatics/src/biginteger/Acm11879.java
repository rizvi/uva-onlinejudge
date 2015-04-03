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
public class Acm11879 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input=buff.readLine();
            if("0".equals(input)){
                break;
            }
            BigInteger num=new BigInteger(input);
            if(num.mod(BigInteger.valueOf(17)).equals(BigInteger.ZERO)){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }
   
}
