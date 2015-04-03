/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm900 {
    public static void main(String[] args) {
        int n=105;
        long[] fib=new long[n];
        fib[0]=1;
        fib[1]=1;
        for (int i = 2; i <n; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }
        Scanner sc=new Scanner(System.in);
        while(true){
            int num=sc.nextInt();
            if(num==0){
                break;
            }
            System.out.println(fib[num]);
        }
    }
}
