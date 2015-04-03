/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm271 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = buff.readLine()) != null) {
            if(check(input)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

    static boolean check(String s) {
        int i, len = s.length(), sum = 0;
        for (i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    sum++;
                    break;
                case 'N':
                    if (sum < 1) {
                        return false;
                    }
                    break;
                case 'C':
                case 'D':
                case 'E':
                case 'I':
                    if (sum < 2) {
                        return false;
                    }
                    sum--;
                    break;
                default:
                    return false;
            }
        }
        return (sum == 1);
    }
}
