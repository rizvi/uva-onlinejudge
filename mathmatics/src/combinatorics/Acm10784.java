/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;
/**
 *
 * @author Masudul Haque
 */
import java.util.Scanner;

public class Acm10784 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCase = 1;
        //StringBuilder out = new StringBuilder("");
        while (true) {
            long N = sc.nextLong();
            if (N == 0) {
                break;
            }

            double det = 9 + 8 * N;
            long first = (long) Math.ceil((3 + Math.sqrt(det)) / 2);
            long second = (long) Math.ceil((3 - Math.sqrt(det)) / 2);
            String pre = "Case " + (nCase++) + ": ";
            if (first > 0 && second > 0) {
                System.out.println(pre + Math.min(first, second));

            } else if (first > 0) {
                System.out.println(pre + first);
            } else {
                System.out.println(pre + second);
            }
        }
    }
}
