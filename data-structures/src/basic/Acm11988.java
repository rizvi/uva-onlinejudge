/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;
/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId 11988
 * @problemName Broken Keyboard (a.k.a. Beiju Text)
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 27/03/2012
 **/
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;
public class Acm11988{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			int p=0;
			char[] a=ln.toCharArray();
			ArrayList<Character> res=new ArrayList<Character>();
			for(char ch:a)
				if(ch=='[')p=0;
				else if(ch==']')p=res.size();
				else res.add(p++,ch);
			String r="";
			for(char ch:res)r+=ch;
			sb.append(r+"\n");
		}
		System.out.print(new String(sb));
	}
}
