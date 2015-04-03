/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Acm11554 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        BigInteger arr[]=new BigInteger[1000*1000+1];
        BigInteger seq[]=new BigInteger[1000*1000+1];
        arr[3]=BigInteger.ZERO;
        seq[3]=BigInteger.ZERO;
        for(int i=4;i<arr.length;i++){
            arr[i]=BigInteger.valueOf(c(i-2,2)).subtract(arr[i-1]);
            seq[i]=arr[i].add(seq[i-1]);
        }
        int n=Integer.parseInt(br.readLine());
        for(int i=1;i<n+1;i++) {
            int x=Integer.parseInt(br.readLine());
            sb.append(seq[x]).append("\n");
        }
        System.out.print(sb);
    }
    
    static long c(int n, int r) {
        long ans = 1;
        r = Math.min(r, n - r);
        for (int i = 1; i < r + 1; i++) {
            ans = ans*(n - r + i);
            ans /=i;
        }
        return ans;
    }
}