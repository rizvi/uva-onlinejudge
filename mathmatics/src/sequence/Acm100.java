/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This class intended to solve the problem of 3n+1 Category Mathmatics and type
 * easy
 *
 * @author Masudul Haque
 */
public class Acm100 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        String input;
        while (scanner.hasNext()) {// Read input until the end of file.
            // it  throws the IOException.
//            String[] in = input.trim().split(" +");// Return array of String respective of space.
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int first = 0, last = 0;
            first = a < b ? a : b;
            last = a > b ? a : b;
            int max = 0;
            for (int n = first; n <= last; n++) {
                int count = getCountByValue(n);
                //Calculate the maximum repeatation.
                if (max < count) {
                    max = count;
                }
            }
            System.out.printf("%d %d %d\n", a, b, max);
        }
    }

    private static int getCountByValue(int value) {
        int count = 1; // Count is initialized to 1 for value 1
        while (value != 1) { //Loop to value util it return to 1
            if (value % 2 == 0) {//If value divide by 2
                value = value / 2;// Divide it by 2
            } else {
                value = 3 * value + 1; // Otherwise 3n+1
            }
            count++;  // Count each repeatation.
        }
        return count;
    }
}
