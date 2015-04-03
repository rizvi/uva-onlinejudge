/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm11734 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buff.readLine());
        for (int i = 1; i <= n; i++) {
            String first = buff.readLine();
            String second = buff.readLine();
            System.out.printf("Case %d: ", i);
            if (first.equals(second)) {
                System.out.println("Yes");
            } else if (isSpaceMatter(first, second)) {
                System.out.println("Output Format Error");
            } else {
                System.out.println("Wrong Answer");
            }

        }
    }

    private static boolean isSpaceMatter(String str1, String str2) {
        StringBuilder temp1=new StringBuilder();
                StringBuilder temp2=new StringBuilder();
                for(int j=0;j<str1.length();j++){
                    if(str1.charAt(j)!=' ')
                        temp1.append(str1.charAt(j));
                }
                for(int j=0;j<str2.length();j++){
                    if(str2.charAt(j)!=' ')
                        temp2.append(str2.charAt(j));
                }
           return temp1.toString().equals(temp2.toString());
    }
}
