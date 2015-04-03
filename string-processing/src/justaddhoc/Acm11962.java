/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11962 {

    public static void main(String[] args) throws IOException {


        long[] numsOfCombination = new long[35];
        numsOfCombination[0] = 1;

        for (int i = 1; i <= 30; i++) {
            numsOfCombination[i] = numsOfCombination[i - 1] * 4;
        }

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11962.txt")));
        int testCase = Integer.parseInt(buff.readLine());
        int cases = 0;
        while (testCase-- > 0) {
            String ch = buff.readLine();
            int len = ch.length();
            long res = 0;

            for (int i = 0; i < len; i++) {
                if (ch.charAt(len - 1 - i) > 'A') {
                    res += numsOfCombination[i];
                }
                if (ch.charAt(len - 1 - i) > 'C') {
                    res += numsOfCombination[i];
                }
                if (ch.charAt(len - 1 - i) > 'G') {
                    res += numsOfCombination[i];
                }
                if (ch.charAt(len - 1 - i) > 'T') {
                    res += numsOfCombination[i];
                }
            }

            System.out.printf("Case %d: (%d:%d)\n", ++cases, len, res);
        }
    }
}
