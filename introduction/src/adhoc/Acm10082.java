/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10082 {

    public static char[] restore = new char[127];
    public static char[] cinbuf = new char[256];

    public static String restore(String typing) {
        int i;
        char[] chs = typing.toCharArray();
        char[] result = new char[chs.length];

        for (i = 0; i < chs.length; i++) {
            result[i] = chs[i] == ' ' ? ' ' : restore[chs[i]];
        }

        return new String(result);
    }

    public static void main(String[] args) {
        int i;
        char[] line1 = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='};
        char[] line2 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'};
        char[] line3 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\''};
        char[] line4 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};
        for (i = 1; i < line1.length; i++) {
            restore[line1[i]] = line1[i - 1];
        }
        for (i = 1; i < line2.length; i++) {
            restore[line2[i]] = line2[i - 1];
        }
        for (i = 1; i < line3.length; i++) {
            restore[line3[i]] = line3[i - 1];
        }
        for (i = 1; i < line4.length; i++) {
            restore[line4[i]] = line4[i - 1];
        }
         Scanner sc = new Scanner(System.in);
       // Scanner sc = new Scanner(new FileInputStream(new File("10082.txt")));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(restore(line));
        }
    }
}
