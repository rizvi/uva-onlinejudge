/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10679 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        int len=Integer.parseInt(br.readLine());
        for(int i=0;i<len;i++) {
            String test=br.readLine();
            int q=Integer.parseInt(br.readLine());
            for(int j=0;j<q;j++) {
                String get=br.readLine();
                if(!findPattern(get, test)){
                    sb.append("n\n");
                }else{
                    sb.append("y\n");
                }
            }
        }
        System.out.print(sb);
    }
    
    static boolean findPattern(String Pattern,String str){
        int count=0;
        for(int i=0,j=0;i<str.length();i++){
            if(Pattern.charAt(j)==str.charAt(i)){
                count++;
                j++;
            }else{
                j=0;
                count=0;
            }
            if(count==Pattern.length()){
                return true;
            }
        }
        return false;
    }
}