/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10921 {
    public static void main(String[] args) {
        Map<Character,Integer> values=new HashMap<Character,Integer>();
        values.put('A', 2);
        values.put('B', 2);
        values.put('C', 2);
        values.put('D', 3);
        values.put('E', 3);
        values.put('F', 3);
        values.put('G', 4);
        values.put('H', 4);
        values.put('I', 4);
        values.put('J', 5);
        values.put('K', 5);
        values.put('L', 5);
        values.put('M', 6);
        values.put('N', 6);
        values.put('O', 6);
        values.put('P', 7);
        values.put('Q', 7);
        values.put('R', 7);
        values.put('S', 7);
        values.put('T', 8);
        values.put('U', 8);
        values.put('V', 8);
        values.put('W', 9);
        values.put('X', 9);
        values.put('Y', 9);
        values.put('Z', 9);
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String input=sc.nextLine();
            StringBuilder sb=new StringBuilder("");
            for (int i = 0; i < input.length(); i++) {
               char ch=input.charAt(i);
               if(ch=='0' ||ch=='1' ||ch=='-' ){
                   sb.append(ch);
               }
               else{
                   sb.append(values.get(ch));
               }
            }
            System.out.println(sb);
        }
    }
}
