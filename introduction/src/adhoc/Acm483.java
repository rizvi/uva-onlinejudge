/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm483 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
      //  Scanner sc = new Scanner(new FileInputStream(new File("483.txt")));
        StringBuilder[] eachBuff;
        
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] eachWord=line.split(" ");
            eachBuff=new StringBuilder[eachWord.length];
            StringBuilder output=new StringBuilder("");
            for (int i = 0; i < eachWord.length; i++) {
                eachBuff[i] = new StringBuilder(eachWord[i]);
                output.append(eachBuff[i].reverse());
                if(i!=eachWord.length-1){
                    output.append(" ");
                }
            }
            System.out.println(output);
        }
    }
}
