/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11530 {

    public static void main(String[] args) throws Throwable {
        int[] arr = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4, 1};
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int c = 0, C = Integer.parseInt(in.readLine().trim()); c < C; c++) {
            char ln[] = in.readLine().toCharArray();
            int res = 0;
            for (char ch : ln) {
                res += ch == ' ' ? arr[arr.length - 1] : arr[ch - 'a'];
            }
            System.out.println("Case #" + (c + 1) + ": " + res);
        }
    }
}
