/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11942 {

    public static void main(String[] args) throws IOException {
      BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11942.txt")));
        int T = Integer.parseInt(buff.readLine().trim());
        System.out.println("Lumberjacks:");
        for (int t = 0; t < T; t++) {
            String[] input = buff.readLine().split(" ");
            boolean dsc = true, asc = true;
            int last = Integer.parseInt(input[0]);
            int x;
            for (int i = 1; i < input.length; i++) {
                 x = Integer.parseInt(input[i]);
                if (x > last) {
                    dsc = false;
                } else if (x < last) {
                    asc = false;
                }
                last = x;
            }
            if (asc || dsc) {
                System.out.println("Ordered");
            } else {
                System.out.println("Unordered");
            }

        }
    }
}
