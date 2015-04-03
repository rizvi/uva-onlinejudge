/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm11716 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m = "";
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            m = br.readLine();
            if (is_Psquare(m.length())) {
                int root=(int) Math.sqrt(m.length());
                char[][] arr=new char[root][root];
                for(int j=0;j<root;j++){
                   for(int z=0;z<root;z++){
                       arr[j][z]=m.charAt(j*root+z);
                   }
                }
                for(int j=0;j<root;j++){
                   for(int z=0;z<root;z++){
                       sb.append(arr[z][j]);
                   }
                }
            }else{
                sb.append("INVALID");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean is_Psquare(int x) {
        int root = (int) (Math.floor(Math.sqrt(x) + 0.5));
        return root * root == x;
    }
}