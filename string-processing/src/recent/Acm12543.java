/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm12543 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("12543.txt")));
        int max = 0;
        String res = "";
        String input;
        while ((input = buff.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (token.equals("E-N-D")) {
                    break;
                }
                int count = 0;
                StringBuilder word=new StringBuilder();
                for (int i = 0; i < token.length(); i++) {
                    char ch=token.charAt(i);
                    if (Character.isLetter(ch) || ch == '-') {
                        word.append(ch);
                        count++;
                    }
                }
                if (max < count) {
                    max = count;
                    res = word.toString();
                }
            }
        }
        System.out.println(res.toLowerCase());
    }
}
