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
public class Acm739 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("739.txt")));
        StringBuilder sb = new StringBuilder("");
        int i, j, k, l, count, s;
        String name;
        sb.append("         ").append("NAME").append("                     ");
        sb.append("SOUNDEX CODE\n");
        while ((name = buff.readLine()) != null) {
            sb.append("         ").append(name);
            for (s = 0; s < (35 - 9 - name.length() - 1); s++) {
                sb.append(" ");
            }
            sb.append(name.charAt(0));
            count = 0;
            for (i = 1; i < name.length(); i++) {
                if (count > 2) {
                    break;
                }
                char ch = name.charAt(i);
                char ch2 = name.charAt(i - 1);
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y' || ch == 'W' || ch == 'H') {
                } else {
                    if (ch == 'B' || ch == 'P' || ch == 'F' || ch == 'V') {
                        if (name.charAt(i - 1) == 'B' || name.charAt(i - 1) == 'P' || name.charAt(i - 1) == 'F' || name.charAt(i - 1) == 'V') {
                        } else {
                            count++;
                            sb.append(1);
                        }
                    } else if (ch == 'C' || ch == 'S' || ch == 'K' || ch == 'G' || ch == 'J' || ch == 'Q' || ch == 'X' || ch == 'Z') {
                        if (ch2 == 'C' || ch2 == 'S' || ch2 == 'K' || ch2 == 'G' || ch2 == 'J' || ch2 == 'Q' || ch2 == 'X' || ch2 == 'Z') {
                        } else {
                            count++;
                            sb.append(2);
                        }

                    } else if (ch == 'D' || ch == 'T') {
                        if (ch2 == 'D' || ch2 == 'T') {
                        } else {
                            count++;
                            sb.append(3);
                        }

                    } else if (ch == 'L') {
                        if (ch2 == 'L') {
                        } else {
                            count++;
                            sb.append(4);
                        }
                    } else if (ch == 'M' || ch == 'N') {
                        if (ch2 == 'M' || ch2 == 'N') {
                        } else {
                            count++;
                            sb.append(5);
                        }

                    } else if (ch == 'R') {
                        if (ch2 == 'R') {
                        } else {
                            count++;
                            sb.append(6);
                        }
                    }
                }
            }
            for (l = count; l < 3; l++) {
                sb.append(0);
            }
            sb.append("\n");
        }
        sb.append("                   ");
        sb.append("END OF OUTPUT\n");
        System.out.print(sb);
    }
}
