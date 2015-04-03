/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Masudul Haque
 */
public class Acm10008_2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buff = new BufferedReader(new FileReader(new File("10008.txt")));
        int T = Integer.parseInt(buff.readLine());
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        for (int t = 0; t < T; t++) {
            String input = buff.readLine().toUpperCase();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isLetter(ch)) {
                    if (map.containsKey(ch)) {
                        int count = map.get(ch);
                        map.put(ch, count + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }
            }
        }
        List<Map.Entry> list = new LinkedList<Map.Entry>(map.entrySet());
        Collections.sort(list, reverse());
        for (Map.Entry entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static Comparator<Map.Entry> reverse() {
        return new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                int comp = ((Comparable) o2.getValue()).compareTo(o1.getValue());
                return comp;
            }
        };
    }
}
