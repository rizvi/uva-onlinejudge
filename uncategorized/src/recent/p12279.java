/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p12279 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("12279.txt")));
        int c = 0;
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            int  c1 = 0, c2 = 0;
            int[] arr = new int[N];
            for (int i = 0; i < N; ++i) {
                arr[i] = sc.nextInt();
                if (arr[i] == 0) {
                    c2++;
                } else {
                    c1++;
                }
            }
            System.out.printf("Case %d: %d\n",++c, c1 - c2);
        }
    }
}
