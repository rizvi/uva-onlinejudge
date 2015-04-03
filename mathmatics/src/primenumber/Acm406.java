/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Acm406 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m = "";
        boolean notPrime[] = sievePrime(1000);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < 1001; i++) {
            if (!notPrime[i]) {
                arr.add(i);
            }
        }
        while ((m = br.readLine()) != null) {
            String[] str = m.split(" ");
            int n = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int index = -1, temp = n;
            while (index == -1) {
                index = arr.indexOf(temp);
                temp--;
            }
            List<Integer> subArr = arr.subList(0, index + 1);
            if (2 * c < subArr.size()) {
                if (subArr.size() % 2 == 0) {
                    subArr = arr.subList((subArr.size() - 2 * c) / 2, (subArr.size() + 2 * c) / 2);
                } else {
                    subArr = arr.subList((subArr.size() - 2 * c + 2) / 2, (subArr.size() + 2 * c) / 2);
                }
            }
            sb.append(n).append(" ").append(c).append(":");
            for (int i = 0; i < subArr.size(); i++) {
                sb.append(" ").append(subArr.get(i));
            }
            sb.append("\n\n");
        }
        System.out.print(sb);
    }

    static boolean[] sievePrime(int x) {
        boolean[] notPrime = new boolean[x + 1];
        notPrime[0] = true;
        notPrime[1] = false;
        for (int i = 2; i * i < x + 1; i++) {
            if (!notPrime[i]) {
                for (int j = i; i * j < x + 1; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return notPrime;
    }
}