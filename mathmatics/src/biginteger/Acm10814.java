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
public class Acm10814 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String input=sc.nextLine();
            String[] str=input.split(" ");
            if("1".equals(str[0]) || "1".equals(str[2])){                
                System.out.println(input);
            }
            else if(str[0].equals(str[2])){
                System.out.println("1 / 1");
            }
            else{
                BigInteger first= new BigInteger(str[0]);
                BigInteger second= new BigInteger(str[2]);
                BigInteger g=first.gcd(second);
                System.out.println(first.divide(g)+" / "+second.divide(g));               
            }
            
        }
    }
}
