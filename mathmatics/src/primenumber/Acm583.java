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
public class Acm583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            sb.append(num).append(" =");
            if (num < 0) {
                num = -num;
                sb.append(" -1 x");
            }
            sb.append(primeFactors(num)).append("\n");
        }
        System.out.print(sb);
    }

    public static StringBuilder primeFactors(int numbers) {
        int n = numbers;
        StringBuilder buff = new StringBuilder("");
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                buff.append(" ").append(i).append(" x");
                n /= i;
            }
        }
        if (n > 1) {
            buff.append(" ").append(n);
        } else {
            buff.replace(buff.length() - 2, buff.length(), "");
        }

        return buff;
    }
}
