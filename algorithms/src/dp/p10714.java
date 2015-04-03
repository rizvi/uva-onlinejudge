/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p10714 {
    static int t, l, n;
    static int[] pos = new int[100010];
    
    static void solve() {
        int pos_r = 0, pos_l = 0;
        int min, max;
        Arrays.sort(pos, 0, n);
//    sort(pos , pos+n);
        if (pos[0] >= l / 2) {
            System.out.printf("%d %d\n", l - pos[0], pos[n - 1]);
            return;
        }
        if (pos[n - 1] < l / 2) {
            System.out.printf("%d %d\n", pos[n - 1], l - pos[0]);
            return;
        }
        for (int i = 0; i < l; i++) {
            if (pos[i] < l / 2 && pos[i + 1] >= l / 2) {
                pos_l = i;
                pos_r = i + 1;
                break;
            }
        }
        min = pos[pos_l] > l - pos[pos_r] ? pos[pos_l] : l - pos[pos_r];
        max = l - pos[0] > pos[n - 1] ? l - pos[0] : pos[n - 1];
        System.out.printf("%d %d\n", min, max);
        
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("10714.txt")));
        t = sc.nextInt();
        while (t-- > 0) {
            l = sc.nextInt();
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                pos[i] = sc.nextInt();
            }
            if (n != 1) {
                solve();
            } else {
                if (pos[0] > l / 2) {
                    System.out.printf("%d %d\n", l - pos[0], pos[0]);
                } else {
                    System.out.printf("%d %d\n", pos[0], l - pos[0]);
                }
            }
        }
    }
}
