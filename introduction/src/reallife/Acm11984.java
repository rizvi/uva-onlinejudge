/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reallife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11984 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buff.readLine());
        double c, f;
        for (int i = 1; i <= t; i++) {
            String[] in = buff.readLine().split(" ");
            c = Double.parseDouble(in[0]);
            f = Double.parseDouble(in[1]);

            double tmp = 9.0 * c / 5.0 + 32.0;
            tmp += f;

            c = (tmp - 32) * 5 / 9.0;
            System.out.printf("Case %d: %.2f\n", i, c);
        }
    }
}
