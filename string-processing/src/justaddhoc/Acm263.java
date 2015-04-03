/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;

/**
 * Number Chains Algorithm 1. Get a number (M) as an integer number 2. Check M
 * value If M is a positive number greater than 0 then do next step , if M=0
 * then terminate the program , otherwise just re input M 3. Set N by get a
 * descending value of M 4. Set O by an ascending value of M 5. Set P=N – O 6.
 * Set counter=1 7. Print M as original number 8. Do step 9 until 13 while N – O
 * is not same P ( I use Do … While ) , otherwise jump to step 14 9. Print
 * number chain ( N – O = P ) 10. Set P =N – O 11. Set N by get a descending
 * value of P 12. Set O by get an ascending value of P 13. Increase the counter
 * by 1 14. Print the counter as chain length 15. Back to step 1 for the next
 * input until EOF
 *
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Acm263 {

    static String getAsc(int num) {
        char no[] = String.valueOf(num).toCharArray();
        Arrays.sort(no);
        return String.valueOf(no, 0, no.length);
    }

    static String getDesc(int num) {
        char temp;
        char no[] = String.valueOf(num).toCharArray();
        for (int i = 0; i < (no.length) - 1; i++) {
            for (int j = 0; j < (no.length) - 1 - i; j++) {
                if (no[j] < no[j + 1]) {
                    temp = no[j];
                    no[j] = no[j + 1];
                    no[j + 1] = temp;
                }
            }
        }
//        Arrays.sort(no,Collections.reverseOrder());
        return String.valueOf(no, 0, no.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);
        int counter;
        while (true) {
            int M = Integer.parseInt(buff.readLine());
            if (M == 0) {
                break;
            }

            int N = Integer.parseInt(getDesc(M));
            int O = Integer.parseInt(getAsc(M));
            counter = 1;
            System.out.println("Original number was " + M);
            int P = N - O;
            do {
                System.out.println(N + " - " + O + " = " + (N - O));
                P = N - O;
                N = Integer.parseInt(getDesc(P));
                O = Integer.parseInt(getAsc(P));
                counter++;
            } while (N - O != P);
            System.out.println("Chain length " + counter);
        }
    }
}