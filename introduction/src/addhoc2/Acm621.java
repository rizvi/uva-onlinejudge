/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

/**
 *
 * @author Masudul Haque
 */
import java.io.*;
import static java.lang.Integer.*;

public class Acm621 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int N = parseInt(in.readLine().trim()), n = 0; n++ < N;) {
            String str = in.readLine().trim();
            if (str.equals("78") || str.equals("1") || str.equals("4")) {
                System.out.println("+");
            } else if (str.endsWith("35")) {
                System.out.println("-");
            } else if (str.startsWith("9") && str.endsWith("4")) {
                System.out.println("*");
            } else {
                System.out.println("?");
            }
        }
    }
}