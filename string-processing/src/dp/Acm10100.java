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

public class Acm10100 {
	static String s1 = "", s2 = "";
	static ArrayList<String> first, second;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(
				System.in));
		int cc = 1;
		while ((s1 = buff.readLine()) != null) {
			s2 = buff.readLine();
			if (s1.length() == 0 || s2.length() == 0) {
				System.out.printf("%2d. Blank!\n", cc);
			} else {
				first = new ArrayList<String>();
				second = new ArrayList<String>();
				StringBuilder p1 = new StringBuilder(s1);
				StringBuilder p2 = new StringBuilder(s2);
				for (int i = 0; i < p1.length(); i++) {
					char curr = p1.charAt(i);
					if (!(curr >= 'a' && curr <= 'z')
							&& !(curr >= 'A' && curr <= 'Z')
							&& !(curr >= '0' && curr <= '9') && curr != ' ') {
						p1 = p1.insert(i, " ");
						p1 = p1.deleteCharAt(i + 1);
					}

				}
				s1 = p1.toString().trim();

				for (int i = 0; i < p2.length(); i++) {
					char curr = p2.charAt(i);
					if (!(curr >= 'a' && curr <= 'z')
							&& !(curr >= 'A' && curr <= 'Z')
							&& !(curr >= '0' && curr <= '9') && curr != ' ') {
						p2 = p2.insert(i, " ");
						p2 = p2.deleteCharAt(i + 1);
					}

				}
				s2 = p2.toString().trim();
				StringTokenizer st = new StringTokenizer(s1);
				while (st.hasMoreTokens())
					first.add(st.nextToken());

				st = new StringTokenizer(s2);
				while (st.hasMoreTokens())
					second.add(st.nextToken());

				dp = new int[first.size()][second.size()];
				for (int j = 0; j < first.size(); j++)
					Arrays.fill(dp[j], -1);

				System.out.printf("%2d. Length of longest match: %d\n", cc,
						LCS(0, 0));
			}
			cc++;
		}
	}

	private static int LCS(int i, int j) {
		if (i == first.size() || j == second.size())
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (first.get(i).equals(second.get(j))) {
			return dp[i][j] = 1 + LCS(i + 1, j + 1);
		} else {
			return dp[i][j] = Math.max(LCS(i, j + 1), LCS(i + 1, j));
		}
	}
}

