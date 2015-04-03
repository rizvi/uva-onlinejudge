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
public class Acm11278 {

    public static void main(String[] args) throws IOException {

        char qwerty[] = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./".toCharArray();
        char QWERTY[] = "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?".toCharArray();
        char right_down[] = "`123qjlmfp/[]456.orsuyb;=\\789aehtdck-0zx,inwvg'".toCharArray();
        char right_up[] = "~!@#QJLMFP?{}$%^>ORSUYB:+|&*(AEHTDCK_)ZX<INWVG\"".toCharArray();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;//[10000];
        int i, j, k, flag;
        while ((input = buff.readLine()) != null) {

            for (i = 0; i < input.length(); i++) {
                flag = 0;
                for (j = 0; j < qwerty.length; j++) {
                    if (input.charAt(i) == qwerty[j]) {
                        System.out.printf("%c", right_down[j]);
                        flag = 1;
                        break;
                    }
                    if (input.charAt(i) == QWERTY[j]) {
                        flag = 1;
                        System.out.printf("%c", right_up[j]);
                        break;
                    }
                }
                if (flag == 0) {
                    System.out.printf("%c", input.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
