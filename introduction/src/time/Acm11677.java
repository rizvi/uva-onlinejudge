/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11677 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("11677.txt")));
        while(true){
            String[] in=buff.readLine().split(" ");
            int h1=Integer.parseInt(in[0]);
            int m1=Integer.parseInt(in[1]);
            int h2=Integer.parseInt(in[2]);
            int m2=Integer.parseInt(in[3]);
            
            if(h1==0 && m1==0 && h2==0 && m2==0){
                break;
            }
            int first=h1*60+m1;
            int second=h2*60+m2;
            int res=0;
            if(first<=second){
                res=second-first;
            }
            else{
                res=24*60-(first-second);
            }
            System.out.println(res);
        }
    }
}
