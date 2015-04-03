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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Masudul Haque
 */
public class Acm10391 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("10391.txt")));
        List<String> dics = new ArrayList<String>();
        String input;
        while ((input = buff.readLine()) != null) {
            dics.add(input);
        }
        Collections.sort(dics);
        String first = dics.get(0);
        for (int i = 1; i < dics.size(); i++) {
            String each = dics.get(i);
            if (each.startsWith(first)) {
                String second = each.substring(first.length());
                if (!second.equals(first) && dics.contains(second)) {
                    System.out.println(each);
                }
            }
            first = each;
        }
    }
}
