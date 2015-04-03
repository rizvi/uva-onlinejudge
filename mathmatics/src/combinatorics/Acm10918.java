/*
 It's a typical problem on dynamic programming. One possible solution is described below.
Let f(n) be the number of tilings of a 3xN rectangle (which is what we're looking for) and let g(n) denote the number of tilings of a 3xN rectangle with one of its corner squares removed.
These functions satisfy the recurrent relations: f(n) = f(n - 2) + 2g(n - 1),g(n) = f(n - 1) + g(n - 2). The formulas can be illustrated as follows:
********   AA*******   AA******   A*******
******** = BB******* + B******* + A*******
********   CC*******   B*******   BB******
  f(n)   =  f(n-2)   +  g(n-1)  +  g(n-1)

********   A********   AA*******
******** = A******** + BB*******
 *******    ********    CC******
  g(n)   =   f(n-1)  +   g(n-2)
The boundary values for the relations are: f(0) = 1,f(1) = 0,g(0) = 0,g(1) = 1.
For any odd value of N, the number of tilings of a 3xN rectangle is 0.
 */
package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        long arr[] = new long[31];
        long arr2[] = new long[31];
        arr[0] = arr2[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + 2 * arr2[i - 1];
            arr2[i] = arr[i - 1] + arr2[i - 2];
        }
        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x < 0) {
                break;
            }
            if (x % 2 == 1) {
                sb.append("0\n");
            } else {
                sb.append(arr2[x] + arr[x]).append("\n");
            }
        }
        System.out.print(sb);
    }
}