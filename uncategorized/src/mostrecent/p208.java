/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrecent;

/**
 *
 * @author Masudul Haque
 */
import java.util.Scanner;
 
public class p208 {
    static boolean[][] matrix;
    static boolean[] canVisit;
    static int counter;
 
    public static void dfs(int n, int max) {
        canVisit[n] = true;
        for (int i = 1; i <= max; i++)
            if (matrix[n][i] && !canVisit[i])
                dfs(i, max);
    }
 
    public static void generatePath(String path, int s, int e, int v, int max) {
        if (canVisit[s]) {
            if (s == e) {
                counter++;
                System.out.println(path);
            }
            for (int i = 1; i <= max; i++)
                if ((v & (1 << i)) == 0 && matrix[s][i])
                    generatePath(path + " " + i, i, e, v | (1 << i), max);
        }
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int index = 1;
        while (in.hasNext()) {
            int n = in.nextInt();
            int max = 0;
            matrix = new boolean[22][22];
            canVisit = new boolean[22];
            counter = 0;
            int e1 = in.nextInt();
            int e2 = in.nextInt();
            while (e1 != 0 || e2 != 0) {
                matrix[e1][e2] = matrix[e2][e1] = true;
                e1 = in.nextInt();
                e2 = in.nextInt();
                max = Math.max(Math.max(e1, e2), max);
            }
            dfs(n, max);
            System.out.println("CASE " + (index++) + ":");
            generatePath("1", 1, n, 2, max);
            System.out
                    .println("There are " + counter
                            + " routes from the firestation to streetcorner "
                            + n + ".");
        }
    }
}