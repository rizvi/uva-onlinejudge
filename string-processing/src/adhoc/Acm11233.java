/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acm11233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        String[] s = new String[n], plurals = new String[n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            s[i] = str[0];
            plurals[i] = str[1];
        }
        Arrays.sort(s);
        Arrays.sort(plurals);
        int q = Integer.parseInt(in[1]);
        for (int i = 0; i < q; i++) {
            String temp = br.readLine();
            int ind = Arrays.binarySearch(s, temp);
            if (ind > -1) {
                sb.append(plurals[ind]).append("\n");
            } else {
                sb.append(makePlural(temp)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static String makePlural(String temp) {
        int l = temp.length();
        if (temp.charAt(l - 1) == 'y') {
            if (temp.charAt(l - 2) != 'a' && temp.charAt(l - 2) != 'i'
                    && temp.charAt(l - 2) != 'e' && temp.charAt(l - 2) != 'o'
                    && temp.charAt(l - 2) != 'u') {
                return temp.substring(0, l - 1) + "ies";
            }
        }
        if (temp.charAt(l - 1) == 'x' || temp.charAt(l - 1) == 'o' || temp.charAt(l - 1) == 's') {
            return temp + "es";
        }
        if (temp.charAt(l - 1) == 'h' && (temp.charAt(l - 2) == 'c' || temp.charAt(l - 2) == 's')) {
            return temp + "es";
        }
        return temp + "s";
    }
}
