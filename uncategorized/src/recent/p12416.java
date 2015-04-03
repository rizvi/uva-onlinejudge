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
public class p12416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br=new BufferedReader(new FileReader(new File("12416.txt")));
        String input;
        while((input=br.readLine())!=null){
            int c = 0, Max = 0;
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == ' ') {
                    c++;
                } else {
                    if (Max < c) {
                        Max = c;
                    }
                    c = 0;
                }
            }
            c = 0;
            while (Max != 1) {
                Max = (Max / 2) + (Max % 2);
                c++;
            }
            System.out.printf("%d\n", c);
        }
    }
}
