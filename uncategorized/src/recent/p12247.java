/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author Masudul Haque
 */
public class p12247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), X = sc
                    .nextInt(), Y = sc.nextInt();
 
            if (A == 0 && B == 0 && C == 0 && X == 0 && Y == 0)
                break;
 
            int[] princess = { A, B, C }, prince = { -1, X, Y };
            Arrays.sort(princess);
            Arrays.sort(prince);
 
            boolean[] cards = new boolean[53];
            cards[A] = true;
            cards[B] = true;
            cards[C] = true;
            cards[X] = true;
            cards[Y] = true;
 
            boolean found = false;
            int value = 0;
            for (int i = 1; i < 53; i++) {
                if (!cards[i]) {
                    prince[0] = i;
                    value = i;
                    Arrays.sort(prince);
                    if (check(prince, princess, new int[3], 0, new boolean[3])) {
                        found = true;
                        break;
                    }
                }
                prince[1] = X;
                prince[2] = Y;
            }
            if (!found) {
                System.out.println("-1");
            } else {
                System.out.println(value);
            }
        }
        sc.close();
    }
 
    private static boolean check(int[] prince, int[] princess, int[] aux,
            int counter, boolean[] bools) {
        if (counter == 3)
            return checkk(aux, princess);
 
        boolean checkBool = true;
        for (int i = 0; i < prince.length; i++) {
            if (!bools[i]) {
                bools[i] = true;
 
                aux[counter] = prince[i];
                checkBool &= check(prince, princess, aux, counter + 1, bools);
 
                bools[i] = false;
            }
        }
        return checkBool;
    }
 
    private static boolean checkk(int[] aux, int[] princess) {
        int cnt1 = 0, cnt2 = 0, i = 0;
        while (i < 3) {
            if (aux[i] < princess[i]) {
                cnt2++;
            } else if (aux[i] > princess[i])
                cnt1++;
            i++;
        }
        return cnt1 > cnt2;
    }
}