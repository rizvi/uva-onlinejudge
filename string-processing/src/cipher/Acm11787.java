/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11787 {

    public static void main(String[] args) throws IOException {
        int[] ar = new int[10000];
        int  i, j, k;
        int B, U, S, P, F, T, M, flag, a, b, temp, ascend, descend;
        long sum = 0, count;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11787.txt")));
       int test = Integer.parseInt(buff.readLine());
        for (i = 0; i < test; i++) {

            B = 0;
            U = 0;
            S = 0;
            P = 0;
            F = 0;
            T = 0;
            M = 0;
            flag = 1;
            String input = buff.readLine();
            for (j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == 'B') {
                    B++;
                    ar[j] = 1;
                } else if (ch == 'U') {
                    U++;
                    ar[j] = 2;
                } else if (ch == 'S') {
                    S++;
                    ar[j] = 3;
                } else if (ch == 'P') {
                    P++;
                    ar[j] = 4;
                } else if (ch == 'F') {
                    F++;
                    ar[j] = 5;
                } else if (ch == 'T') {
                    T++;
                    ar[j] = 6;
                } else if (ch == 'M') {
                    M++;
                    ar[j] = 7;
                }

            }
            if (B > 9 || U > 9 || S > 9 || P > 9 || F > 9 || T > 9 || M > 9) {
                flag = 0;

            } else {
                ascend = 1;
                for (a = 1; a < input.length(); ++a) {
                    for (b = input.length() - 1; b >= a; --b) {
                        if (ar[b - 1] > ar[b]) {
                            ascend = 0;

                            break;
                        }

                    }

                }

                descend = 1;
                for (a = 1; a < input.length(); ++a) {
                    for (b = input.length() - 1; b >= a; --b) {
                        if (ar[b - 1] < ar[b]) {
                            descend = 0;

                            break;
                        }

                    }

                }

                if (ascend == 0 && descend == 0) {
                    flag = 0;


                } else {

                    sum = 0;
                    for (j = 0; j < input.length(); j++) {
                        char ch = input.charAt(j);
                        if (ch == 'B') {
                            sum = sum + 1;
                        } else if (ch == 'U') {
                            sum = sum + 10;
                        } else if (ch == 'S') {
                            sum = sum + 100;
                        } else if (ch == 'P') {
                            sum = sum + 1000;
                        } else if (ch == 'F') {
                            sum = sum + 10000;
                        } else if (ch == 'T') {
                            sum = sum + 100000;
                        } else if (ch == 'M') {
                            sum = sum + 1000000;
                        }
                    }
                }
            }
            if (flag == 0) {
                System.out.println("error");
            } else if (flag == 1) {
                System.out.println(sum);
            }
        }
    }
}
