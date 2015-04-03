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
public class Acm11821 {

    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11821.txt")));
        int T = Integer.parseInt(buff.readLine());
        for (int t = 0; t < T; t++) {
            BigDecimal sum = BigDecimal.ZERO;
            String input;
            while (!(input = buff.readLine()).equals("0")) {
                sum = sum.add(new BigDecimal(input));
            }
            int i = new Integer(0);
            char out[] = sum.toString().toCharArray();
            int len;
            for (len = out.length - 1; len > 0 && out[len] == '0'; len--);
            if (len > 0 && out[len] == '.') {
                len--;
            }
            for (i = 0; i <= len; i++) {
                System.out.print(out[i]);
            }
            System.out.println();
        }
    }
}
