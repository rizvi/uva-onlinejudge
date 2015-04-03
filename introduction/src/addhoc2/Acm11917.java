/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Acm11917 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        int cases = Integer.parseInt(br.readLine());
        StringBuilder temp = new StringBuilder("");
        for (int i = 1; i < cases+1; i++) {
            ArrayList<String> subjects = new ArrayList<String>();
            int n = Integer.parseInt(br.readLine());
            int[] daysTaken = new int[n];
            for (int j = 0; j < n; j++) {
                String[] str = br.readLine().split(" ");
                subjects.add(str[0]);
                daysTaken[j] = Integer.parseInt(str[1]);
            }
            int d = Integer.parseInt(br.readLine());
            String newSub = br.readLine();
            sb.append("Case ").append(i).append(": ");
            if (subjects.contains(newSub)) {
                int index = subjects.indexOf(newSub);
                if (daysTaken[index]<=d) {
                    sb.append("Yesss").append("\n");
                } else if (daysTaken[index]<=d+5) {
                    sb.append("Late").append("\n");
                } else {
                    sb.append("Do your own homework!").append("\n");
                }
            } else {
                sb.append("Do your own homework!").append("\n");
            }
        }
        System.out.print(sb);
    }
}

