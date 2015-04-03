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
public class Acm391 {

    public static void main(String[] args) throws IOException {
        boolean isliteral = false;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = buff.readLine()) != null) {
           int begin = 0;
           int slash = isliteral ? line.indexOf("\\*", begin) : line.indexOf('\\', begin);
            while (slash > -1) {
                System.out.print(line.substring(begin, slash));
                begin = slash + 2;

                if (isliteral) {
                    isliteral = false;
                } else {
                    char ch = line.charAt(slash + 1);
                    switch (ch) {
                        case 'b':
                        case 'i':
                            break;
                        case '*':
                            isliteral = true;
                            break;
                        case 's':
                            begin = slash + 2;
                            while (begin < line.length()) {
                                if (Character.isDigit(line.charAt(begin))) {
                                    begin++;
                                } else {
                                    break;
                                }
                            }
                            if (begin < line.length()) {
                                if (line.charAt(begin) == '.') {
                                    begin++;
                                    while (begin < line.length()) {
                                        if (Character.isDigit(line.charAt(begin))) {
                                            begin++;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.print(ch);
                    }
                }

                slash = isliteral ? line.indexOf("\\*", begin) : line.indexOf('\\', begin);
            }
            if (begin < line.length()) {
                System.out.print(line.substring(begin));
            }
            System.out.println();
        }
    }
}
