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
public class Acm713 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(buff.readLine());
        for (int t = 0; t < T; t++) {
            String input=buff.readLine();
            String[] str=input.split(" ");
            StringBuilder first=new StringBuilder(str[0]);
            StringBuilder second=new StringBuilder(str[1]);
            BigInteger a=new BigInteger(first.reverse().toString());
            BigInteger b=new BigInteger(second.reverse().toString());
            a=a.add(b);
            StringBuilder res=new StringBuilder(a.toString());
            String output=res.reverse().toString();
           
            System.out.println(omit(output));
        }
    }
    private static String omit(String str){
        while(str.charAt(0)=='0'){
            str=str.substring(1, str.length());   
        }
        return str;
    }
}
