/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class p12583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("12583.txt")));
        int testCases = Integer.parseInt(br.readLine());
        int cases = 0;

        while (testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
            String str = input[2];
            int ret = 0;
            int vis[] = new int[26 + 5];
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if (vis[ch - 'A']> 0) {
                    ret++;
                }
                vis[ch - 'A']++;

                if (i - k >= 0) {
                    vis[str.charAt(i - k) - 'A']--;
                }
            }
            System.out.printf("Case %d: %d\n", ++cases, ret);

        }
    }
}
