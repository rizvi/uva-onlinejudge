/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;

/**
 *
 * @author Masudul Haque
 */
import java.io.*;
import java.util.*;

public class Acm10361 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        for (int c = 0, C = Integer.parseInt(in.readLine().trim()); c < C; c++) {
            String l1 = in.readLine();
            char[] cad = l1.toCharArray();
            String l2 = in.readLine();
            String arr[] = new String[5];
            Arrays.fill(arr, "");
            for (int i = 0, j = 0; i < cad.length; i++) {
                if (cad[i] == '<' || cad[i] == '>') {
                    j++;
                } else {
                    arr[j] += cad[i];
                }
            }
            sb.append(l1.replaceAll("[<>]", "") + "\n");
            sb.append(l2.replace("...", arr[3] + arr[2] + arr[1] + arr[4]) + "\n");
        }
        System.out.print(sb);
    }
}
