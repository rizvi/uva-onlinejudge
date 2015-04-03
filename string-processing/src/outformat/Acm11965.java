/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package outformat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11965 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11965.txt")));
        int T = Integer.parseInt(buff.readLine());
        for (int t = 1; t <= T; t++) {
            System.out.println("Case "+t+":");
            int line = Integer.parseInt(buff.readLine());
            for (int n = 0; n < line; n++) {
                String input = buff.readLine();
                StringBuilder sb=new StringBuilder("");
                boolean isSpace = false;
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    if(ch==' '){
                        if(!isSpace){
                            sb.append(' ');
                            isSpace=true;
                        }
                    }
                    else{
                        sb.append(ch);
                        isSpace=false;
                    }
                }
                System.out.println(sb);
            }
            if(t<T){
                System.out.println();
            }
        }
    }
}
