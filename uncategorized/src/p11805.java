/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masud
 */
public class p11805 {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
//        Scanner sc=new Scanner(new FileInputStream(new File("11805.txt")));
        int testCase=sc.nextInt();
        for (int t = 1; t <=testCase; t++) {
            int N=sc.nextInt();
            int K=sc.nextInt();
            int P=sc.nextInt();
            int[] arr=new int[N];
            int i=0;
            arr[0]=K;
            for (int n = 2; n <=N; n++) {
                int v= ++K %(N+1);
                if(v==0){
                    v=1;
                    K=1;
                }
                arr[++i]=v;
            }
            int value=P%N;
            System.out.printf("Case %d: %d\n",t,arr[value]);
        }
    }
}
