/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11875 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N=sc.nextInt();
            int[] arr=new int[N];
            for (int i = 0; i < N; i++) {
                arr[i]=sc.nextInt();
            }
            System.out.printf("Case %d: %d\n",t,arr[N/2]);
        }
    }
}
