/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10281 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        int t=0,speed=0;
        double dis=0.0;
//        BufferedReader buff=new BufferedReader(new FileReader(new File("10281.txt")));
        String input;
        while((input=buff.readLine())!=null){
            
            String[] str=input.split(" ");
            String[] time=str[0].split(":");
            int now=Integer.parseInt(time[0])*3600+Integer.parseInt(time[1])*60+Integer.parseInt(time[2]);
            dis+=(now-t)*speed;
            t=now;
            if(str.length==2){
                speed=Integer.parseInt(str[1]);
            }
            else if(str.length==1){
                System.out.print(str[0]);
                System.out.printf(" %.2f km\n",dis/3600.0);
            }
        }
    }
}
