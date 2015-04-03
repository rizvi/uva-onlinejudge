/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Masudul Haque
 */
public class Acm401 {
    static final Map< Character, Character> reverse = new HashMap< Character, Character>();
    static final String NOT_PALINDROME = " -- is not a palindrome.";
    static final String REGULAR_PALINDROME = " -- is a regular palindrome.";
    static final String MIRRORED_STRING = " -- is a mirrored string.";
    static final String MIRRORED_PALINDROME = " -- is a mirrored palindrome.";
    static {
        reverse.put('A', 'A');
        reverse.put('E', '3');
        reverse.put('H', 'H');
        reverse.put('I', 'I');
        reverse.put('J', 'L');
        reverse.put('L', 'J');
        reverse.put('M', 'M');
        reverse.put('O', 'O');
        reverse.put('S', '2');
        reverse.put('T', 'T');
        reverse.put('U', 'U');
        reverse.put('V', 'V');
        reverse.put('W', 'W');
        reverse.put('X', 'X');
        reverse.put('Y', 'Y');
        reverse.put('Z', '5');
        reverse.put('1', '1');
        reverse.put('2', 'S');
        reverse.put('3', 'E');
        reverse.put('5', 'Z');
        reverse.put('8', '8');
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //final BufferedReader in = new BufferedReader(new FileReader("in.txt"));
        String line;
        while ((line = in.readLine()) != null && !line.equals("")) {
            System.out.println(solve(line.trim()));
            System.out.println();
        }
    }

    static String solve(String string) {
        if (isMirroredPalindrome(string)) {
            return string + MIRRORED_PALINDROME;
        }

        if (isPalindrome(string)) {
            return string + REGULAR_PALINDROME;
        }

        if (isMirroredString(string)) {
            return string + MIRRORED_STRING;
        }

        return string + NOT_PALINDROME;
    }

    static boolean isMirroredPalindrome(String string) {
        return isPalindrome(string) && isMirroredString(string);
    }

    static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        for (; left < right && string.charAt(left) == string.charAt(right); left++, right--);

        return left >= right;
    }

    static boolean isMirroredString(String string) {
        for (int i = string.length() - 1; i >= 0; i--) {
            if (!reverse.containsKey(string.charAt(i))
                    || reverse.get(string.charAt(i)) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}