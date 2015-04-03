/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p12571 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("12571.txt")));
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            int[] x = new int[N];
            for (int j = 0; j < x.length; j++) {
                x[j] = sc.nextInt();
            }
            for (int j = 0; j < Q; j++) {
                int q = sc.nextInt();
                int max = 0;
                for (int k = 0; k < x.length; k++) {
                    int value = q & x[k];
                    if(max<value){
                        max=value;
                    }
                }
                System.out.println(max);
            }
        }
    }
}
