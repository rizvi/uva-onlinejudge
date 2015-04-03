/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suffix;

import java.util.Arrays;
import java.util.Scanner;

public class Acm11283 {

    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int score;
    static boolean taken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 1; i <= tests; i++) {
            char[][] grid = new char[4][4];
            String line;
            for (int j = 0; j < 4; j++) {
                line = sc.next();
                grid[j] = line.toCharArray();
            }
            int q = sc.nextInt();
            String[] in = new String[q];
            for (int j = 0; j < q; j++) {
                in[j] = sc.next();
            }
            Arrays.sort(in);
            for (int j = 0; j < q - 1; j++) {
                if (in[j].equals(in[j + 1])) {
                    in[j] = "";
                }
            }
            score = 0;
            for (int j = 0; j < q; j++) {
                if (in[j].length() != 0) {
                    boolean check = true;
                    boolean[][] v = new boolean[4][4];
                    for (int l = 0; l < 4 && check; l++) {
                        for (int k = 0; k < 4 && check; k++) {
                            if (grid[l][k] == in[j].charAt(0)) {
                                v[l][k] = true;
                                int x = score;
                                taken = false;
                                find(l, k, grid, in[j], v, 1);
                                v[l][k] = false;
                                if (x != score) {
                                    check = false;
                                }
                            }
                        }
                    }
                }
            }
            System.out.printf("Score for Boggle game #%d: %d\n", i, score);

        }

    }

    private static void find(int i, int j, char[][] grid, String s,
            boolean[][] v, int index) {
        if (index == s.length()) {
            taken = true;
            if (index == 3 || index == 4) {
                score += 1;
            } else if (index == 5) {
                score += 2;
            } else if (index == 6) {
                score += 3;
            } else if (index == 7) {
                score += 5;
            } else {
                score += 11;
            }

        } else {
            for (int d = 0; d < 8; d++) {
                if (check(i + dy[d], j + dx[d], grid, s, v, index)) {
                    find(i + dy[d], j + dx[d], grid, s, v, index + 1);
                    if (taken) {
                        break;
                    }
                    v[i + dy[d]][j + dx[d]] = false;
                }
            }
        }
    }

    private static boolean check(int i, int j, char[][] grid, String s,
            boolean[][] v, int index) {
        if (i >= 4 || i < 0 || j >= 4 || j < 0 || v[i][j]
                || grid[i][j] != s.charAt(index)) {
            return false;
        } else {
            v[i][j] = true;
            return true;
        }
    }
}