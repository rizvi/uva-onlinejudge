/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11764 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
//        Scanner sc=new Scanner(new FileInputStream(new File("11764.txt")));
        int T=sc.nextInt();
        for (int t = 0; t <T; t++) {
            int N=sc.nextInt();
            int[] arr=new int[N];
            for (int i = 0; i < N; i++) {
                arr[i]=sc.nextInt();
            }
            int H=0,L=0;
            for (int i = 0; i < N-1; i++) {
                if(arr[i]<arr[i+1]){
                    H++;
                }
                else if(arr[i]>arr[i+1]){
                    L++;
                }
            }
            System.out.printf("Case %d: %d %d\n",t+1,H,L);
        }
    }
}
