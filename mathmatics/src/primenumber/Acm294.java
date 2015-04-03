/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm294 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int tests = in.nextInt(); // read the number of tests

        // for each test
        for (int test = 0; test < tests; test++) {


            int L = in.nextInt(), // read L
                    U = in.nextInt(), // read U
                    maxDivisorCount = 0, // the maximum divisor count found
                    maxNumber = 0;       // the number with the maximum divisor count

            // loop through the numbers
            for (int i = L; i <= U; i++) {

                // the divisor count of the current number
                // the divisorCount function calculates it for us
                int currentDivisorCount = divisorCount(i);

                // if the current divisor count is larger than
                // the largest divisor count (a contradiction),
                // then the current divisor count is the
                // largest divisor count
                if (currentDivisorCount > maxDivisorCount) {

                    // update appropriate variables
                    maxDivisorCount = currentDivisorCount;
                    maxNumber = i;
                }
            }

            // output the result in the correct format
            out.printf("Between %d and %d, %d has a maximum of %d divisors.\n", L, U, maxNumber, maxDivisorCount);
        }
    }

    public static int divisorCount(int n) {
        if (n == 1) // 1 is a tricky number,
        {
            return 1;  // so we'll handle it separately
        }
        // a counter for the number of divisors
        int count = 0;

        // save the square root to avoid re-computation
        int sqrt = (int) Math.sqrt(n);

        // loop through 1..sqrt(n)
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) // if the remainder of n divided by i is 0
            {
                count += 2; // then i and n/i are divisors of n
            }
        }
        // if n is a square number, then
        // we counted sqrt(n) twice
        if (sqrt * sqrt == n) {
            count--; // so we fix the count
        }
        // return the number of divisors
        return count;
    }
}
