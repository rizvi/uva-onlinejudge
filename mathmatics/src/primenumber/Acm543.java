/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.util.Scanner;

public class Acm543{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		while (N != 0) {
			int maxPrime = getPrime(N);
			int minPrime = N - maxPrime;
			boolean flag = CheckPrime(minPrime);
			while (!flag) {
				maxPrime = getPrime(maxPrime - 1);
				minPrime = N - maxPrime;
				flag = CheckPrime(minPrime);
			}
			System.out.printf("%d = %d + %d\n", N, minPrime, maxPrime);
			N = input.nextInt();
		}
	}

	private static int getPrime(int N) {
		boolean f = true;
		int number = 0;
		for (int i = N - 1; i >= 2 && f; i -= 2) {
			boolean flag = true;
			for (int j = 2; j <= i - 1 && flag; j++) {
				if (i % j == 0) {
					flag = false;
				}
			}
			if (flag) {
				f = false;
				number = i;
			}
		}
		return number;
	}

	private static boolean CheckPrime(int N) {
		boolean flag = true;
		if (N < 2)
			flag = false;
		for (int j = 2; j <= N - 1 && flag; j++) {
			if (N % j == 0) {
				flag = false;
			}
		}
		return flag;
	}
}
