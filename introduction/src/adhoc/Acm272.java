/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm272 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream(new File("in.txt")));

        boolean isFirst = true;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '"' && isFirst) {
                    sb.append("``");
                    isFirst = false;
                } else if (ch == '"' && !isFirst) {
                    sb.append("''");
                    isFirst = true;
                } else {
                    sb.append(ch);
                }
            }
            System.out.println(sb);
        }
    }
}
