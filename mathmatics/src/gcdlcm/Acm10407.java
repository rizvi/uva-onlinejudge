/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm10407 {

    public static void main(String[] args) throws IOException {
                BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("10407.txt")));
        while (true) {
            String input = buff.readLine();
            if("0".equals(input)){
                break;
            }
            String[] str = input.split(" ");
            int min = Integer.MAX_VALUE;
            int[] num=new int[str.length-1];
            for (int i = 0; i < num.length; i++) {
                num[i]=Integer.parseInt(str[i]);
                if(min>num[i]){
                    min=num[i];
                }
            }
            int result=0;
            for (int i = 0; i < num.length; i++) {
                int j = num[i]-min;
                result=gcd(result, j);
            }
            System.out.println(result);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
