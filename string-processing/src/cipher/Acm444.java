/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm444 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("444.txt")));
        String input;
        while ((input = buff.readLine()) != null) {
            if (input.equals("")) {
                System.out.println();
                continue;
            }
            char first = input.charAt(0);
            StringBuilder out = new StringBuilder("");
            if (Character.isDigit(first)) {
                input = new StringBuilder(input).reverse().toString();
                for (int i = 0; i < input.length();) {
                    StringBuilder temp2 = new StringBuilder("");
                    if (input.charAt(i) == '1') {
                        temp2.append(input.charAt(i)).append(input.charAt(i + 1)).append(input.charAt(i + 2));
                        i += 3;
                    } else {
                        temp2.append(input.charAt(i)).append(input.charAt(i + 1));
                        i += 2;
                    }
                    char c = (char) Integer.parseInt(temp2.toString());
                    out.append((char) c);
                }
            } else {
                for (int i = 0; i < input.length(); i++) {
                    int ch = input.charAt(i);
                    out.append(ch);
                }
                out = out.reverse();
            }
            System.out.println(out);
        }
    }
}
