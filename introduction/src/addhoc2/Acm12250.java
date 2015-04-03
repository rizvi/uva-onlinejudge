/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acm12250 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        int i = 1;
        String m = "";
        while (true) {
            m = br.readLine();
            if (m.equals("#")) {
                break;
            }
            sb.append("Case ").append(i).append(": ").append(getStr(m)).append("\n");
            i++;
        }
        System.out.print(sb);
    }

    static String getStr(String x) {
        if (x.equals("HELLO")) {
            return "ENGLISH";
        }
        if (x.equals("HOLA")) {
            return "SPANISH";
        }
        if (x.equals("HALLO")) {
            return "GERMAN";
        }
        if (x.equals("BONJOUR")) {
            return "FRENCH";
        }
        if (x.equals("CIAO")) {
            return "ITALIAN";
        }
        if (x.equals("ZDRAVSTVUJTE")) {
            return "RUSSIAN";
        }
        return "UNKNOWN";
    }
}