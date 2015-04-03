/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reallife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm11743 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < cases; i++) {
            if (checkSum(br.readLine())) {
                sb.append("Valid\n");
            } else {
                sb.append("Invalid\n");
            }
        }
        System.out.print(sb);
    }

    static boolean checkSum(String x) {
        int sum = 0;
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                temp.append(x.charAt(i));
            }
        }
        StringBuilder str1 = new StringBuilder("");
        StringBuilder str2 = new StringBuilder("");
        for (int i = 0; i < temp.length(); i++) {
            if (i % 2 == 0) {
                str1.append(temp.charAt(i));
            } else {
                str2.append(temp.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < str1.length(); i++) {
            ans.append((int) (str1.charAt(i) - 48) * 2);
        }
        for (int i = 0; i < ans.length(); i++) {
            sum += (int) (ans.charAt(i) - 48);
        }
        for (int i = 0; i < str2.length(); i++) {
            sum += (int) (str2.charAt(i) - 48);
        }
        if (sum % 10 == 0) {
            return true;
        }
        return false;
    }
}