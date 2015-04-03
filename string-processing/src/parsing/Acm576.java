/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm576 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("576.txt")));
        String input;
        while ((input = buff.readLine()) != null) {
            String[] line = input.split("/");
            if (line[0].equals("e") && line[1].equals("o") && line[2].equals("i")) {
                break;
            }
            if(getSilabas(line[0])!=5){
                System.out.println(1);
            }
            else if(getSilabas(line[1])!=7){
                System.out.println(2);
            }
            else if(getSilabas(line[2])!=5){
                System.out.println(3);
            }
            else{
                System.out.println("Y");
            }
        }
    }

    static int getSilabas(String str) {
        if (str.trim().length() == 0) {
            return 0;
        }
        return getSilabas(str.replaceFirst("[^aeiouy]*[aeiouy]+[^aeiouy]*", "").trim()) + 1;
    }
}
