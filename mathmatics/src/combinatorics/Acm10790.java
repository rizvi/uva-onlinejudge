/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10790 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        int i = 1;
        while (true) {
            String[] str = br.readLine().split(" ");
            long x = Integer.parseInt(str[0]);
            long y = Integer.parseInt(str[1]);
            if (x == 0 && y == 0) {
                break;
            }
            sb.append("Case ").append(i).append(": ");
            sb.append(x * y * (y - 1) * (x - 1) / 4).append("\n");
            i++;
        }
        System.out.print(sb);
    }
}