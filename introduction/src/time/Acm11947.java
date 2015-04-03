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
import java.util.Locale;

/**
 *
 * @author Masudul Haque
 */
public class Acm11947 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder("");
//        BufferedReader buff=new BufferedReader(new FileReader(new File("11947.txt")));
        Calendar cal = new GregorianCalendar();
        int T = Integer.parseInt(buff.readLine().trim());
        for (int t = 1; t <= T; t++) {
            String input = buff.readLine().trim();
            int m = Integer.parseInt(input.charAt(0) + "" + input.charAt(1));
            int d = Integer.parseInt(input.charAt(2) + "" + input.charAt(3));
            int y = Integer.parseInt(input.substring(4));
            cal.set(y, m - 1, d);
            cal.add(Calendar.DATE, 280);
            int M=cal.get(Calendar.MONTH);
            int D=cal.get(Calendar.DATE);
            int Y=cal.get(Calendar.YEAR);
            
            sb.append(String.format(Locale.US,"%d %02d/%02d/%d %s\n",t,M+1,D,Y,zodiac(D, M+1)));
        }
        System.out.print(sb);
    }

    static String zodiac(int day, int month) {
        if (day >= 21 && month == 1 || day <= 19 && month == 2) {
            return "aquarius";
        }
       else if (day >= 20 && month == 2 || day <= 20 && month == 3) {
            return "pisces";
        }
       else  if (day >= 21 && month == 3 || day <= 20 && month == 4) {
            return "aries";
        }
       else  if (day >= 21 && month == 4 || day <= 21 && month == 5) {
            return "taurus";
        }
       else  if (day >= 22 && month == 5 || day <= 21 && month == 6) {
            return "gemini";
        }
       else  if (day >= 22 && month == 6 || day <= 22 && month == 7) {
            return "cancer";
        }
       else  if (day >= 23 && month == 7 || day <= 21 && month == 8) {
            return "leo";
        }
       else  if (day >= 22 && month == 8 || day <= 23 && month == 9) {
            return "virgo";
        }
       else  if (day >= 24 && month == 9 || day <= 23 && month == 10) {
            return "libra";
        }
       else  if (day >= 24 && month == 10 || day <= 22 && month == 11) {
            return "scorpio";
        }
       else  if (day >= 23 && month == 11 || day <= 22 && month == 12) {
            return "sagittarius";
        }
       else  if(day >= 23 && month == 12 || day <= 20 && month == 1) {
            return "capricorn";
        }
        return "";
    }
}
