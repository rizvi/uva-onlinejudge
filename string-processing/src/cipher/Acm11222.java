/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acm11222 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        int cases = Integer.parseInt(br.readLine());
        br.readLine();
        for (int l = 1; l < cases + 1; l++) {
            if (l > 1) {
                sb.append("\n");
            }
            sb.append("Case #").append(l).append(":\n");
            while (true) {
                String m = br.readLine();
                if ("".equals(m)) {
                    break;
                }
                StringTokenizer st = new StringTokenizer(m);
                for (int i = 0; st.hasMoreElements(); i++) {
                    String temp = st.nextToken();
                    while (i > temp.length() - 1) {
                        try {
                            temp = st.nextToken();
                        } catch (Exception e) {
                            break;
                        }
                    }
                    if (!(i > temp.length() - 1)) {
                        sb.append(temp.charAt(i));
                    }
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}