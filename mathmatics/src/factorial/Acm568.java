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
public class Acm568 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
             BigInteger fact=BigInteger.ONE;
            for (int i = 1; i <=n; i++) {
                fact=fact.multiply(BigInteger.valueOf(i));
            }
            String factStr=fact.toString();
            int lastDigit=0;
            for (int i = factStr.length()-1; i >=0 ; i--) {
              char ch=factStr.charAt(i);
              if(ch!='0'){
                  lastDigit=ch-'0';
                  break;
              }
            }
            System.out.printf("%5d -> %d\n",n,lastDigit);
        }
    }
}
