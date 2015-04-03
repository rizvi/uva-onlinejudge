/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progchallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Acm10150 {
	static HashSet<String>  inp = new HashSet<String>();
	static class node{
		String str;
		node parent;
	}
	static Stack<String> isFound(String st, String end){
		Stack<String> ans = null;
		HashSet<String> set = new HashSet<String>();
		Queue<node> q = new LinkedList<node>();
		node start = new node();
		start.str = st;
		start.parent = null;
		set.add(st);
		q.add(start);
		while(!q.isEmpty()){
			node cur = q.poll();
			String S = cur.str;
			char [] ch = S.toCharArray();
			char [] back = S.toCharArray();
			if(S.equals(end)){
				ans = new Stack<String>();
				while(cur != null){
					ans.add(cur.str);
					cur = cur.parent;
				}
				return ans;
			}
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < 26; j++) {
					ch[i] =(char) (j+'a');
					String t = new String(ch);
					if(ch[i] != back[i] && inp.contains(t) && !set.contains(t)){
						node n = new node();
						n.str = t;
						n.parent = cur;
						set.add(t);
						q.add(n);
					}
				}
				ch[i] = back[i];
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		String l;
		String [] sp;
		boolean f = true;
		while(!(l = br.readLine()).equals("")){
			inp.add(l);
		}
		while((l = br.readLine()) != null){
			if(!f)
				out.append("\n");
			f = false;
			sp = l.split(" ");
			if(sp[0].length() != sp[1].length() || !inp.contains(sp[0]) || !inp.contains(sp[1])){
				out.append("No solution.\n");
			}else{
				Stack<String> ans = isFound(sp[0], sp[1]);
				if(ans != null){
					while(!ans.isEmpty()){
						out.append(ans.pop() + "\n");
					}
				}else{
					out.append("No solution.\n");
				}
			}
		}
		System.out.print(out);
	}
}
