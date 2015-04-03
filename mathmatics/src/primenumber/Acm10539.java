/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 10539
 * @problemName Almost Prime Numbers
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 11/07/2012
 *
 */
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;

public class Acm10539 {

    public static void main(String args[]) throws Throwable {
        boolean[] primes = new boolean[1000000];
        primes[0] = primes[1] = true;
        long res[] = new long[80070];
        int c = 0;
        for (int i = 0; i < primes.length; i++) {
            if (!primes[i]) {
                for (long j = 1L * i * i; j <= 1L * primes.length * primes.length; j *= i) {
                    res[c++] = j;
                }
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = true;
                }
            }
        }
        Arrays.sort(res);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int T = parseInt(in.readLine().trim()), t = 0; t++ < T;) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int low = Arrays.binarySearch(res, Long.parseLong(st.nextToken())), 
                high = Arrays.binarySearch(res, Long.parseLong(st.nextToken()));
            if (low < 0) {
                low = -low - 1;
            }
            if (high < 0) {
                high = -high - 2;
            }
            System.out.println(high - low + 1);
        }
    }
}