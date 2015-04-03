
/**
 *  The task is to find the count of rooted labeled binary trees on N vertices.
[edit] Explanation

Counts of unlabeled rooted binary trees with N vertices are exactly the famous Catalan numbers, i.e.,
.
Once we have an unlabeled rooted binary tree with N vertices, there are exactly N! ways to add the labels. We can do this for each of the trees, thus the final answer is given by the formula
.
[edit] Implementations

As the example I/O shows, this is intended to be a BigNum problem. You only need to implement integer multiplication, as the answer can be obtained by multiplying the numbers (N+2) to 2N.
As the set of possible inputs is limited, it is possible to precompute the answers in some scripting language that supports big integers (Python, bc) and submit a program that has the answers hard-wired as string constants.
 * @author Masudul Haque
 */
package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Acm10007 {
    public static void main(String[] args) throws IOException{
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("10007.txt")));
        while(true){
            int n=Integer.parseInt(buff.readLine());
            if(n==0){
                break;
            }
            BigInteger fact=BigInteger.ONE;
            for (int i = n+2; i <=2*n; i++) {
                fact=fact.multiply(BigInteger.valueOf(i));
            }
            System.out.println(fact);
        }
    }
}
