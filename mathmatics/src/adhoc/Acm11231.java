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
public class Acm11231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            String[] str = input.split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            if(n==0&& m==0 && c==0){
                break;
            }
            int res = 0;
            if (n > 50) {
                int k = n - 20;
                if (k % 2 != 0) {
                    k--;
                }
                res += (f(m, 0) + f(m, 1)) * (k / 2);
                n -= k;
            }

            while (n >= 8) {
                res += f(m, c);
                c ^= 1;
                n--;
            }
            System.out.printf("%d\n", res);
        }
    }

    private static int f(int m, int c) {
        return (m - 7 + c) / 2;
    }
}
