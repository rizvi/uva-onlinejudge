/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * TODO Time Limit Exceed.
 * @author Masudul Haque
 */
public class Acm10061 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        StringBuilder sb=new StringBuilder("");
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int b = cin.nextInt();
            BigInteger ans = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                ans = ans.multiply(BigInteger.valueOf(i));
            }
            String str = ans.toString(b);
            char[] arr = str.toCharArray();
            int len = str.length(), pos = len - 1;
            while (arr[pos] == '0') {
                pos--;
            }
            sb.append(len - pos - 1).append(" ").append(len).append("\n");
        }
        System.out.print(sb);
    }
}
