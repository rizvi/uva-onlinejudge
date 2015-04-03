/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Acm10311 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        BitSet notprime= sievePrime(1000 * 1000 * 100);
        String m = "";
        while ((m = br.readLine()) != null) {
            int x = Integer.parseInt(m);
            boolean status = false;
            sb.append(x);
            if(x%2==1 &&x>1){
                if(!notprime.get(x-2)){
                   sb.append(" is the sum of 2 and ").append(x-2).append(".\n"); 
                   status=true;
                } 
            }else{
                int mid=x/2;
                for (int ind=0, i = mid; i <x ; i++,ind++) {
                    if (!notprime.get(mid-ind) && !notprime.get(i) && (mid-ind)!=i) {
                        sb.append(" is the sum of ");
                        sb.append(x-i).append(" and ").append(i).append(".\n");
                        status = true;
                        break;
                    }
                }
            }
            if (!status) {
                sb.append(" is not the sum of two primes!\n");
            }
        }
        System.out.print(sb);
    }

    static BitSet sievePrime(int x) {
        BitSet notprime = new BitSet(x + 1);
        notprime.set(0);
        notprime.set(1);
        for (int i = 2; i * i < x + 1; i++) {
            if (!notprime.get(i)) {
                for (int j = i; i * j < x + 1; j++) {
                    notprime.set(i * j);
                }
            }
        }
       return notprime;
    }
}