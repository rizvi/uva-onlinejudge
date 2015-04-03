/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Masudul Haque
 */
public class Acm902Sample {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            int n = input.nextInt();
            String str = input.next();
            HashMap<String, Integer> m = new HashMap<String, Integer>();
            for (int i = 0; i < str.length() - n + 1; i++) {
                String subs = str.substring(i, i + n);
                if (m.containsKey(subs)) {
                    m.put(str.substring(i, i + n), m.get(subs) + 1);
                } else {
                    m.put(str.substring(i, i + n), 1);
                }
            }
           
            Set s = m.entrySet();
            Iterator it = s.iterator();

            String ret = "";
            int max = Integer.MIN_VALUE;

            while (it.hasNext()) {
                Map.Entry k = (Map.Entry) it.next();
                String key = (String) k.getKey();
                int val = (Integer) k.getValue();

                if (val > max) {
                    max = val;
                    ret = key;
                }
            }

            System.out.println(ret);
        }
    }
}
