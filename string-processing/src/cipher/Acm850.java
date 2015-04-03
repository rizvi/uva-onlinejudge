/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 850
 * @problemName Crypt Kicker II
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 14/12/2010
 *
 */
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;

public class Acm850 {

    public static void main(String[] args) throws Throwable {
        char[] arr = "the quick brown fox jumps over the lazy dog".toCharArray();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader in = new BufferedReader(new FileReader(new File("850.txt")));
        StringBuilder sb = new StringBuilder();
        for (int c = 0, C = parseInt(in.readLine().trim()); c < C; c++) {
            if (c == 0) {
                in.readLine();
            }
            ArrayList<char[]> strs = new ArrayList<char[]>();
            for (String ln; (ln = in.readLine()) != null && !ln.equals("");) {
                strs.add(ln.toCharArray());
            }
            TreeMap<Character, Character> encript = null;
            for (char[] str : strs) {
                if (str.length == arr.length) {
                    TreeMap<Character, Character> encriptTemp = new TreeMap<Character, Character>();
                    int i = 0;
                    for (; i < str.length; i++) {
                        if (str[i] == ' ' && arr[i] != ' ') {
                            break;
                        }
                        if (str[i] != ' ') {
                            if (!encriptTemp.containsKey(str[i])) {
                                encriptTemp.put(str[i], arr[i]);
                            } else if (encriptTemp.get(str[i]) != arr[i]) {
                                break;
                            }
                        }
                    }
                    if (i == str.length) {
                        encript = encriptTemp;
                        break;
                    }
                }
            }
            if (encript == null) {
                sb.append("No solution.\n");
            } else {
                for (char[] str : strs) {
                    for (int i = 0; i < str.length; i++) {
                        if (encript.containsKey(str[i])) {
                            sb.append(encript.get(str[i]));
                        } else {
                            sb.append(str[i]);
                        }
                    }
                    sb.append("\n");
                }
            }
            if (c < C - 1) {
                sb.append("\n");
            }
        }
        System.out.print(new String(sb));
    }
}