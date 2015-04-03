/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probability;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Integer.*;

public class Acm10238 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null;) {
            StringTokenizer st = new StringTokenizer(ln);
            int F = parseInt(st.nextToken()), N = parseInt(st.nextToken()), S = parseInt(st.nextToken());
            BigInteger[] mem = new BigInteger[S + 1];
            mem[0] = BigInteger.ONE;
            for (int i = 1; i <= S; i++) {
                mem[i] = BigInteger.ZERO;
            }
            for (int i = 0; i < N; i++) {
                for (int j = S; j >= 0; j--) {
                    for (int h = 1; h <= F; h++) {
                        if (j + h <= S) {
                            mem[j + h] = mem[j + h].add(mem[j]);
                        }
                    }
                    mem[j] = BigInteger.ZERO;
                }
            }
            sb.append(mem[S] + "/" + BigInteger.valueOf(F).pow(N) + "\n");
        }
        System.out.print(new String(sb));
    }
}
