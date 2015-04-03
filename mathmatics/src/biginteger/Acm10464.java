/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 *
 * @author Masudul Haque
 */
public class Acm10464 {

    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("10464.txt")));
        int T = Integer.parseInt(buff.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = buff.readLine().split(" ");
            BigDecimal x = new BigDecimal(input[0]);
            BigDecimal y = new BigDecimal(input[1]);
            x = x.add(y);
            String resStr = x.toString();
            if (resStr.indexOf('.') == -1) {
                resStr += ".0";
            } else {
                int n = resStr.length() - 1;
                while (resStr.charAt(n) == '0') {
                    n--;
                }
                if (resStr.charAt(n) == '.') {
                    resStr = resStr.substring(0, n + 1) + "0";
                } else {
                    resStr = resStr.substring(0, n + 1);
                }
            }
            System.out.println(resStr);
        }
    }
}
