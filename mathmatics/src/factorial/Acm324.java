/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm324 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int n=sc.nextInt();
            if(n==0){
                break;
            }
            BigInteger fact=BigInteger.ONE;
            for (int i = 1; i <=n; i++) {
                fact=fact.multiply(BigInteger.valueOf(i));
            }
            char[] factChar=fact.toString().toCharArray();
            int[] eachDigit=new int[10];
            int is0=0,is1=0,is2=0,is3=0,is4=0,is5=0,is6=0,is7=0,is8=0,is9=0;
            for (int i = 0; i < factChar.length; i++) {
                char c = factChar[i];
                eachDigit[c-'0']++;
            }
            System.out.printf("%d! --\n",n);
            for (int i = 0; i <10; i++) {
                System.out.printf("   (%d)    %4d",i,eachDigit[i]);
                if(i==4){
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
