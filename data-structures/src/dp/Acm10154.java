/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Using Dynamic Programming;
 * dp[i][j] represents: get the minimum weight of choosing j turtles from first
 * ith turtles;
 * 
 * For this problem, the list requires to be sorted first, let the turtle with
 * max-weight and min-weight located at the last.
 */

/**
 * @author antonio081014
 * @since Feb 3, 2012, 6:30:30 PM
 */
public class Acm10154 {
    public static List<Turtle> list;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(solve());
    }

     static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<Turtle>();
        String strLine;
        while ((strLine = br.readLine()) != null) {
            String[] str = strLine.split(" ");
            int w = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]) - w;
            list.add(new Turtle(w, s));
        }
    }

    public static int solve() {
        Collections.sort(list);
        // for (int i = 0; i < list.size(); i++)
        // System.out
        // .println(list.get(i).weight + ", " + list.get(i).strength);
        int N = list.size();
        int[][] dp = new int[N][N + 1];
        for (int i = 0; i < N; i++)
            for (int j = 0; j <= N; j++)
                dp[i][j] = (j == 0 ? 0 : Integer.MAX_VALUE);
        dp[0][1] = list.get(0).weight;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i + 1; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                if (list.get(i).strength > dp[i - 1][j - 1]) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i - 1][j - 1] + list.get(i).weight);
                }
            }
        }
        for (int i = N; i >= 0; i--)
            if (dp[N - 1][i] != Integer.MAX_VALUE)
                return i;
        return 0;
    }
}

class Turtle implements Comparable<Turtle> {
    public int weight;
    public int strength;

    public Turtle(int w, int s) {
        this.weight = w;
        this.strength = s;
    }

    @Override
    public int compareTo(Turtle o) {
        if (this.strength == o.strength)
            return this.weight - o.weight;
        return (this.strength) - (o.strength);
    }
}