/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11332 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = buff.readLine();
            if ("0".equals(input)) {
                break;
            }
            
            while (input.length() != 1) {
                int sum = 0;
                for (int i = 0; i < input.length(); i++) {
                    char ch=input.charAt(i);
                    sum+=ch-'0';
                }
                input=""+sum;
            }
            System.out.println(input);
        }
    }
}
