/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Masudul Haque
 */
public class Acm10338 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(buff.readLine());
        Map<Character,Integer> charMap=new HashMap<Character, Integer>();
        for (int t = 1; t <= T; t++) {
            charMap.clear();
            String string = buff.readLine();
            long total=1;
            for (int i = 0; i < string.length(); i++) {
                total=total*(i+1);
                char ch=string.charAt(i);
                if(charMap.containsKey(ch)){                    
                    charMap.put(ch, charMap.get(ch)+1);
                }
                else{
                    charMap.put(ch, 1);
                }
            }
            for (Map.Entry<Character,Integer> entry: charMap.entrySet()) {
                if(entry.getValue()>1){
                    total=total/fact(entry.getValue());
                }
            }
            System.out.println("Data set "+t+": "+total);
        }
    }
    private static long fact(int n){
        long res=1;
        for (int i = 1; i <=n; i++) {
            res=res*i;
        }
        return res;
    }
}
