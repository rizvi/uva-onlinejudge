/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Acm10892 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m = "";
        while ((m = br.readLine()) != null) {
            if ("0".equals(m)) {
                break;
            }
            LinkedList<Long> arr = new LinkedList<Long>();
            long x = Long.parseLong(m);
            for (long i = 1; i * i < x + 1; i++) {
                if (x % i == 0) {
                    arr.add(i);
                    if(i!=x/i)
                        arr.add(x/i);
                }
            }
             
            int counter=0;
            
            for (int i = 0; i < arr.size(); i++) {
                for (int j = i; j <arr.size(); j++) {
                    if (lcm(arr.get(i), arr.get(j)) == x) {
                        counter++;
                    }
                }
            }
            sb.append(x).append(" ").append(counter).append("\n");
        }
        System.out.print(sb);
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}