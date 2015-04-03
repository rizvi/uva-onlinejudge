/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrecent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p12455 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("12455.txt")));
        int t = sc.nextInt();
        while (t-- > 0) {
           int w = sc.nextInt();
           int n = sc.nextInt();
            int[] dp = new int[1005];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
               int  p = sc.nextInt();
                for (int j = w - p; j >= 0; j--) {
                    if (dp[j] > 0 && dp[j + p] == 0) {
                        dp[j + p] = 1;
                    }
                }
            }
            if (dp[w] > 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
