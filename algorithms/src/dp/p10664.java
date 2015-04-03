/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class p10664 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("10664.txt")));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] in = br.readLine().split(" ");
            int[] num = new int[in.length];
            int total = 0;
            for (int i = 0; i < in.length; i++) {
                num[i] = Integer.parseInt(in[i]);
                total += num[i];
            }
            if (total % 2 == 1) {
                System.out.println("NO");
            } else {
                int n = num.length + 1;
                int halfWeight = total / 2;

                boolean[][] dpTable = new boolean[n][halfWeight + 1];

                // Base case 1: weights = 0 for all n --> True 
                for (int i = 0; i < n; i++) {
                    dpTable[i][0] = true;
                }

                // Base case 2: weights !=0 for all n=0 --> False  
                for (int i = 1; i < halfWeight + 1; i++) {
                    dpTable[0][i] = false;
                }

                for (int i = 1; i < n; i++) {
                    for (int j = 1; j < halfWeight + 1; j++) {

                        int w_i = num[i - 1]; // weight of ith item

                        if (j < w_i) // this item can't be included since its over the limit:j 
                        {
                            dpTable[i][j] = dpTable[i - 1][j];
                        } else {
                            dpTable[i][j] = dpTable[i - 1][j] || dpTable[i - 1][j - w_i];
                        }
                    }
                }
                if(dpTable[n-1][halfWeight]){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
