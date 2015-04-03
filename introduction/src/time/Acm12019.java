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
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Masudul Haque
 */
public class Acm12019 {
    public static void main(String[] args) throws IOException {
        String[] week={"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("12019.txt")));
        int T=Integer.parseInt(buff.readLine());
        Calendar cal=new GregorianCalendar();
        for (int t = 0; t < T; t++) {
            String[] in=buff.readLine().split(" ");
            int m=Integer.parseInt(in[0]);
            int d=Integer.parseInt(in[1]);
            cal.set(2011, m-1, d);
            System.out.println(week[cal.get(Calendar.DAY_OF_WEEK)-1]);
        }
    }
}
