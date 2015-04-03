/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Acm12085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        int i = 1;
        String m = "";
        while (true) {
            m = br.readLine();
            if (m.equals("0")) {
                break;
            }
            sb.append("Case ").append(i).append(":").append("\n");
            int []arr=new int[Integer.parseInt(m)];
            for(int j=0;j<arr.length;j++){
                arr[j]=Integer.parseInt(br.readLine());
            }
            sb.append(res(arr));
            sb.append("\n");
            i++;
        }
        System.out.print(sb);
    }

    static String res(int[] values) {
      if (values.length == 0) {
        return "";
      }
      StringBuilder sb=new StringBuilder("");
      boolean first = false;
      int begin = values[0];

      sb.append("0").append(values[0]);

      for (int i = 1 ; i < values.length; i++) {
        if (values[i] - values[i-1] == 1) {
          first = true;
          continue;
        } else {
          if (first) {
            sb.append(checkDiff(begin+"", values[i-1]+""));
          } else {
            sb.append("\n");
          }
          first = false;
          begin = values[i];
          sb.append("0").append(values[i]);
        }
      }

      if (first) {
          sb.append(checkDiff(begin+"", values[values.length-1]+""));
      } else {
        sb.append("\n");
      }
      return sb.toString();
    }
      
    static String checkDiff(String x, String y) {
        int index = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                index = i;
                break;
            }
        }
        return "-"+y.substring(index)+"\n";
    }

}