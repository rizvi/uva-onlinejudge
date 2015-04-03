/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class p10943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        String m = "";
        BigInteger arr[][] = new BigInteger[101][101];
        for (int i = 1; i < 101; i++) {
            arr[1][i] = BigInteger.valueOf(i);
            arr[i][1] = BigInteger.ONE;
        }
        for (int i = 2; i < 101; i++) {
            for (int j = 2; j < 101; j++) {
                arr[i][j] = arr[i - 1][j].add(arr[i][j - 1]);
            }
        }
        while (true) {
            String[] str = br.readLine().split(" ");
            int i = Integer.parseInt(str[0]);
            int j = Integer.parseInt(str[1]);
            if (i == 0 && j == 0) {
                break;
            }
            sb.append(arr[i][j].mod(BigInteger.valueOf(1000 * 1000))).append("\n");
        }
        System.out.print(sb);
    }
}
