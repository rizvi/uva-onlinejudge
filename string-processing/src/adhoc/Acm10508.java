/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;
/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10508
 * @problemName Word Morphing
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 22/12/2010
 **/
import static java.lang.Integer.*;
import java.io.*;
import java.util.*;
public class Acm10508 {
	static int getDiferencias(char[] str1, char[] str2){
		int res = 0;
		for (int i = 0; i < str1.length; i++) {if(str1[i]!=str2[i])res++;if(res>=2)break;}
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(String ln; (ln = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln.trim());
			int N = parseInt(st.nextToken());
			ArrayList<char[]> arr = new ArrayList<char[]>();
			for (int i = 0; i < N; i++) 
				arr.add(in.readLine().trim().toCharArray());
			char[] ant = arr.get(0);
			arr.remove(0);
			sb.append(new String(ant) + "\n");
			for (; arr.size() > 0; ) {
				for(int i = 0; i < arr.size(); i++)
					if(getDiferencias(ant, arr.get(i))==1){
						ant = arr.get(i);
						arr.remove(i);
						sb.append(new String(ant) + "\n");
						break;
					}
			}
		}
		System.out.print(new String(sb));
	}
}