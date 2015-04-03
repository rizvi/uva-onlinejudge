/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class p12602 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String input=br.readLine();
            String[] in=input.split("-");
            int base=2;
            int value=0;
            for (int j = 0; j < 3; j++) {
               value+= (in[0].charAt(j)-'A')*Math.pow(26, base);
               base--;
            }
            int diff=Math.abs(value-Integer.parseInt(in[1]));
            if(diff<=100){
                System.out.println("nice");
            }
            else{
                System.out.println("not nice");
            }
        }
    }
}
