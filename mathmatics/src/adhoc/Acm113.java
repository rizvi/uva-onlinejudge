/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

public class Acm113 {
    public static void main(String[] args) throws Throwable {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		while (true) {
//			String str = in.readLine();
//			if (str == null || str.equals(""))
//				break;
//			int n = Integer.parseInt(str.trim());
//			double x = Double.parseDouble(in.readLine().trim());
//                        
//			System.out.println(Math.round(Math.pow(x, 1.0/n)));
//		}

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double p = sc.nextDouble(); //Int is not enough for big input
            double res = Math.pow(p, 1.0 / n);//1.0 should use not 1 for divide.
            System.out.println(Math.round(res));//for higher fraction result should be rounding for int output.

        }
    }
}