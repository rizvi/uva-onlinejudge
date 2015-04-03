/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10924 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m = "";
        boolean notPrime[] = sievePrime(1050);
        while ((m = br.readLine()) != null) {
            int x=0;
            for(int i=0;i<m.length();i++){
                if(m.charAt(i)>96 && m.charAt(i)<123){
                    x+=m.charAt(i)-96;
                }
                else if(m.charAt(i)>64 && m.charAt(i)<91){
                    x+=m.charAt(i)-38;
                }
            }
            
            if (notPrime[x]) {
                sb.append("It is not a prime word.\n");
            }else{
                sb.append("It is a prime word.\n");
            }
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
