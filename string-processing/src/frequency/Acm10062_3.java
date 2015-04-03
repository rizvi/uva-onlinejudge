/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frequency;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10062_3 {
    public static void main(String[] args) throws Throwable {
		   Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("10062.txt"));
        int caso = 0;
        while (sc.hasNext()) {
            String ln = sc.nextLine();
            if (caso++ > 0) {
                System.out.println();
            }
            int[] arr = new int[256];
            Arrays.fill(arr, Integer.MAX_VALUE);
            char[] st = ln.toCharArray();
            for (int i = 0; i < st.length; i++) {
                arr[st[i]] = arr[st[i]] == Integer.MAX_VALUE ? 1 : arr[st[i]] + 1;
            }
            int[] mm = arr.clone();
            Arrays.sort(mm);
            for (int i = 0; i < mm.length && mm[i] < Integer.MAX_VALUE; i++) {
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (arr[j] == mm[i]) {
                        System.out.println(j + " " + mm[i]);
                        arr[j] = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
        }
    }
}
