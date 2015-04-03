/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Masudul Haque
 */
public class Acm10420 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, HashSet<String>> map= new TreeMap<String, HashSet<String>>();
        Scanner sc=new Scanner(System.in);
//        Scanner sc=new Scanner(new File("10420.txt"));
        int T=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String line=sc.nextLine();
            String coutry=line.substring(0,line.indexOf(" "));
            String citizen=line.substring(line.indexOf(" "));
            HashSet<String> people=map.get(coutry);
            if(people==null){
                people=new HashSet<String>();
                map.put(coutry, people);
            }
            people.add(citizen);
        }
        for(Map.Entry<String, HashSet<String>> entry:map.entrySet()){
            System.out.println(entry.getKey() +" "+ entry.getValue().size());
        }
    }
}
