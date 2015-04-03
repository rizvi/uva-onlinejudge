/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm11713 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m = "";
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String str1 = br.readLine();
            String str2 = br.readLine();
            if (str1.equals(str2)) {
                sb.append("Yes").append("\n");
            } else if (str1.length() == str2.length()) {
                boolean flag = true;
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) != str2.charAt(j)) {
                        if (!isVowel(str1.charAt(j)) || !isVowel(str1.charAt(j))) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    sb.append("Yes").append("\n");
                } else {
                    sb.append("No").append("\n");
                }
            } else {
                sb.append("No").append("\n");
            }
        }
        System.out.print(sb);
    }

    static Boolean isVowel(char x) {
        if (x == 'a' || x == 'A' || x == 'e' || x == 'E'
                || x == 'i' || x == 'I' || x == 'o' || x == 'O'
                || x == 'u' || x == 'U') {
            return true;
        }
        return false;
    }
}