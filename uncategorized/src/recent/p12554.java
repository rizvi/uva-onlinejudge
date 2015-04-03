/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class p12554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        String[] input = new String[testCase];
        for (int i = 0; i < testCase; i++) {
            input[i] = br.readLine();
        }
        int loop;
        int n = testCase;
        if (n % 16 > 0) {
            loop = n / 16 + 1;
        } else {
            loop = n / 16;
        }

        loop *= 16;

        String str[] = {"Happy", "birthday", "to", "you", "Rujia"};

        int pplIndex = 0;
        int strIndex = 0;
        // "Rujia" will be printed on every 12th of 16th times 
        int cnt = 1;

        for (int i = 0; i < loop; i++) {
            System.out.printf("%s: ", input[pplIndex++]);
            pplIndex %= n;

            if (cnt % 12 == 0) {
                // printing "Rujia" 
                System.out.printf("%s\n", str[4]);
                strIndex = 0;
            } else {
                System.out.printf("%s\n", str[strIndex++]);
                strIndex %= 4;
            }
            cnt++;
            // one full cycle song completed 
            if (cnt > 16) {
                cnt = 1;
            }
        }
    }
}
