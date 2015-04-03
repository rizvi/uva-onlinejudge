/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm573 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        while (true) {
            String[] str = br.readLine().split(" ");
            if (str[0].equals("0")) {
                break;
            }
            double h, u, d, f;
            h = Integer.parseInt(str[0]);
            u = Integer.parseInt(str[1]);
            d = Integer.parseInt(str[2]);
            f = Integer.parseInt(str[3]);
            double start = 0, fact = u * f / 100.0;
            int counter = 0;
            boolean suc = false;
            while (true) {
                ++counter;
                if (counter > 1) {
                    u -= fact;
                }
                if (u >= 0) {
                    start += u;
                }
                if (start > h) {
                    suc = true;
                    break;
                }
                start -= d;
                if (start < 0) {
                    break;
                }
            }
            if (suc) {
                sb.append("success on day ").append(counter).append("\n");
            } else {
                sb.append("failure on day ").append(counter).append("\n");
            }
        }
        System.out.print(sb);
    }
}
