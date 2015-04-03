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
public class Acm11616 {
//    enum Numeral {
//        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
//        int weigth;
//
//        Numeral(int weigth) {
//            this.weigth = weigth;
//        }
//    };
    /**
     * This method convert decimal number to roman. throws IllegalException if
     * number<=0
     *
     * @param decimal number.
     * @return roman digits.
     */
//    public static String decNumberToRoman(long n) {
//
//        if (n <= 0) {
//            throw new IllegalArgumentException();
//        }
//                
//        StringBuilder buf = new StringBuilder();
//
//        final Numeral[] values = Numeral.values();
//       /**
//        * As roman digits represents maximum from left so loop will start from bigger to smaller
//        */
//        for (int i = values.length - 1; i >= 0; i--) {
//            while (n >= values[i].weigth) {
//                buf.append(values[i]);
//                n -= values[i].weigth;
//            }
//        }
//        return buf.toString();
//    }
    enum Roman {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);
        int w;

        private Roman(int w) {
            this.w = w;
        }
    };

    static String decToRm(int dec) {
        String rom = "";
        for (Roman r : Roman.values()) {
            while (dec >= r.w) {
                rom += r;
                dec -= r.w;
            }
        }
        return rom;
    }

    public static void main(String[] args) {
        String[] romans = new String[4000];
        
        Map<String, Integer> arabicMap = new HashMap<String, Integer>();
        for (int i = 1; i < 4000; i++) {
            romans[i] = decToRm(i);
            arabicMap.put(romans[i], i);
        }
     
//        Map<Integer, String> romanMap = new HashMap<Integer, String>();
//        for (int i = 1; i < 4000; i++) {
//            String rom = decNumberToRoman(i);
//            romanMap.put(i, rom);
//            arabicMap.put(rom,i);
//        }
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next(); 
            char ch = input.charAt(0);
            if (Character.isDigit(ch)) {
                int arabic = Integer.parseInt(input);
                System.out.println(romans[arabic]);
            } else {                
                System.out.println(arabicMap.get(input));
            }
        }
    }
}
