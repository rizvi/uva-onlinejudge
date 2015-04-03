/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;
import java.io.*;
public class Acm10878{
        public static void main(String args[]) throws Throwable{
                BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb=new StringBuilder();
                in.readLine();
                for(String ln;!(ln=in.readLine()).equals("___________");){
                        char[] str=ln.replace(".","").toCharArray();
                        int a=0;
                        for(int i=1;i<str.length-1;i++)a|=(str[i]=='o'?1:0)<<(8-i);
                        sb.append((char)a);
                }
                System.out.print(new String(sb));
        }
}