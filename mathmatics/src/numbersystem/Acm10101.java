/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10101 {
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cases=1;
        while (true) {
            long x=0;
            try {
               x=s.nextLong();
            } catch (Exception e) {
                break;
            }
            String temp=cases+"";
            int num=temp.length();
            for(int i=0;i<4-num;i++){
                temp=" "+temp;
            }
            System.out.print(temp+". ");
            call(x);
            System.out.println();
            cases++;
        }
    }
    
    static void call(long x){
        if (x==0){
            System.out.print("0");
            return;
        }
        long x2=x;
        long temp=0;
        boolean first=true;
        temp=x2/10000000;
        if(temp>0 && temp<100){
            System.out.print(temp+" kuti");
            first=false;
        }
        if(temp>99){
            call(temp);
            System.out.print(" kuti");
            first=false;
        }
        x2=x%10000000;
        temp=x2/100000;
        if(temp>0 && temp<100){
            if(!first)
                 System.out.print(" ");
            System.out.print(temp+" lakh");
            first=false;
        }
        if(temp>99){
            call(temp);
            System.out.print(" lakh");
            first=false;
        }
        
        x2=x%100000;
        temp=x2/1000;
        if(temp>0){
            if(!first)
                 System.out.print(" ");
            System.out.print(temp+" hajar");
            first=false;
        }
        
        x2=x%1000;
        temp=x2/100;
        if(temp>0){
            if(!first)
                 System.out.print(" ");
            System.out.print(temp+" shata");
            first=false;
        }
        
        x2=x%100;
        temp=x2;
        if(temp>0){
            if(!first)
                 System.out.print(" ");
            System.out.print(temp);
            first=false;
        }
        
    }
}
