/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatorics;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 11310
 * @problemName Delivery Debacle
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 26/04/2010
 *
 */
import java.util.*;

public class Acm11310 {

    public static void main(String[] args) {
        long[] res = new long[41];
        res[0] = res[1] = 1;
        res[2] = 5;
        for (int i = 3; i < res.length; i++) {
            res[i] = 2 * res[i - 3] + 4 * res[i - 2] + res[i - 1];
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0, N = sc.nextInt(); i < N; i++) {
            System.out.println(res[sc.nextInt()]);
        }
    }
}