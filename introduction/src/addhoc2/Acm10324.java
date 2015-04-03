/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class Acm10324 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caso = 1;
        for (String ln; (ln = in.readLine()) != null; caso++) {
            char[] str = ln.trim().toCharArray();
            int n, s[] = new int[n = str.length];
            s[0] = str[0] - '0';
            for (int i = 1; i < n; i++) {
                s[i] = s[i - 1] + (str[i] - '0');
            }
            int M = parseInt(in.readLine().trim());
            sb.append("Case " + caso + ":\n");
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int A = parseInt(st.nextToken()), B = parseInt(st.nextToken()), I = min(A, B), J = max(A, B),
                        suma = s[J] - (I > 0 ? s[I - 1] : 0);
                sb.append(suma == 0 || suma == J - I + 1 ? "Yes\n" : "No\n");
            }
        }
        System.out.print(new String(sb));
    }
}
