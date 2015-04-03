/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmist.adhoc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm12049 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc=new Scanner(System.in);
        Scanner sc=new Scanner(new FileInputStream(new File("12049.txt")));
        int T=sc.nextInt();
        for (int t=0; t < T; t++) {
            int N=sc.nextInt();
            int M=sc.nextInt();
            int[] nArr=new int[N];
            int[] mArr=new int[M];
            for (int n = 0; n < N; n++) {
                nArr[n]=sc.nextInt();
            }
            for (int m = 0; m < M; m++) {
                mArr[m]=sc.nextInt();
            }
            int count=Math.abs(N-M);
            int min=Math.min(N, M);
            Arrays.sort(nArr);
            Arrays.sort(mArr);
            for (int i = 0; i <min; i++) {
                if(nArr[i]!=mArr[i]){
                    count++;
                }
            }
            System.out.println(count);
            
        }
    }
}
