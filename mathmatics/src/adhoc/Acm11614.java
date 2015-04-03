/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm11614 {

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            long n = Long.parseLong(br.readLine());
            long res = (long) (Math.sqrt(1 + 8 * n) - 1) / 2;
            System.out.println(res);
        }
    }
}
