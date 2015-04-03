/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Acm893 {

    public static void main(String[] args) {
        try {
            Calendar c = new GregorianCalendar();
// Scanner in=new Scanner(new FileReader("d:\\in.txt"));
            Scanner in = new Scanner(System.in);
            for (int a, d, m, y;;) {
                a = in.nextInt();
                d = in.nextInt();
                m = in.nextInt();
                y = in.nextInt();
                if (a == 0 && d == 0 && m == 0 && y == 0) {
                    return;
                }
                c.set(y, m - 1, d);
                c.add(Calendar.DATE, a);
                System.out.println((c.get(Calendar.DATE)) + " " + (c.get(Calendar.MONTH) + 1) + " " + c.get(Calendar.YEAR));
            }
        } catch (Exception e) {
        }
    }
}