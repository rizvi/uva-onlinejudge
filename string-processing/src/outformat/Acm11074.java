/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package outformat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11074 {

    static void drawing_line(int s, int t, int n,StringBuilder sb) {
        int length = (s * n) + ((n + 1) * t);

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < length; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
    }

    static void grid(int s, int t, int n,StringBuilder sb) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < t; k++) {
                    sb.append("*");
                }
                for (int k = 0; k < s; k++) {
                    sb.append(".");
                }
            }
            for (int k = 0; k < t; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder("");
        int cases = 0;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11074.txt")));
        while (true) {
            String[] input = buff.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);
            if (s == 0 && t == 0 && n == 0) {
                break;
            }
            sb.append("Case ").append(++cases).append(":\n");
            for (int i = 0; i < n; i++) {
                drawing_line(s, t, n,sb);
                grid(s, t, n,sb);
            }
            drawing_line(s, t, n,sb);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
