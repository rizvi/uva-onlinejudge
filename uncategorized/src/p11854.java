/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masud
 */
public class p11854 {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("11854.txt")));
        while (sc.hasNext()) {
            int[] x = new int[3];
            long[] sq = new long[3];
            int zero = 0,m=0;
            long max=0;
            for (int i = 0; i < 3; i++) {
                x[i] = sc.nextInt();
                if (x[i] == 0) {
                    zero++;
                } else {
                    sq[i] = x[i] * x[i];
                    if(sq[i]>max){
                        max=sq[i];
                        m=i;
                    }
                }
            }
            
            if (zero == 3) {
                break;
            }
            boolean isRight=false;
            switch(m){
                case 0:
                    isRight=check(max,sq[1],sq[2]);
                    break;
                case 1:
                    isRight=check(max,sq[0],sq[2]);
                    break;
                case 2:
                    isRight=check(max,sq[0],sq[1]);
                    break;
            }
            if(isRight){
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }
        }
    }

    private static boolean check(long max, long a, long b) {
         return max==a+b;     
    }
}
