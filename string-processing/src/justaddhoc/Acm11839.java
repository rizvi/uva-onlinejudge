/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11839 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11839.txt")));
        while (true) {
            int n = Integer.parseInt(buff.readLine());
            if (n == 0) {
                break;
            }
            for (int j = 1; j <= n; j++) {
                int[] a = new int[5];
                int i, k = 0;
                String[] in=buff.readLine().split(" ");
                for (i = 0; i < 5; i++) {
                    a[i] = Integer.parseInt(in[i]);
                }
                for (i = 0; i < 5; i++) {
                    if (a[i] <= 127) {
                        k++;
                    }
                }
                if (k == 0 || k > 1) {
                    System.out.println("*");
                } else {
                    for (i = 0; i < 5; i++) {
                        if (a[i] <= 127) {
                            System.out.printf("%c\n", i + 65);
                            break;
                        }
                    }
                }
            }
        }
    }
}
