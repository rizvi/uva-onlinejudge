/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm740 {

    public static void main(String[] args) {
        Scanner Lee; // para leer los datos de entrada
        char[][] codigo = new char[2][32]; // para los codigos
        String mensajeCod, mensajeRecod; // para recodificar el mensaje
        byte i; // para los bucles
        byte shift; // para saber si es down_shift o up_shift

        // AQUI INICIA EL PROGRAMA
        Lee = new Scanner(System.in);
        // leemos down-shift y up-shift
        codigo[0] = Lee.nextLine().toCharArray();
        codigo[1] = Lee.nextLine().toCharArray();
        while (Lee.hasNextLine()) {
            mensajeCod = Lee.nextLine();
            mensajeRecod = "";
            shift = 0;
            for (i = 0; i < mensajeCod.length(); i += 5) {
                if (Byte.parseByte(mensajeCod.substring(i, i + 5), 2) == 27) {
                    shift = 0;
                } else if (Byte.parseByte(mensajeCod.substring(i, i + 5), 2) == 31) {
                    shift = 1;
                } else {
                    mensajeRecod += (codigo[shift][Byte.parseByte(mensajeCod.substring(i, i + 5), 2)]);
                }
            }
            // mostramos el texto decodificado
            System.out.println(mensajeRecod);
        }
    }
}
