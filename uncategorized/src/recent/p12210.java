/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p12210 {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("12210.txt")));
        int t=0;
        while(sc.hasNext()){
            int B=sc.nextInt();
            int S=sc.nextInt();
            if(B==0 && S==0){
                break;
            }
            int[] arrB=new int[B];
            int[] arrS=new int[S];
            for (int i = 0; i < arrB.length; i++) {
                arrB[i]=sc.nextInt();
            }
            for (int i = 0; i < arrS.length; i++) {
                arrS[i]=sc.nextInt();
            }
            if(B<=S){
                System.out.printf("Case %d: 0\n", ++t);
            }
            else{
                Arrays.sort(arrB);
                System.out.printf("Case %d: %d %d\n", ++t, B-S, arrB[0]);            
            }
        }
    }
}
