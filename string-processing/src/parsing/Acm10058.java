/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing;

/**
 *Summary

Match the statement against this grammar:
STATEMENT = ACTION | STATEMENT , ACTION
ACTION = ACTIVE_LIST VERB ACTIVE_LIST
ACTIVE_LIST = ACTOR | ACTIVE_LIST and ACTOR
ACTOR = NOUN | ARTICLE NOUN
ARTICLE = a | the
NOUN = tom | jerry | goofy | mickey | jimmy | dog | cat | mouse
VERB = hate | love | know | like | VERBs
[edit] Explanation

[edit] Gotchas

VERB can be post-fixed by any number of 's' characters.
Do not copy and paste the output statement. The ASCII code for the apostrophe is different.
[edit] Notes

There is exactly 1 space character (ASCII 32) between 2 words, and between a word and a comma.
 * @author Masudul Haque
 */
import java.io.*;

class Acm10058 { 

    private static final String VERB = "(hate|love|know|like)s*";
    private static final String NOUN = "(tom|jerry|goofy|mickey|jimmy|dog|cat|mouse)";
    private static final String ARTICLE = "(a|the)";
    private static final String ACTOR = "(" + NOUN + "|" + ARTICLE + " " + NOUN + ")";
    private static final String ACTIVE_LIST = "(" + ACTOR + " and )*" + ACTOR;
    private static final String ACTION = ACTIVE_LIST + " " + VERB + " " + ACTIVE_LIST;
    private static final String STATEMENT = ACTION + "( , " + ACTION + ")*";

    public static void main(String args[]) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String riddle;
        while ((riddle = sc.readLine()) != null) {
            // There is always space before and after a comma (,). Therefore, it is optional to clean up input with
            // replaceAll() and trim().
            System.out.println(riddle.replaceAll(" +", " ").trim().matches(STATEMENT) ? "YES I WILL" : "NO I WON'T");
        }
    }
}
