/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10008 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("10008.txt")));
        int T = Integer.parseInt(buff.readLine());
        int[] count = new int[26];
        for (int t = 0; t < T; t++) {
            String input = buff.readLine().toUpperCase();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isLetter(ch)) {
                    count[ch - 'A']++;
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            int index = getIndex(count);
            if (count[index] == 0) {
                break;
            }
            System.out.println(((char) (index + 'A')) + " " + count[index]);
            count[index] = 0;
        }
    }

    private static int getIndex(int[] count) {
        int max = count[0];
        int index = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        return index;
    }
}
