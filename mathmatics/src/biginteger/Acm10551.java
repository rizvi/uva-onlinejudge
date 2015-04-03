/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10551 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            String input=sc.nextLine();
            if("0".equals(input)){
                break;
            }
            String[] str=input.split(" ");
            int base=Integer.parseInt(str[0]);
            BigInteger res=new BigInteger(str[1],base).mod(new BigInteger(str[2],base));
            System.out.println(res.toString(base));
        }
        
    }
}
