/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Masudul Haque
 */
public class Acm10420 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
//        BufferedReader buff = new BufferedReader(new FileReader(new File("10420.txt")));
        StringBuilder res = new StringBuilder("");
        int T=Integer.parseInt(buff.readLine());
        for (int t=0; t < T; t++) {
            String[] input=buff.readLine().split(" ");
            if(treeMap.containsKey(input[0])){
                treeMap.put(input[0], treeMap.get(input[0])+1);
            }
            else{
                treeMap.put(input[0], 1);
            }
        }
        for (Map.Entry<String,Integer> entry : treeMap.entrySet()) {
            res.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.print(res);
    }
}
