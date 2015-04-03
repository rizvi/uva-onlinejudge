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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Masudul Haque
 */
public class Acm865 {

    public static void main(String[] args) throws IOException {
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("865.txt")));
        int T = Integer.parseInt(buff.readLine());
        for (int t = 0; t < T; t++) {
            charMap.clear();
            if (t == 0) {
                buff.readLine();
            }
            String plainText = buff.readLine();
            String subsText = buff.readLine();
            System.out.println(subsText);
            System.out.println(plainText);
            for (int i = 0; i < plainText.length(); i++) {
                charMap.put(plainText.charAt(i), subsText.charAt(i));
            }
            String input;
            while (true) {
                input = buff.readLine();
                if (input == null || input.isEmpty()) {
                    break;
                }
                StringBuilder output = new StringBuilder("");
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    if (charMap.containsKey(ch)) {
                        output.append(charMap.get(ch));
                    } else {
                        output.append(ch);
                    }
                }
                System.out.println(output);
            }
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
