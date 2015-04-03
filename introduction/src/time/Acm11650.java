/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buff.readLine());
        int h, m;
        char c;
        
        
        while (t-- > 0) {
            String[] in = buff.readLine().split(":");
            h = Integer.parseInt(in[0]);
            m = Integer.parseInt(in[1]);
            
            int new_h = (h == 12 ? 12 : 12 - h);
            if (m > 0) {
                new_h--;
                if (new_h == 0) {
                    new_h = 12;
                }
            }
            
            int new_m = (m == 0 ? 0 : 60 - m);
            
            System.out.printf("%02d:%02d\n", new_h, new_m);
        }
    }
}
