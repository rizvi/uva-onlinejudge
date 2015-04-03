/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Acm11401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        long arr[]=new long[1000*1000+1];
        long seq[]=new long[1000*1000+1];
        arr[3]=0;
        seq[3]=0;
        for(int i=4;i<arr.length;i++){
            arr[i]=c(i-2,2)-arr[i-1];
            seq[i]=arr[i]+seq[i-1];
        }
        while(true) {
            int x=Integer.parseInt(br.readLine());
            if(x<3)
                break;
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
