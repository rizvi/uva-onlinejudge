/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class Acm10070 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln, s = ""; (ln = in.readLine()) != null;) {
            if (!s.equals("")) {
                sb.append("\n");
            }
            s = " ";
            BigInteger a = new BigInteger(ln);
            boolean ws = false;
            if (a.mod(BigInteger.valueOf(400)).equals(BigInteger.ZERO) || (a.mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO) && !a.mod(BigInteger.valueOf(100)).equals(BigInteger.ZERO))) {
                ws = true;
                sb.append("This is leap year.\n");
            }
            if (a.mod(BigInteger.valueOf(15)).equals(BigInteger.ZERO)) {
                ws = true;
                sb.append("This is huluculu festival year.\n");
            }
            if ((a.mod(BigInteger.valueOf(400)).equals(BigInteger.ZERO) || (a.mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO) && !a.mod(BigInteger.valueOf(100)).equals(BigInteger.ZERO))) && a.mod(BigInteger.valueOf(55)).equals(BigInteger.ZERO)) {
                ws = true;
                sb.append("This is bulukulu festival year.\n");
            }
            if (!ws) {
                sb.append("This is an ordinary year.\n");
            }
        }
        System.out.print(new String(sb));
    }
}
