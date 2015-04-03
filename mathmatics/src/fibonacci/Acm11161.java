/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Acm11161 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		BigInteger[] fib = new BigInteger[1501];
		fib[0] = new BigInteger("0");
		fib[1] = new BigInteger("1");
		fib[2] = new BigInteger("1");
		for (int i = 3; i <= 1500; i++)
			fib[i] = fib[i - 1].add(fib[i - 2]);
		int index=1;
		while (true) {
			int n = Integer.parseInt(buf.readLine());
			if (n == 0)
				break;
			BigInteger sum = new BigInteger("0");
			for (int i = 0; i < n; i++)
				sum = sum.add(fib[i]);

			if (fib[n].mod(new BigInteger("2")).equals(fib[0]))
				sum = sum.add(fib[n].divide(fib[3]));
			else {
				sum = sum.add((fib[n].add(fib[1])).divide(fib[3]));

			}
			System.out.println("Set "+index+":");
			index++;
			System.out.println(sum.subtract(fib[1]));

		}
	}
}

