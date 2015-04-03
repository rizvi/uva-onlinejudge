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
public class Acm465_2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String line=sc.nextLine();
            
            String  operator;
            String[] num;
            if(line.indexOf('+')!= -1){
                operator="+";
                num=line.split("\\+");
            }
            else{
                operator="*";
                num=line.split("\\*");
            }
            
            BigInteger a=new BigInteger(num[0].trim());
            BigInteger b=new BigInteger(num[1].trim());
            System.out.println(line);
            if(a.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){
                System.out.println("first number too big");
            }
            if(b.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){
                System.out.println("second number too big");
            }
             if("+".equals(operator)){
                a=a.add(b);
            }
            else if("*".equals(operator)){
                a=a.multiply(b);
            }
            if(a.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){
                System.out.println("result too big");
            }
        }
    }
}
