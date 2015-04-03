/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11727 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("");
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int n = 1; n <=t; n++) {
            int[] arr=new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            sb.append("Case ").append(n).append(": ").append(arr[1]).append("\n");
        }
        System.out.print(sb);
    }
}
