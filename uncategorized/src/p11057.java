/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Masud
 */
public class p11057 {

    public static void main(String[] args) throws IOException {
//        Scanner sc=new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int money = sc.nextInt();
            int x = -1;
            int y = -1;
            for (int i = 0; i < N; i++) {
                int req = money - a[i];
                int res = Arrays.binarySearch(a, i + 1, N, req);
                if (res >= 0 && (a[res] - a[i] < y - x || (x == -1 && y == -1))) {
                    x = a[i];
                    y = a[res];
                }
            }
            System.out.printf("Peter should buy books whose prices are %d and %d.\n\n",x, y);
        }
    }
}
