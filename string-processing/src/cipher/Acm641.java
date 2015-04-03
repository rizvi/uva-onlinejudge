/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.util.Scanner;

public class Acm641 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, k, n, pos, val;
        char[] plaincode = new char[80], ciphercode = new char[80];
        String plaintext, ciphertext;
        while (true) {
            k = sc.nextInt();
            if (k == 0) {
                break;
            }
            ciphertext = sc.next();
            n = ciphertext.length();
            for (i = 0; i < n; i++) {
                for (j = 0; j < 26; j++) {
                    if (ciphertext.charAt(i) == 'a' + j) {
                        ciphercode[i] = (char) (j + 1);
                        break;
                    } else if (ciphertext.charAt(i) == '.') {
                        ciphercode[i] = 27;
                        break;
                    } else if (ciphertext.charAt(i) == '_') {
                        ciphercode[i] = 0;
                        break;
                    }
                }
            }
            for (i = 0; i < n; i++) {
                pos = (i * k) % n;
                val = (ciphercode[i] + i) % 28;
                plaincode[pos] = (char) val;
            }
            for (i = 0; i < n; i++) {
                if (plaincode[i] == 27) {
                    System.out.print(".");
                } else if (plaincode[i] == 0) {
                    System.out.print("_");
                } else {
                    System.out.printf("%c", 'a' + plaincode[i] - 1);
                }
            }
            System.out.println();

        }
    }
}
