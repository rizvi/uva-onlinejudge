/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm483_2 {
    public static void main(String[] args) throws IOException{        
        Scanner sc=new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("483.txt")));
        while(sc.hasNext()){
            String line=sc.nextLine();
            String[] words=line.split(" ");
            for (int i = 0; i < words.length; i++) {
                System.out.print(reverse(words[i]));
                if(i!=words.length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
