/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm537 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("537.txt")));
        char[] unidades = new char[]{'U', 'I', 'P'};
        int T = Integer.parseInt(buff.readLine());
        for (int t = 1; t <= T; t++) {
            String input = buff.readLine();
            String[] s = input.split("=");
            char firstSymbol = s[0].charAt(s[0].length() - 1);
            char secondSymbol = s[1].charAt(s[1].length() - 1);
            String firstValue = s[1].split(" ")[0];
            String secondValue = s[2].split(" ")[0];
            double a = getNum(firstValue.toCharArray());
            double b = getNum(secondValue.toCharArray());
            Double[] val = new Double[3];
            for (int i = 0; i < 3; i++) {
                if (unidades[i] == firstSymbol) {
                    val[i] = a;
                }
                if (unidades[i] == secondSymbol) {
                    val[i] = b;
                }
            }
            System.out.println("Problem #"+t);
            if(val[2]==null){
                System.out.printf("P=%.2fW\n",val[0]*val[1]);
            }
            else if(val[0]==null){
                System.out.printf("U=%.2fV\n",val[2]/val[1]);
            }
            else if(val[1]==null){
                System.out.printf("I=%.2fA\n",val[2]/val[0]);
            }
               System.out.println();
        }
    }

    static double getNum(char[] s) {
        int i = 0;
        String n = "";
        for (; s[i] == '.' || Character.isDigit(s[i]); i++) {
            n += s[i];
        }
        if (s[i] == 'm') {
            return Double.parseDouble(n) / 1000;
        }
        if (s[i] == 'k') {
            return Double.parseDouble(n) * 1000;
        }
        if (s[i] == 'M') {
            return Double.parseDouble(n) * 1000000;
        }
        return Double.parseDouble(n);
    }
}
