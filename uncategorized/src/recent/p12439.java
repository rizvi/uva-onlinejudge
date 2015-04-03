/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class p12439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("12439.txt")));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");


            int y1 = Integer.parseInt(first[2]);
            int y2 = Integer.parseInt(second[2]);
            int m1 = getNoByMonth(first[0]);
            int m2 = getNoByMonth(second[0]);
            int d2 = Integer.parseInt(second[1].substring(0, second[1].length() - 1));//To split comma from day.
            if (m1 > 1) {//Skip if month greater than February.
                ++y1;
            }
            if (m2 < 1 || (m2 == 1 && d2 < 29)) {//Include if month less the February 29.
                --y2;
            }
            int ans = y2 / 4 - (y1 - 1) / 4;
            ans -= y2 / 100 - (y1 - 1) / 100;
            ans += y2 / 400 - (y1 - 1) / 400;
            System.out.printf("Case %d: %d\n", t, ans);
        }
    }

    private static int getNoByMonth(String string) {
        String[] month = {"January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"};
        for (int i = 0; i < month.length; i++) {
            if (string.equals(month[i])) {
                return i;
            }
        }
        return 0;
    }
}
