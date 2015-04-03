/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11313 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Ans = 0;
            while (n > 0) {
                n = n - m;
                Ans++;
                if (n <= 0) {
                    break;
                }
                n++;
            }
            if (n == 0) {
                System.out.printf("%d\n", Ans);
            } else {
                System.out.printf("cannot do this\n");
            }
        }
    }
}
