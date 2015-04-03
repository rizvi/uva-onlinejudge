/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10930 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        String m = "";
        int ind=1;
        while ((m = br.readLine()) != null) {
            String[]str=m.split(" ");
            int n=Integer.parseInt(str[0]);
            int[]arr=new int[n];
            sb.append("Case #").append(ind).append(":");
            int sumAll=0;
            boolean flag=true;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i+1]);
                sumAll+=arr[i];
                sb.append(" ").append(arr[i]);
            }
            sb.append("\n");
            if(flag){
                for(int i=0;i<n-1;i++){
                    if(arr[i]>=arr[i+1]){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                flag=sumCheck(arr, sumAll);
            }
            if(flag){
                sb.append("This is an A-sequence.\n");
            }else{
                sb.append("This is not an A-sequence.\n");
            }
            ind++;
        }
        System.out.print(sb);
    }
    
    static boolean sumCheck(int[] arr,int sum){
        boolean flag = true;
        int last = 0;
        boolean[] poss = new boolean[sum + 1];
        poss[0] = true;
        for (int i = 0; i < arr.length; i++) {
            flag = flag && (arr[i] > last) && (poss[arr[i]] == false);
            last = arr[i];
            for (int j = sum; j >= arr[i]; j--) {
                poss[j] |= poss[j - arr[i]];
            }
        }
        return flag;
    }
}