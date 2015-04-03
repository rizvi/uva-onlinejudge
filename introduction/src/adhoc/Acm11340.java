/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Masudul Haque
 */
public class Acm11340 {
    public static void main(String[] args) throws IOException {
        HashMap<Character,Integer> values=new HashMap<Character,Integer>(); 
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("11340.txt")));
        int N=Integer.parseInt(buff.readLine());
        while(N-- >0){
            int k=Integer.parseInt(buff.readLine());
            values.clear();
            for (int i = 0; i <k; i++) {
                String input=buff.readLine();
                String[] str=input.split(" ");
                char ch=str[0].charAt(0);
                int price=0;
                if(!str[1].isEmpty()){
                price=Integer.parseInt(str[1]);
                }
                values.put(ch, price);
            }
            int line=Integer.parseInt(buff.readLine());
            int sum=0;
            for (int i = 0; i <line; i++) {
               String word=buff.readLine();
                for (int j = 0; j < word.length(); j++) {
                    char letter=word.charAt(j);
                    if(values.containsKey(letter)){
                        sum+=values.get(letter);
                    }
                }
            }
            double dollar=sum/100.0;
            System.out.printf("%.2f$\n",dollar);
        }
    }
   
}
