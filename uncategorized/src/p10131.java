/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Masud
 */
import java.util.*;
 
// UVa ID 10131
// Is bigger smarter
// DP
// By Shaun Ren
public class p10131 {
 
       
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
               
                ArrayList<Elephant> elephants = new ArrayList<Elephant>();
               
                int elephantIndex = 1;
                while (sc.hasNextInt()) {
                        Elephant e = new Elephant(elephantIndex, sc.nextInt(), sc.nextInt());
                        elephants.add(e);
                       
                        elephantIndex ++;
                }
               
                Collections.sort(elephants);
               
                // d[i] <- largest sequence possible @ [0,i]
                int[] d = new int[elephants.size()];
                int[] parents = new int[elephants.size()];
               
                for (int i=0; i<elephants.size(); i++) {
                        parents[i] = -1;
                        d[i] = 1;
                }
               
               
                // d[i] = max{ d[j](j < i, w[j] < w[i], s[j] > s[i]) } + 1
                for (int i=1; i<elephants.size(); i++) {
                        Elephant current = elephants.get(i);
                       
                        int max = 0, index = -1;
                        for (int j=0; j<i; j++) {
                                Elephant e = elephants.get(j);
                                if ((e.iq > current.iq) && (e.weight < current.weight) && (d[j] > max)) {
                                        max = d[j];
                                        index = j;
                                }
                        }
                       
                        d[i] = max + 1;
                        parents[i] = index;
                }
               
                int max = 0, index = -1;
                for (int i=0;i<elephants.size(); i++) {
                        if (d[i] > max) {
                                max = d[i];
                                index = i;
                        }
                }
               
                // output data
                System.out.println(max);
               
                ArrayList<Integer> indexs = new ArrayList<Integer>();
                int current = index;
               
                do {
                        indexs.add(elephants.get(current).index);
                        current = parents[current];
                } while (current != -1);
               
                for (int i=indexs.size() - 1; i>=0; i--) {
                        System.out.println(indexs.get(i));
                }
               
 
        }
       
       
 
}
 
class Elephant implements Comparable<Elephant> {
        public int index = -1;
        public int weight = 0;
        public int iq = 0;
       
        public Elephant() {
               
        }
       
        public Elephant(int index, int weight, int iq) {
                this.index = index;
                this.weight = weight;
                this.iq = iq;
        }
       
        @Override
        public int compareTo(Elephant e) {
               
                if (this.weight == e.weight)
                        return e.iq - this.iq;
               
                return this.weight - e.weight;
        }
       
}