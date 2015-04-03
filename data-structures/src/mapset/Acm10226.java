/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapset;

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
public class Acm10226 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("10226.txt")));
        int T=Integer.parseInt(buff.readLine());
        String input=buff.readLine();
        Map<String,Integer> treeMap=new TreeMap<String, Integer>();
        for (int t = 0; t <T; t++) {
            treeMap.clear();
            double total=0.0;
            while((input=buff.readLine())!=null){
                if(treeMap.containsKey(input)){
                    treeMap.put(input, treeMap.get(input)+1);
                }
                else{
                    treeMap.put(input, 1);
                }
                total++;
            }
            for(Map.Entry<String,Integer> entry:treeMap.entrySet()){
                String key=entry.getKey();
                int value=entry.getValue();
                double percent=value/total;
                System.out.printf("%s %.4f\n",key,percent*100.0);
            }
        }
    }
}
