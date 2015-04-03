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
public class Acm355 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder("");
        while ((input = buff.readLine()) != null) {
            tokenizer = new StringTokenizer(input);
            int firstBase = Integer.parseInt(tokenizer.nextToken());
            int resBase = Integer.parseInt(tokenizer.nextToken());
            String firstValue = tokenizer.nextToken();

            try {
                BigInteger firsToDec = new BigInteger(firstValue, firstBase);
                String res = firsToDec.toString(resBase);
               sb.append(firstValue).append(" base ").append(firstBase).append(" = ").append(res.toUpperCase()).append(" base ").append(resBase).append("\n");
            } catch (Exception ex) {
                 sb.append(firstValue).append(" is an illegal base ").append(firstBase).append(" number\n");
            }
        }
        System.out.print(sb);
    }
}
