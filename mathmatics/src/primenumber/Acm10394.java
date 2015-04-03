/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10394 {

    public static void main(String[] args) throws IOException {
        boolean primos[] = new boolean[20000000];
        primos[0] = primos[1] = true;
        int MAX, sol[] = new int[MAX = 100000];
        for (int i = 0, c = 0; c < MAX; i++) {
            if (!primos[i]) {
                if (!primos[i - 2]) {
                    sol[c++] = i;
                }
                for (int j = i + i; j < 20000000; j += i) {
                    primos[j] = true;
                }
            }
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null;) {
            int N = Integer.parseInt(ln.trim()) - 1;
            sb.append("(" + (sol[N] - 2) + ", " + sol[N] + ")\n");
        }
        System.out.print(new String(sb));
    }
}
