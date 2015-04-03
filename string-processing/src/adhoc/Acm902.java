/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Masudul Haque
 */
public class Acm902 {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] str = input.split(" ");
            int n = Integer.parseInt(str[0]);
            String text = str[1];
            for (int i = 0; i < text.length() - n; i++) {
                String string = text.substring(i, i + n);
                strList.add(string);
            }
            Set<String> unique = new HashSet<String>(strList);
            String res="";
            int max = 0;
            for (String key : unique) {
                int freq=Collections.frequency(strList, key);
                if(max<freq){
                    max=freq;
                    res=key;
                }
            }
            System.out.println(res);
            strList.clear();
        }
    }
}
