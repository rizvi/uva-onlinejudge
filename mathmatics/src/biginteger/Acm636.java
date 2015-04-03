/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Masudul Haque
 */
public class Acm636 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m = "";
        ArrayList<Long> arr = new ArrayList<Long>();
        long z = 1;
        while (z * z < 1000000000) {
            arr.add(z * z);
            z++;
        }
        while (true) {
            m = br.readLine();
            int x = Integer.parseInt(m);
            if (x == 0) {
                break;
            }
            char max = '0';
            for (int i = 0; i < m.length(); i++) {
                if (m.charAt(i) > max) {
                    max = m.charAt(i);
                }
            }
            int minBase = Integer.parseInt(max + "") + 1;

            for (int j = minBase; j < 100; j++) {
                long sum=0;
                for (int k = m.length()-1,index=0; k > -1; k--,index++) {
                    sum+=Integer.parseInt(m.charAt(index)+"")*(Math.pow(j, k));
                }
                if(arr.contains(sum)){
                    minBase=j;
                    break;
                }
            }
            sb.append(minBase).append("\n");
        }
        System.out.print(sb);
    }
}
