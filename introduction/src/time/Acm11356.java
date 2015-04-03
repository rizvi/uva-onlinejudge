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
public class Acm11356 {

    static String[] arr = {"January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("");
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11356.txt")));

        Calendar cal = new GregorianCalendar();
        int T = Integer.parseInt(buff.readLine());
        for (int t = 1; t <= T; t++) {
            String[] input = buff.readLine().split("-");
            int K = Integer.parseInt(buff.readLine());

            sb.append("Case ").append(t).append(": ");
            int y = Integer.parseInt(input[0]);
            int m = getMonthNo(input[1]);
            int d = Integer.parseInt(input[2]);
            cal.set(y, m, d);
            cal.add(Calendar.DATE, K);
            
            sb.append(cal.get(Calendar.YEAR)).append("-")
                    .append(arr[cal.get(Calendar.MONTH)]).append("-")
                    .append(cal.get(Calendar.DATE)<10?"0":"").append(cal.get(Calendar.DATE)).append("\n");
        }
        System.out.print(sb);
    }

    private static int getMonthNo(String string) {
        for (int i = 0; i < arr.length; i++) {
            if (string.equals(arr[i])) {
                return i;
            }
        }
        return 0;
    }
}
