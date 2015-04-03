/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Masudul Haque
 */
public class Acm422 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		int n = Integer.parseInt(buf.readLine());
		while (n != 0) {
			char[][] grid = new char[n][n];
			String line;
			for (int i = 0; i < n; i++) {
				line = buf.readLine();
				grid[i] = line.toCharArray();
			}
			line = buf.readLine();
			while (!(line.charAt(0) >= '0' && line.charAt(0) <= '9')) {
				int[] ans = find(grid, line);
				if (ans == null)
					System.out.println("Not found");
				else
					System.out.println((ans[0]+1) + "," + (ans[1]+1) + " " + (ans[2]+1)
							+ "," + (ans[3]+1));
				line = buf.readLine();
			}
			n = Integer.parseInt(line);
		}
	}

	private static int[] find(char[][] grid, String in) {
		int n = in.length();

		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				String one = "";
				String two = "";
				String three = "";
				String four = "";
				for (int k = 0; k < n; k++) {
					if (k + j < grid[0].length) {
						one += grid[i][j + k];
					}
					if (k + j < grid[0].length && k + i < grid.length) {
						two += grid[k + i][k + j];
					}
					if (k + i < grid.length) {
						three += grid[i + k][j];
					}
					if (j - k >= 0 && i + k < grid.length) {
						four += grid[i + k][j - k];
					}
				}
				if (one.equalsIgnoreCase(in))
					return new int[] { i, j, i, j + n - 1 };
				if (two.equalsIgnoreCase(in))
					return new int[] { i, j, i + n - 1, j + n - 1 };
				if (three.equalsIgnoreCase(in))
					return new int[] { i, j, i + n - 1, j };
				if (four.equalsIgnoreCase(in))
					return new int[] { i, j, i + n - 1, j - n + 1 };
				else {
					one = reverse(one);
					if (one.equalsIgnoreCase(in))
						return new int[] { i, j + n - 1, i, j };
					two = reverse(two);
					if (two.equalsIgnoreCase(in))
						return new int[] { i + n - 1, j + n - 1, i, j };
					three = reverse(three);
					if (three.equalsIgnoreCase(in))
						return new int[] { i + n - 1, j, i, j };
					four = reverse(four);
					if (four.equalsIgnoreCase(in))
						return new int[] { i + n - 1, j - n + 1, i, j };
				}
			}
		return null;
	}

	private static String reverse(String one) {
		String tmp = "";
		for (int i = 0; i < one.length(); i++)
			tmp = one.charAt(i) + tmp;
		return tmp;
	}

}