/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.math.BigInteger;
import java.util.Scanner;
 
public class Acm619 {
	public static BigInteger i26 = new BigInteger("26");
	public static BigInteger[] lookup = 
	{
		BigInteger.ONE,
		new BigInteger("2"),
		new BigInteger("3"),
		new BigInteger("4"),
		new BigInteger("5"),
		new BigInteger("6"),
		new BigInteger("7"),
		new BigInteger("8"),
		new BigInteger("9"),
		new BigInteger("10"),
		new BigInteger("11"),
		new BigInteger("12"),
		new BigInteger("13"),
		new BigInteger("14"),
		new BigInteger("15"),
		new BigInteger("16"),
		new BigInteger("17"),
		new BigInteger("18"),
		new BigInteger("19"),
		new BigInteger("20"),
		new BigInteger("21"),
		new BigInteger("22"),
		new BigInteger("23"),
		new BigInteger("24"),
		new BigInteger("25"),
		i26
	};
 
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
 
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			if(line.equals("*") || line.equals(""))
				return;
			char chr = line.charAt(0);
			if(chr >= '0' && chr <= '9')
			{
				System.out.println(toLeng(numToString(new BigInteger(line)))+comma(line));
			}
			else
			{
				System.out.println(toLeng(line)+comma(strToNum(line).toString()));
			}
 
 
		}
 
		/*
		System.out.println(strToNum("ab"));
		System.out.println(numToString(new BigInteger("28")));
		System.out.println(numToString(new BigInteger("29697684282993")));
		System.out.println(strToNum("transcendental"));
		System.out.println(numToString(new BigInteger("28011622636823854456520")));
		System.out.println(strToNum("computationally"));
		System.out.println(strToNum("zzzzzzzzzzzzzzzzzzzz"));
		*/
	}
 
	private static String comma(String in)
	{
		if(in.length() <= 3)
			return in;
		return comma(in.substring(0,in.length()-3))+","+in.substring(in.length()-3);
	}
 
	private static String toLeng(String line) {
		for(int i = line.length(); i < 20; i++)
		{
			line+= " ";
		}
		return line+"  ";
	}
 
	public static BigInteger strToNum(String in)
	{
		if(in.length() == 1)
			return lookup(in.charAt(0));
		return lookup(in.charAt(in.length()-1)).add(strToNum(in.substring(0,in.length()-1)).multiply(i26));
	}
 
	public  static String numToString(BigInteger num)
	{
		BigInteger[] arr = num.divideAndRemainder(i26);
		if(arr[0].compareTo(BigInteger.ZERO) == 0)
			return ""+lookupchar(arr[1]);
		return numToString(arr[0])+lookupchar(arr[1]);
	}
 
	private static BigInteger lookup(char chr)
	{
		// TODO too many new big ints
		return lookup[chr-'a'];
	}
 
	private static char lookupchar(BigInteger num)
	{
		return (char)(num.intValue()+'a'-1);
	}
}