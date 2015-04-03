/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10683
 * @problemName The decadary watch
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 10/10/2012
 *
 */
import java.io.*;
import static java.lang.Integer.*;

public class Acm10683 {

    static int hundredths(int h, int m, int s, int c) {
        return c + s * 100 + m * 60 * 100 + h * 60 * 60 * 100;
    }

    static long[] decimalTime(int hundredths) {
        long h = (1L * hundredths * (10 * 100 * 100 * 100)) / (24 * 60 * 60 * 100), m, s, c;
        c = h % 100;
        h /= 100;
        s = h % 100;
        h /= 100;
        m = h % 100;
        h /= 100;
        return new long[]{h, m, s, c};
    }

    static String str(long a) {
        return (a < 10 ? "0" : "") + a;
    }

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null;) {
            char[] s = ln.trim().toCharArray();
            int h = parseInt(s[0] + "" + s[1]), 
                    m = parseInt(s[2] + "" + s[3]), 
                    ss = parseInt(s[4] + "" + s[5]), 
                    c = parseInt(s[6] + "" + s[7]);
            long[] res = decimalTime(hundredths(h, m, ss, c));
            sb.append(res[0]);
            sb.append(str(res[1]));
            sb.append(str(res[2]));
            sb.append(str(res[3]));
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}