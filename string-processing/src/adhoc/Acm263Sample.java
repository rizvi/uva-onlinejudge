/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm263Sample {

    private static String getAsc(String num) {
        char no[] = num.toCharArray();
        Arrays.sort(no);
        return String.valueOf(no);
    }

    private static String getDesc(String num) {
        char no[] = num.toCharArray();
        Arrays.sort(no);
        StringBuilder noBuilder= new StringBuilder(String.valueOf(no)).reverse();        
        return noBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb=new StringBuilder("");
        String M = s.nextLine();
        int counter;
        while (true) {
            if ("0".equals(M)) {
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
                N = Integer.parseInt(getDesc(""+P));
                O = Integer.parseInt(getAsc(""+P));
                counter++;
            } while (N - O != P);
            System.out.println("Chain length " + counter);
        }

    }
}