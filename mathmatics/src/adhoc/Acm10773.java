/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10773 {

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        double d, v, u;
        double minTime = 0.0;
        double minDis = 0.0;
        for (int t = 1; t <= T; t++) {
            String[] S = br.readLine().split(" ");
            d = Double.parseDouble(S[0]);
            v = Double.parseDouble(S[1]);
            u = Double.parseDouble(S[2]);
            if (v >= u) {
                System.out.println("Case " + t + ": can't determine");
            } else {
                minTime = d / u;
                minDis = d / Math.sqrt(u * u - v * v);
                if (minTime == minDis) {
                    System.out.println("Case " + t + ": can't determine");
                } else {
                    System.out.printf("Case %d: %.3f\n", t,
                            Math.abs(minDis - minTime));
                }
            }
        }
    }
}
