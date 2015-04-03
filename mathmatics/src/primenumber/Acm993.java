/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

/**
 *
 * @author Masudul Haque
 */
import java.io.InputStreamReader;
import java.util.Scanner;

public class Acm993 {

    public static void main(String[] args) {
        Scanner br = new Scanner(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        int cases = br.nextInt();
        for (int i = 0; i < cases; i++) {
            int x = br.nextInt();
            if (x == 0) {
                sb.append("10\n");
                continue;
            }
            int temp = x;
            boolean ok = true;
            StringBuilder str = new StringBuilder("");
            while (temp > 9) {
                int last = temp;
                for (int j = 9; j > 1; j--) {
                    if (temp % j == 0) {
                        str.append(j);
                        temp /= j;
                        break;
                    }
                }
                if (temp == last) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                sb.append(temp).append(str.reverse()).append("\n");
            } else {
                sb.append("-1\n");
            }
        }
        System.out.print(sb);
    }
}