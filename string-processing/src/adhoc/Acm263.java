/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Number Chain
 *
 * @author Masudul Haque
 */
public class Acm263 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder("");
        while (true) {
            String input = sc.nextLine();
            if ("0".equals(input)) {
                break;
            }
            output.append("Original number was ").append(input).append("\n");
            char[] inputChar = input.toCharArray();
            Arrays.sort(inputChar);
            StringBuilder sortStr = new StringBuilder(new String(inputChar));
            int acending = Integer.parseInt(sortStr.toString());
            int decending = Integer.parseInt(sortStr.reverse().toString());
            int res = decending - acending;
            int count=2;
            output.append(decending).append(" - ").append(acending).append(" = ").append(res).append("\n");
            while ((decending-acending) != res) {
                inputChar= (""+res).toCharArray();
                Arrays.sort(inputChar);
                sortStr = new StringBuilder(new String(inputChar));
                acending = Integer.parseInt(sortStr.toString());
                decending = Integer.parseInt(sortStr.reverse().toString());
                res = decending - acending;
                output.append(decending).append(" - ").append(acending).append(" = ").append(res).append("\n");
                output.append("Chain length ").append(count).append("\n");
                count++;
            }
            System.out.print(output);
        }
    }
}
