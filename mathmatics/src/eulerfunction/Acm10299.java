/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerfunction;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * resolve o Relatives 10299 - Relatives
 *
 * @author Jonas Jeske www.inf.ufrgs.br/~jjeske Status: ACCEPTED
 *
 */
public class Acm10299 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        PrintStream saida = new PrintStream(System.out);

        long n = entrada.nextLong();
        while (n != 0) {
            saida.printf("%d\n", resolve(n));
            n = entrada.nextLong();
        }
    }
    /*
     * Sample Input
     7
     12
     0

     Output for Sample Input
     6
     4
     */

    /*
     * implementa a formula de Euler Phi Function
     */
    private static long resolve(long i) {
        long resultado;
        //long j;

        if (i == 1) {
            return 0; //TODO: check this
        }
        resultado = i;

        if (i % 2 == 0) {
            resultado -= resultado / 2;
            while (i % 2 == 0) {
                i /= 2;
            }
        }

        for (long j = 3; j * j <= i; j += 2) {
            if (i % j == 0) {
                resultado -= resultado / j;
                while (i % j == 0) {
                    i /= j;
                }
            }
        }

        if (i > 1) {
            resultado -= resultado / i;
        }
        return resultado;
    }
}