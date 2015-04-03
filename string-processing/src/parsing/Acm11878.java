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
public class Acm11878 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        String input;
        while ((input = buff.readLine()) != null) {
            char test = input.charAt(input.length() - 1);
            if (test != '?') {
                String[] temp = input.split("=");
                if (temp[1].equals(eval(temp[0]))) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static String eval(String equation) {
        int solution = 0;
        String[] eq;
        eq = equation.split("[-+]+");

        if (equation.contains("-")) {
            solution = Integer.parseInt(eq[0]) - Integer.parseInt(eq[1]);
        } else if (equation.contains("+")) {
            solution = Integer.parseInt(eq[0]) + Integer.parseInt(eq[1]);
        }

        return String.valueOf(solution);
    }
}
