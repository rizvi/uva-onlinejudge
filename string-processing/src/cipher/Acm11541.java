/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11541 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buff.readLine());
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder("");
            String input = buff.readLine();

            String res = "0";
            char letter = input.charAt(0);
            boolean isLetter = true;
            int digit = 0;
            for (int i = 1; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isDigit(ch)) {
                    res += ch;
                } else{
                    digit = Integer.parseInt(res);
                    for (int j = 0; j < digit; j++) {
                        sb.append(letter);
                    }
                    letter=ch;
                    res = "0";
                }
            }
            if (!"0".equals(res)) {
                digit = Integer.parseInt(res);
                for (int j = 0; j < digit; j++) {
                    sb.append(letter);
                }
            }
            System.out.printf("Case %d: %s\n", t, sb);
        }
    }
}
