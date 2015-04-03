/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10948 {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String m = "";
        boolean[]notPrime=sievePrime(1000*1000);
        StringBuffer sb = new StringBuffer("");
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;
            sb.append(n).append(":\n");
            boolean flag=false;
            for(int i=2;i<n/2+1;i++){
                if(!notPrime[i]&&!notPrime[n-i]){
                    flag=true;
                    sb.append(i).append("+").append(n-i).append("\n");
                    break;
                }
            }
            if(!flag)
                sb.append("NO WAY!").append("\n");
        }
        System.out.print(sb);
    }
      static boolean[] sievePrime(int x) {
        boolean[] notPrime = new boolean[x + 1];
        notPrime[0] = true;
        notPrime[1] = true;
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