/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Acm10282{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		Map words = new HashMap();
		while (!S.matches("")) {
			String[] Split = S.split(" ");
			words.put(Split[1], Split[0]);
			S = br.readLine();
		}
		S = br.readLine();
		boolean found = false;
		while (S != null) {
			found = false;
			if (words.containsKey(S)) {
				found = true;
				System.out.println(words.get(S));
			}
			if (!found)
				System.out.println("eh");
			S = br.readLine();
		}
	}
}
