/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerfunction;

import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class Acm10179 {
    public static void main(String[] args) {
        int n=10000000;
        BigInteger[] arr=new BigInteger[n];
        int count=0;
        for (int i = 0; i < n; i++) {
            if(gcd(i, n)==1){
              arr[i]=BigInteger.valueOf(count++);
            }
        }
        System.out.println(arr[11]);
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
