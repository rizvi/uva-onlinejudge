/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char m = ' ';
        StringBuilder temp = new StringBuilder("");
        StringBuffer sb = new StringBuffer("");
        boolean first = true, flag = true;
        char last = ' ';
        while (flag) {
            if (!first) {
                sb.append("\n");
            }
            first = false;
            int[] arr = new int[31];
            while (true) {
                m = (char) br.read();
                int lol = m;
                if (lol == 65535) {
                    flag = false;
                    break;
                }
                if ((m >= 'a' && m <= 'z') || (m >= 'A' && m <= 'Z')) {
                    temp.append(m);
                    last = m;
                } else if (m == '-' || m == '\'') {
                    last = m;
                    continue;
                } else if (m == '#') {
                    for (int i = 1; i < arr.length; i++) {
                        if (arr[i] > 0) {
                            sb.append(i).append(" ").append(arr[i]).append("\n");
                        }
                    }
                    break;
                } else {
                    if (last != '-') {
                        arr[temp.length()]++;
                        temp = new StringBuilder("");
                    } else {
                        last = ' ';
                    }
                }
            }
        }
        System.out.print(sb);
    }
}