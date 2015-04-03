/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class p12545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("12545.txt")));
        int testCase = Integer.parseInt(br.readLine());
        for (int r = 1; r <= testCase; r++) {
            String first = br.readLine();
            String second = br.readLine();
            int l1 = first.length();
            int l2 = second.length();
            if (l1 > l2 || l1 < l2) {
                System.out.printf("Case %d: -1\n", r);
                continue;
            }
            int ws = 0, wt = 0, zs = 0, zt = 0, os = 0, ot = 0, c = 0, d = 0;
            for (int i = 0; i < l1; i++) {
                char s = first.charAt(i);
                char t = second.charAt(i);
                if (s == '?') {
                    ws++;
                }
                if (s == '0') {
                    c++;
                }
                if (s == '1') {
                    d++;
                }
                if (s == '0' && t == '1') {
                    zs++;
                }
                if (s == '1' && t == '0') {
                    os++;
                }
                if (t == '0') {
                    zt++;
                }
                if (t == '1') {
                    ot++;
                }
            }
            if (d > ot) {
                System.out.printf("Case %d: -1\n", r);
            } else {
                System.out.printf("Case %d: %d\n", r, zs + os - Math.min(zs, os) + ws);
            }
        }
    }
}
