/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm11069 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        int[] arr = new int[77];
        arr[1] = 1;
        arr[2] = arr[3] = 2;
        for (int i = 4; i < 77; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        String m = "";
        while ((m = br.readLine()) != null) {
            int x = Integer.parseInt(m);
            sb.append(arr[x]).append("\n");
        }
        System.out.print(sb);
    }
}