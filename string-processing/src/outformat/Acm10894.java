/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package outformat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10894 {

    public static void main(String[] args) throws IOException {
        String[] h = {"*****..***..*...*.*****...*...*.*****.*****.***...*****.*...*",
            "*.....*...*.*...*.*.......*...*.*...*...*...*..*..*...*..*.*.",
            "*****.*****.*...*.***.....*****.*****...*...*...*.*...*...*..",
            "....*.*...*..*.*..*.......*...*.*.*.....*...*..*..*...*...*..",
            "*****.*...*...*...*****...*...*.*..**.*****.***...*****...*.."};

        //initialize for negative number
        String[] v = {"*****",
            "*....",
            "*****",
            "....*",
            "*****",
            ".....",
            ".***.",
            "*...*",
            "*****",
            "*...*",
            "*...*",
            ".....",
            "*...*",
            "*...*",
            "*...*",
            ".*.*.",
            "..*..",
            ".....",
            "*****",
            "*....",
            "***..",
            "*....",
            "*****",
            ".....",
            ".....",
            ".....",
            "*...*",
            "*...*",
            "*****",
            "*...*",
            "*...*",
            ".....",
            "*****",
            "*...*",
            "*****",
            "*.*..",
            "*..**",
            ".....",
            "*****",
            "..*..",
            "..*..",
            "..*..",
            "*****",
            ".....",
            "***..",
            "*..*.",
            "*...*",
            "*..*.",
            "***..",
            ".....",
            "*****",
            "*...*",
            "*...*",
            "*...*",
            "*****",
            ".....",
            "*...*",
            ".*.*.",
            "..*..",
            "..*..",
            "..*.."};
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false, pos;
        int m, i, j, k;
        while (true) {
            int n = Integer.parseInt(buff.readLine());
            if (n == 0) {
                break;
            }
            if (flag) {
                System.out.println("\n");
            }
            flag = true;

            pos = true;
            if (n < 0) {
                pos = false;
                n = Math.abs(n);
            }
            //output for positive number
            if (pos) {
                for (i = 0; i < 5; ++i) {
                    System.out.println(h[i]);
//                    m = 0;
//                    while (m < n) {
//                        for (j = 0; j < h.length; ++j) {
//                            k = 0;
//                            while (k < n) {
//                                System.out.println(h[j]);
//                                ++k;
//                            }
//                        }
//                        ++m;
//                        System.out.println();
//                    }
                }
            } else {
                for (i = 0; i < 61; ++i) {
                    System.out.println(v[i]);
//                    m = 0;
//                    while (m < n) {
//                        for (j = 0; j < v.length; ++j) {
//                            k = 0;
//                            while (k < n) {
//                                System.out.println(v[j]);
//                                ++k;
//                            }
//                        }
//                        ++m;
//                        System.out.println();
//                    }
                }
            }
        }
        System.out.println("\n");
    }
}
