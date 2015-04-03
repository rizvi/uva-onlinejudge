/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm343 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder("");
        while ((input = buff.readLine()) != null) {
            tokenizer = new StringTokenizer(input);
            String first = tokenizer.nextToken().trim();
            String second = tokenizer.nextToken().trim();
            if ("0".equals(first) && "0".equals(second)) {
                sb.append(0).append(" (base ").append(2).append(") = ")
                        .append(0).append(" (base ").append(2).append(")\n");
                continue;
            } else if ("0".equals(first) || "0".equals(second)) {
                sb.append(first).append(" is not equal to ").append(second).append(" in any base 2..36\n");
                continue;
            }

            int firstBase = maxBase(first);
            int secondBase = maxBase(second);
            Boolean found = false;
            int indI = 0, indJ = 0;
            for (int i = firstBase; i < 37; i++) {
                for (int j = secondBase; j < 37; j++) {
                    if (new BigInteger(first, i).compareTo(new BigInteger(second, j)) == 0) {
                        found = true;
                        indI = i;
                        indJ = j;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (indI == 0 && indJ == 0) {
                sb.append(first).append(" is not equal to ").append(second).append(" in any base 2..36\n");
            } else {
                sb.append(first).append(" (base ").append(indI).append(") = ")
                        .append(second).append(" (base ").append(indJ).append(")\n");
            }
        }
        System.out.print(sb);
    }

    private static int maxBase(String input) {
        int base = 0, max = -1;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                base = ch - '0';
            } else {
                base = ch - 55;
            }
            if (base > max) {
                max = base;
            }
        }
        return max + 1;
    }
}
