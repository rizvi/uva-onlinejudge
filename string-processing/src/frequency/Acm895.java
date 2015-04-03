/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Masudul Haque
 */
public class Acm895 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("895.txt")));
        List<String> dic = new ArrayList<String>();
        ArrayList<Character> arr;
        String input;
        while (!(input = buff.readLine()).equals("#")) {
            dic.add(input);
        }
        while (!(input = buff.readLine()).equals("#")) {
            arr = new ArrayList<Character>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    arr.add(input.charAt(i));
                }
            }
            int counter = 0;
            for (int i = 0; i < dic.size(); i++) {
                String temp = dic.get(i);
                boolean flag = true;
                ArrayList<Character> arr2 = new ArrayList<Character>();
                for (int j = 0; j < arr.size(); j++) {
                    arr2.add(arr.get(j));
                }
                for (int j = 0; j < temp.length(); j++) {
                    if (!arr2.contains(temp.charAt(j))) {
                        flag = false;
                        break;
                    } else {
                        arr2.remove(arr2.indexOf(temp.charAt(j)));
                    }
                }
                if (flag) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}
