/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm344 {

    enum Numeral {

        i(1), iv(4), v(5), ix(9), x(10), xl(40), l(50), xc(90), c(100);
        int weigth;

        Numeral(int weigth) {
            this.weigth = weigth;
        }
    };

    public static String roman(long n) {

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder buf = new StringBuilder();

        final Numeral[] values = Numeral.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].weigth) {
                buf.append(values[i]);
                n -= values[i].weigth;
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Map<Integer, String> romValues = new HashMap<Integer, String>(100);
        for (int i = 1; i <= 100; i++) {
            romValues.put(i, roman(i));
        }
        StringBuilder res;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            res = new StringBuilder("");
            for (int i = 1; i <= num; i++) {
                res.append(romValues.get(i));
            }
            int[] rDigit = new int[5];
            for (int i = 0; i < res.length(); i++) {
                char ch=res.charAt(i);
                switch(ch){
                    case 'i': rDigit[0]++;
                        break;
                    case 'v': rDigit[1]++;
                        break;
                    case 'x': rDigit[2]++;
                        break;
                    case 'l': rDigit[3]++;
                        break;
                    case 'c': rDigit[4]++;
                        break;
                }
            }
             System.out.printf("%d: %d i, %d v, %d x, %d l, %d c\n",num,rDigit[0],rDigit[1],rDigit[2],rDigit[3],rDigit[4]);
               
        }
    }
}
