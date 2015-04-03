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
public class Acm11223 {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put(".-", "A");
        result.put(".---", "J");
        result.put("...", "S");
        result.put(".----", "1");
        result.put(".-.-.-", ".");
        result.put("---...", ":");
        result.put("-...", "B");
        result.put("-.-", "K");
        result.put("-", "T");
        result.put("..---", "2");
        result.put("--..--", ",");
        result.put("-.-.-.", ";");
        result.put("-.-.", "C");
        result.put(".-..", "L");
        result.put("..-", "U");
        result.put("...--", "3");
        result.put("..--..", "?");
        result.put("-...-", "=");
        result.put("-..", "D");
        result.put("--", "M");
        result.put("...-", "V");
        result.put("....-", "4");
        result.put(".----.", "'");
        result.put(".-.-.", "+");
        result.put(".", "E");
        result.put("-.", "N");
        result.put(".--", "W");
        result.put(".....", "5");
        result.put("-.-.--", "!");
        result.put("-....-", "-");
        result.put("..-.", "F");
        result.put("---", "O");
        result.put("-..-", "X");
        result.put("-....", "6");
        result.put("-..-.", "/");
        result.put("..--.-", "_");
        result.put("--.", "G");
        result.put(".--.", "P");
        result.put("-.--", "Y");
        result.put("--...", "7");
        result.put("-.--.", "(");
        result.put(".-..-.", "\"");
        result.put("....", "H");
        result.put("--.-", "Q");
        result.put("--..", "Z");
        result.put("---..", "8");
        result.put("-.--.-", ")");
        result.put(".--.-.", "@");
        result.put("..", "I");
        result.put(".-.", "R");
        result.put("-----", "0");
        result.put("----.", "9");
        result.put(".-...", "&");

        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("11223.txt")));
        int N = Integer.parseInt(buff.readLine());
        for (int n = 1; n <= N; n++) {
            String line = buff.readLine();
            System.out.println("Message #" + n);
            String[] word = line.split(" ");
            for (String string : word) {
                if (result.containsKey(string)) {
                    System.out.print(result.get(string));
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
           if(n<N){
               System.out.println();
           }
        }
    }
}
