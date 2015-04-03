/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11452 {

    public static void main(String[] args) throws IOException {
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buff = new BufferedReader(new FileReader(new File("11452.txt")));
        int testCase = Integer.parseInt(buff.readLine());
        while (testCase-- > 0) {
            String inp = buff.readLine();
            int len = inp.length();
            String inpStr = inp;
            String basic="";
            for (int i = len / 2; i >= 0; i--) {
                basic = inpStr.substring(0, i);
                String repeat = inpStr.substring(i, i);
                // cout << basic << " " << repeat << endl;
                if (basic.equals(repeat)) {
                    break;
                }
            }

            int ind = basic.length() * 2;
            int basicInd = 0;

            while (ind < inpStr.length()) {
                ind++;
                basicInd++;
            }

            int output = 8;

            while (output != 1) {
//                System.out.print(basic.charAt(basicInd % basic.length()));
                System.out.print(basic);
                output--;
                basicInd++;
            }
            System.out.println("...");
        }

    }
}
