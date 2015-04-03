/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Masudul Haque
 */
public class p12592 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br=new BufferedReader(new FileReader(new File("12592.txt")));
        Map<String,String> dic=new HashMap<String, String>();
        int num=Integer.parseInt(br.readLine());
        
        for (int i = 0; i < num; i++) {
            dic.put(br.readLine(), br.readLine());
        }
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String input=br.readLine();
            System.out.println(dic.get(input));
        }
    }
}
