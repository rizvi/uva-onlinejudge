/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Masudul Haque
 */
public class Acm10062_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("10062.txt"));
        boolean isFirst=true;
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if(!isFirst){
                System.out.println();                
            }
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            List<Map.Entry> revList = new LinkedList<Map.Entry>(map.entrySet());
            Collections.sort(revList, new Comparator<Map.Entry>() {
                @Override
                public int compare(Map.Entry o1, Map.Entry o2) {
                    return ((Comparable) (o1.getValue())).compareTo(o2.getValue());
                }
            });

            for (Map.Entry<Character, Integer> entry : revList) {
                System.out.println((int) entry.getKey() + " " + entry.getValue());
            }
            isFirst=false;
        }
    }
}
