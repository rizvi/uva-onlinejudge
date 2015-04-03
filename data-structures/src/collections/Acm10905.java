/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Acm10905 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();

			if (n == 0)
				break;
			obj[] num = new obj[n];
			for (int i = 0; i < n; i++)
				num[i] = new obj(sc.next());
			Arrays.sort(num);
			String ans = "";
			for (int i = 0; i < n; i++)
				ans += num[i].s;
			System.out.println(ans);

		}
	}

	static class obj implements Comparable<obj> {
		String s;

		public obj(String s) {
			this.s = s;

		}

		@Override
		public int compareTo(obj arg0) {
			// TODO Auto-generated method stub
			int i = 0;
			int j = 0;

			while (i < s.length() && j < arg0.s.length()) {
				if (s.charAt(i) != arg0.s.charAt(j))
					return -s.charAt(i) + arg0.s.charAt(j);
				i++;
				j++;
			}
			BigInteger bd = new BigInteger(s + arg0.s);
			return -1 * bd.compareTo(new BigInteger(arg0.s + s));
		}
	}

}

