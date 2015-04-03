/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm10115 {

 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  String line;
  String[] find, replaceBy;
  int i, caseNum;
  while ((line = in.readLine()) != null) {
   caseNum = Integer.parseInt(line);

   if (caseNum == 0) {
    System.exit(0);
   }

   find = new String[caseNum];
   replaceBy = new String[caseNum];

   for (i = 0; i < caseNum; i++) {
    find[i] = line = in.readLine();
    replaceBy[i] = line = in.readLine();
   }

   line = in.readLine();

   for (i = 0; i < caseNum; i++) {
    while (line.indexOf(find[i]) >= 0) {
     line = line.replaceFirst(find[i], replaceBy[i]);
    }
   }

   System.out.println(line);
  }
 }
}
