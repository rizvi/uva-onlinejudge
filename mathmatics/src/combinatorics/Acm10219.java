/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Acm10219 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(
                System.in));

        String line = "";
        StringBuilder bd = new StringBuilder("");
        while ((line = buff.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bd.append(getComb(n, m).length() + "\n");
        }
        System.out.print(bd);
    }

    private static String getComb(int first, int second) {
        if (second > first - second) {
            second = first - second;
        }

        BigInteger res = BigInteger.ONE;

        for (int i = 0; i < second; i++) {
            res = res.multiply(new BigInteger("" + (first - i)));
            res = res.divide(new BigInteger("" + (1 + i)));
        }
        return res.toString();
    }
}
