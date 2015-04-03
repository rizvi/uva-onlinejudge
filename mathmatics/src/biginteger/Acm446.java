/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm446 {
   public static void main(String[] args) throws IOException{
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        StringBuilder sb = new StringBuilder("");
        int cases=Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++) {
            String[] str=br.readLine().split(" ");
            int x=Integer.parseInt(str[0], 16);
            int y=Integer.parseInt(str[2], 16);
            int result;
            if("+".equals(str[1])){
                result=x+y;
            }else{
                result=x-y;
            }
            StringBuilder tempX=new StringBuilder(Integer.toBinaryString(x));
            StringBuilder tempY=new StringBuilder(Integer.toBinaryString(y));
            
            sb.append(String.format("%13s", tempX).replace(' ', '0')).append(" ").append(str[1]).append(" ")
                    .append(String.format("%13s", tempY).replace(' ', '0')).append(" = ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
