/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11958 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("11958.txt")));
        int t, k, h, m, q, best;
        char c;
        t = Integer.parseInt(buff.readLine());

        for (int casenum = 0; casenum < t; casenum++) {
            String[] in = buff.readLine().split(" ");
            k = Integer.parseInt(in[0]);
            String[] time = in[1].split(":");
            h = Integer.parseInt(time[0]);
            m = Integer.parseInt(time[1]);

            best = -1;
            int start = h * 60 + m;

            for (int i = 0; i < k; i++) {
                in = buff.readLine().split(" ");
                time = in[0].split(":");
                h = Integer.parseInt(time[0]);
                m = Integer.parseInt(time[1]);
                q = Integer.parseInt(in[1]);

                int bus = h * 60 + m;
                if (bus < start) {
                    bus += 24 * 60;
                }

                int end = bus + q;

                if (end - start < best || best == -1) {
                    best = end - start;
                }
            }
            System.out.printf("Case %d: %d\n", casenum + 1, best);
        }
    }
}
