/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11799 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
//        Scanner sc=new Scanner(new FileInputStream(new File("11799.txt")));
        int T=Integer.parseInt(sc.nextLine());
        for (int t = 0; t <T; t++) {
            String[] input=sc.nextLine().split(" ");
            int[] arr=new int[input.length];
            int max=0;
            for (int i = 0; i < input.length; i++) {
                arr[i]=Integer.parseInt(input[i]);
                if(max<arr[i]){
                    max=arr[i];
                }
            }
            System.out.printf("Case %d: %d\n",t+1,max);
        }
    }
}
