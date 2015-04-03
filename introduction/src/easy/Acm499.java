/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Masudul Haque
 */
public class Acm499 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
//        BufferedReader buff = new BufferedReader(new FileReader(new File("499.txt")));
        StringBuilder res = new StringBuilder("");
        String input;
        while ((input = buff.readLine()) != null) {
            treeMap.clear();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isLetter(ch)) {
                    if (treeMap.containsKey(ch)) {
                        treeMap.put(ch, treeMap.get(ch) + 1);
                    } else {
                        treeMap.put(ch, 1);
                    }
                }
            }
            int max = Collections.max(treeMap.values());
            for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
                if (entry.getValue() == max) {
                    res.append(entry.getKey());
                }
            }
            res.append(" ").append(max).append("\n");
            
        }
        System.out.print(res);
    }
}
