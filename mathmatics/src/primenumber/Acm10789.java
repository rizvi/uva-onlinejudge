/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Masudul Haque
 */
public class Acm10789 {

    public static void main(String[] args) throws IOException {
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("10789.txt")));
        int t = Integer.parseInt(buff.readLine());
        for (int n = 1; n <= t; n++) {

            String input = buff.readLine();
            freqMap.clear();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (freqMap.containsKey(ch)) {
                    freqMap.put(ch, freqMap.get(ch) + 1);
                } else {
                    freqMap.put(ch, 1);
                }
            }

            Set s = freqMap.entrySet();
            Iterator it = s.iterator();

            String res = "";
            while (it.hasNext()) {
                Map.Entry k = (Map.Entry) it.next();
                char key = (Character) k.getKey();
                int val = (Integer) k.getValue();
                if (isPrime(val)) {
                    res += key;
                }
            }
            if (res.isEmpty()) {
                System.out.println("Case " + n + ": empty");
            } else {
                char[] sorted = res.toCharArray();
                Arrays.sort(sorted);
                System.out.println("Case " + n + ": " + new String(sorted));
            }
        }
    }

    static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
