/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Masudul Haque
 */
public class Acm10252 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("10252.txt")));
        StringBuilder output=new StringBuilder("");
        Set<Character> res=new TreeSet<Character>();
        String first,second;
        while((first=buff.readLine())!=null && (second=buff.readLine())!=null){
            res.clear();
            for (int i = 0; i < first.length(); i++) {
                for (int j = 0; j < second.length(); j++) {
                    char firstChar=first.charAt(i);
                    char secondChar=second.charAt(j);
                    if(Character.isLowerCase(firstChar) && Character.isLowerCase(secondChar) && 
                       firstChar==secondChar){
                      res.add(firstChar);       
                    }
                }                
            }
            for (Character character : res) {
                output.append(character);
            }
            output.append("\n");
        }
        System.out.print(output);
    }
}
