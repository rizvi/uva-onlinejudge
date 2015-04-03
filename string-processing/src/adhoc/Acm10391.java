/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm10391 {

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            inputList.add(sc.nextLine());
            Collections.sort(inputList);

            for (int i = 0; i < inputList.size() - 1; i++) {
                String string = inputList.get(i);
                String compStr = inputList.get(i + 1);
                if (compStr.startsWith(string)) {
                    System.out.println(compStr);
                }
            }
        }
    }
}
