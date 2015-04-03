/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justaddhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Acm789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        StringBuilder temp = new StringBuilder("");
        String m = "";
        char c = (char) br.read();
        br.readLine();
        HashSet<String> hs = new HashSet<String>();
        LinkedList<StrInd> list = new LinkedList<StrInd>();
        int counter = 1;
        while ((m = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(m);
            int n = st.countTokens();
            for (int i = 0; i < n; i++) {
                String strID = st.nextToken();
                StringBuilder tempS = new StringBuilder();
                for (int j = 0; j < strID.length(); j++) {
                    if (strID.charAt(j) >= 'A' && strID.charAt(j) <= 'Z') {
                        tempS.append(strID.charAt(j));
                    }
                }
                if (tempS.charAt(0) == c) {
                    if (!hs.contains(tempS.toString())) {
                        hs.add(tempS.toString());
                        list.add(new StrInd(tempS.toString(), counter));
                    } else {
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).temp.equals(tempS.toString())) {
                                list.get(j).insert(counter);
                            }
                        }
                    }
                }
            }
            counter++;
        }
        StrInd[] arr = new StrInd[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].temp);
            sb.append(arr[i].getInd());
        }
        System.out.print(sb);
    }
}

class StrInd implements Comparable<StrInd> {

    public String temp;
    LinkedList<Integer> index;

    public StrInd(String temp, int x) {
        this.temp = temp;
        index = new LinkedList<Integer>();
        index.add(x);
    }

    public void insert(int i) {
        if (!index.contains(i)) {
            index.add(i);
        }
    }

    public String getInd() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < index.size(); i++) {
            sb.append(" ").append(index.get(i));
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(StrInd x) {
        return this.temp.compareTo(x.temp);
    }
}