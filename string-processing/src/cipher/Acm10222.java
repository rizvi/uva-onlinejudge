/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Masudul Haque
 */
public class Acm10222 {
    public static void main(String[] args) throws IOException {
        String cipher="qwertyuiop[]asdfghjkl;'zxcvbnm,./";
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        for (int i = 0; i < cipher.length()-2; i++) {
            char p=cipher.charAt(i);
            char ci=cipher.charAt(i+2);
            charMap.put(ci, p);
        }
       BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
       String input;
       while((input=buff.readLine().toLowerCase())!=null){
           StringBuilder sb=new StringBuilder("");
           for (int i = 0; i < input.length(); i++) {
               char ch=input.charAt(i);
               if(charMap.containsKey(ch)){
                   sb.append(charMap.get(ch));
               }
               else if(Character.isWhitespace(ch)){
                   sb.append(' ');
               }               
           }
           System.out.println(sb);
       }
    }
}
