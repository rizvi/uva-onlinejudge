/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11063 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cc = 1;
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            HashSet<Integer> v = new HashSet<Integer>();
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            boolean B2 = true;
            int last = 0;
            for (int i = 0; i < a.length && B2; last = a[i++]) {
                B2 = B2 && a[i] > last;
                for (int j = i; j < a.length && B2; j++) {
                    B2 = B2 && !v.contains(a[i] + a[j]);
                    v.add(a[i] + a[j]);
                }
            }
            System.out.println("Case #"+ (cc++)+ ": "+ (B2 ? "It is a B2-Sequence.": "It is not a B2-Sequence.") + "\n");

        }
    }
}
