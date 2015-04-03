/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acm531 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			String line = buf.readLine();
			if (line == null)
				break;
			ArrayList<String> lis1 = new ArrayList<String>();
			ArrayList<String> lis2 = new ArrayList<String>();
			while (!line.equals("#")) {
				StringTokenizer str = new StringTokenizer(line);
				while (str.hasMoreTokens())
					lis1.add(str.nextToken());
				line = buf.readLine();
			}
			line = buf.readLine();
			while (!line.equals("#")) {
				StringTokenizer str = new StringTokenizer(line);
				while (str.hasMoreTokens())
					lis2.add(str.nextToken());
				line = buf.readLine();
			}
			int n = lis1.size();
			int m = lis2.size();
			int[][] dp = new int[n][m];
			int[][] best = new int[n][m];

			for (int i = 0; i < dp.length; i++)
				Arrays.fill(dp[i], -1);
			go(dp, best, 0, 0, lis1, lis2);
			ArrayList<String> lis = getAnswer(best, lis1, lis2);

			StringBuilder ans = new StringBuilder("");
			for (int i = 0; i < lis.size(); i++)
				ans.append(" " + lis.get(i));
			System.out.println(ans.substring(1));

		}
	}

	private static int go(int[][] dp, int[][] best, int i, int j,
			ArrayList<String> lis1, ArrayList<String> lis2) {
		if (i == lis1.size() || j == lis2.size())
			return 0;
		else if (dp[i][j] != -1)
			return dp[i][j];
		else {
			int max = 0;
			if (lis1.get(i).equals(lis2.get(j))) {
				best[i][j] = 1;
				max = 1 + go(dp, best, i + 1, j + 1, lis1, lis2);
			} else {
				int x = go(dp, best, i + 1, j, lis1, lis2);
				int y = go(dp, best, i, j + 1, lis1, lis2);
				if (x > y) {
					max = x;
					best[i][j] = 2;
				} else {
					max = y;
					best[i][j] = 3;
				}

			}
			return dp[i][j] = max;
		}
	}

	private static ArrayList<String> getAnswer(int[][] best,
			ArrayList<String> lis1, ArrayList<String> lis2) {
		ArrayList<String> list = new ArrayList<String>();
		int i = 0;
		int j = 0;
		while (i < lis1.size() && j < lis2.size()) {
			if (best[i][j] == 1) {
				list.add(lis1.get(i));
				i++;
				j++;
			} else if (best[i][j] == 2) {
				i++;
			} else {
				j++;
			}
		}
		return list;
	}
}

