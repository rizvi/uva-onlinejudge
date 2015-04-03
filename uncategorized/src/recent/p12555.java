/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 *
 * @author Masudul Haque
 */
public class p12555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF8"));

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            String input = br.readLine();
            int len = input.length();
            int first = 0, second = 0;
           System.out.print("Case "+t+": ");
         
            first = calculateFirst(input);
            if (len >= 4) {
                second = input.charAt(input.length() - 2) - '0';
            }
            double total= first*0.5 + second*0.05;
            BigDecimal d = new BigDecimal(""+total);
            System.out.println(d.stripTrailingZeros());
        }
    }

    private static int calculateFirst(String input) {
        String str = "";
        int res = 0;
        for (int i = 0; i < 2; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                str += ch;
            } else {
                break;
            }
        }
        res = Integer.parseInt(str);
        return res;
    }
}
