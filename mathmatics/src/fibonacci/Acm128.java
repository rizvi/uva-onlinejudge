/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class Acm128 {

    public static char[] hexdigit = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String parseHex(int value) {
        int digit;
        char[] chs = new char[5];
        chs[2] = ' ';
        digit = (value & 0xF000) >> 12;
        chs[0] = hexdigit[digit];
        digit = (value & 0xF00) >> 8;
        chs[1] = hexdigit[digit];
        digit = (value & 0xF0) >> 4;
        chs[3] = hexdigit[digit];
        digit = (value & 0xF);
        chs[4] = hexdigit[digit];
        return new String(chs);
    }

    public static void main(String[] args) throws IOException {
        int crc;
        BigInteger bint;
        BigInteger bdiv = new BigInteger("34943");
        StringBuffer sbuf = new StringBuffer();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = buff.readLine()).equals("#")) {
            if (input.length() > 0) {
                bint = new BigInteger(input);
                bint = bint.shiftLeft(16);
                crc = 34943 - bint.mod(bdiv).intValue();
                sbuf.append(parseHex(crc)).append('\n');
            } else {
                sbuf.append("00 00\n");
            }

        }
        System.out.print(sbuf);
    }
}
