/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm10375 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        StringTokenizer tokenizer;
        while ((in = buff.readLine()) != null) {
            tokenizer = new StringTokenizer(in);
            int p = Integer.parseInt(tokenizer.nextToken());
            int q = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());

            BigDecimal pq = new BigDecimal(getCom(p, q));
            BigDecimal rs = pq.divide(new BigDecimal(getCom(r, s)),5,RoundingMode.HALF_UP);
            System.out.println(rs);
        }
    }

    private static BigInteger getCom(int m, int n) {
        BigInteger res = BigInteger.ONE;
        // int diff = m > n ? m - n : n - m;
        n = (m - n) > n ? m - n : n;

        for (int i = 0; i < n; i++) {
            res = res.multiply(new BigInteger("" + (m - i)));
            res = res.divide(new BigInteger("" + (i + 1)));
        }
        return res;
    }
}
