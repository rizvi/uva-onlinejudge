/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Masudul Haque
 */
public class p1062 {
    static boolean[] v;
    static int[] pair;
    static LinkedList<Integer>[] G;
 
    public static int path(int i) {
        if (v[i])
            return 0;
        v[i] = true;
        for (int j : G[i])
            if (pair[j] == -1 || path(pair[j]) != 0) {
                pair[j] = i;
                return 1;
            }
        return 0;
    }
 
    public static int match() {
        int match = 0;
        Arrays.fill(pair, -1);
        for (int i = 0; i < G.length; i++) {
            Arrays.fill(v, false);
            match += path(i);
        }
        return match;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        v = new boolean[1005];
        pair = new int[1005];
        int cc = 1;
        while (true) {
            char[] arr = in.readLine().trim().toCharArray();
            if (arr.length == 3 && arr[0] == 'e' && arr[1] == 'n'
                    && arr[2] == 'd')
                return;
            G = new LinkedList[arr.length];
            for (int i = 0; i < G.length; i++) {
                G[i] = new LinkedList<Integer>();
                for (int j = i + 1; j < arr.length; j++)
                    if (arr[j] <= arr[i])
                        G[i].add(j);
 
            }
            System.out.printf("Case %d: %d\n", cc++, arr.length - match());
        }
    }
}
