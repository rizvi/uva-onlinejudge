/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm11687 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m="";
        StringBuilder temp = new StringBuilder("");
        while(true) {
            m=br.readLine();
           if("END".equals(m))
               break;
           if(m.equals("1")){
               sb.append("1\n");
               continue;
           }
           int lengthOfNum=m.length();
           int realLen=2;
           while(lengthOfNum > 1){
            lengthOfNum =(int) Math.log10(lengthOfNum)+1;
            realLen++;
        }
           sb.append(realLen).append("\n");
        }
        System.out.print(sb);
    }
}