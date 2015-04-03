/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm11203 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        int cases = Integer.parseInt(br.readLine());
        for (int i = 1; i < cases + 1; i++) {
            if (ax(br.readLine().trim())) {
                sb.append("theorem\n");
            } else {
                sb.append("no-theorem\n");
            }
        }
        System.out.print(sb);
    }

    static boolean ax(String x) {
        boolean flagM = false, flagE = false;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '?' || x.charAt(i) == 'M' || x.charAt(i) == 'E') {
                if (x.charAt(i) == 'M') {
                    if (flagE) {
                        return false;
                    }
                    if (flagM) {
                        return false;
                    }
                    flagM = true;
                }
                if (x.charAt(i) == 'E') {
                    if (flagE) {
                        return false;
                    }
                    flagE = true;
                }
            } else {
                return false;
            }
        }
        int count[] = new int[3];
        for (int i = 0, ind = 0; i < x.length(); i++) {
            if (x.charAt(i) == 'M' || x.charAt(i) == 'E') {
                ind++;
                continue;
            }
            count[ind]++;
        }
        if (count[0] == 0 || count[1] == 0) {
            return false;
        }
        return (count[2] == count[1] + count[0]);
    }
}