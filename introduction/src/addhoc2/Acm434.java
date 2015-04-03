/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class Acm434 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 0, T = parseInt(in.readLine().trim()); t++ < T;) {
            int N = parseInt(in.readLine().trim());
            int arr[][] = new int[N][2];
            long s1 = 0, s3 = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = 0; i < N; i++) {
                s1 += (arr[i][0] = parseInt(st.nextToken()));
                Integer s = map.get(arr[i][0]);
                if (s == null) {
                    s = 0;
                }
                s++;
                map.put(arr[i][0], s);
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i][1] = parseInt(st.nextToken());
                if (map.containsKey(arr[i][1])) {
                    int s = map.get(arr[i][1]);
                    if (s == 1) {
                        map.remove(arr[i][1]);
                    } else {
                        map.put(arr[i][1], s--);
                    }
                } else {
                    s1 += arr[i][1];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    s3 += min(arr[i][0], arr[j][1]);
                }
            }
            sb.append("Matty needs at least " + s1 + " blocks, and can add at most " + (s3 - s1) + " extra blocks.\n");
        }
        System.out.print(new String(sb));
    }
}