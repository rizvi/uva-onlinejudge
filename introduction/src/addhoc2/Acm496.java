/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

/**
 *
 * @author Masudul Haque
 */
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class Acm496 {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null;) {
            StringTokenizer st = new StringTokenizer(ln);
            TreeSet<Integer> A = new TreeSet<Integer>(), B = new TreeSet<Integer>(), cA = new TreeSet<Integer>(), cB = new TreeSet<Integer>();
            for (; st.hasMoreTokens();) {
                A.add(parseInt(st.nextToken()));
            }
            st = new StringTokenizer(in.readLine());
            for (; st.hasMoreTokens();) {
                B.add(parseInt(st.nextToken()));
            }
            cA = (TreeSet<Integer>) A.clone();
            cB = (TreeSet<Integer>) B.clone();
            A.removeAll(cB);
            B.removeAll(cA);
            if (A.size() == 0 && B.size() == 0) {
                System.out.println("A equals B");
            } else if (A.size() == 0) {
                System.out.println("A is a proper subset of B");
            } else if (B.size() == 0) {
                System.out.println("B is a proper subset of A");
            } else if (A.size() == cA.size() && B.size() == cB.size()) {
                System.out.println("A and B are disjoint");
            } else {
                System.out.println("I'm confused!");
            }
        }
    }
}
