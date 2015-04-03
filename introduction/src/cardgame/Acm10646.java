/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Acm10646 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());

		for (int i = 0; i < t; i++) {
			int y = 0, x = 0, remove = 0;
			;
			String newLine = in.readLine();
			String h = newLine.substring(0, 74);

			int finall = 74;
			for (int j = 0; j < 3; j++) {
				h = h.substring(remove * 3, finall);
				finall -= remove * 3;
				Character xChar = h.substring(0, newLine.indexOf(' '))
						.charAt(0);
				if (Character.isDigit(xChar)) {
					String s = xChar.toString();
					x = Integer.parseInt(s);
				} else {
					x = 10;
				}

				y += x;
				remove = 1 + (10 - x);
			}

			finall -= remove * 3;
			String result = newLine.substring(74 - finall, 155);

			String ans = result.substring((y - 1) * 3, (y) * 3 - 1);
			System.out.println("Case " + (i + 1) + ": " + ans);
		}
	}
}

 