/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm12136 {

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            String[] S = s.split(" ");
            String[] value = S[0].split(":");
            int firstH = Integer.parseInt(value[0]);
            firstH *= 60;
            firstH += Integer.parseInt(value[1]);
            String[] valu = S[1].split(":");
            int secondH = Integer.parseInt(valu[0]);
            secondH *= 60;
            secondH += Integer.parseInt(valu[1]);
            boolean[] time = new boolean[1441];
            for (int j = firstH; j <= secondH; j++) {
                time[j] = true;
            }
            s = br.readLine();
            S = s.split(" ");
            value = S[0].split(":");
            firstH = Integer.parseInt(value[0]);
            firstH *= 60;
            firstH += Integer.parseInt(value[1]);
            valu = S[1].split(":");
            secondH = Integer.parseInt(valu[0]);
            secondH *= 60;
            secondH += Integer.parseInt(valu[1]);
            boolean flag = true;
            for (int j = firstH; j <= secondH; j++) {
                if (time[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Case " + i + ": Hits Meeting");
            } else {
                System.out.println("Case " + i + ": Mrs Meeting");
            }
        }
    }
}
