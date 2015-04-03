/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p10130 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        Scanner sc=new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream(new File("10130.txt")));
        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                prices[i] = sc.nextInt();
                weights[i] = sc.nextInt();
            }
            int sum = 0;
            int G = sc.nextInt();
            for (int i = 0; i < G; i++) {
                int mw = sc.nextInt();
                sum += calculate(N - 1, mw);
            }
            System.out.println(sum);
        }
    }
    static int[] prices = new int[1005];
    static int[] weights = new int[1005];
    static int[][] map = new int[1005][40];

    static int calculate(int i, int w) {
        if (i < 0) {
            return 0;
        } else if (map[i][w] > 0) {
            return map[i][w];
        } else {
            
            return map[i][w] = (w >= weights[i])
                    ? Math.max(calculate(i - 1, w), prices[i] + calculate(i - 1, w - weights[i]))
                    : calculate(i - 1, w);
        }
    }
}
