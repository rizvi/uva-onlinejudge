/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

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
public class Acm11577 {

    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11577.txt")));
        int L = Integer.parseInt(buff.readLine());
        for (int t = 0; t < L; t++) {
            map.clear();
            String line = buff.readLine().toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (Character.isLetter(ch)) {
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }
            }
            int max=Collections.max(map.values());
            for (Map.Entry<Character,Integer>  entry: map.entrySet()) {
                if(entry.getValue()==max){
                    System.out.print(entry.getKey());
                }
            }
            System.out.println();
        }
    }
}
