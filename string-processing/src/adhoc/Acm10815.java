/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.*;
import java.util.*;

/**
 * Andys First Dictionary
 * UVA problem 10815
 */
public class Acm10815 {
    /**
     * Splits a string into a list of words.
     * A word is a continuous sequence of letters.
     * @param s the string to split.
     * @return words
     */
    private static List<String> parse(final String s) {
        List<String> ret = new LinkedList<String>();

        int i = 0;
        while(i < s.length()) {
            int j = i;

            while(j < s.length() && Character.isLetter(s.charAt(j)))
                ++j;

            if(i != j)
                ret.add(s.substring(i,j));

            i = j+1;
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        Tree t=new Tree();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        while(s != null){
            List<String> words = parse(s);
            for(String word: words)
                t.add(word.toLowerCase());

            s = in.readLine();
        }

        t.print();
    }
}
    /**
     * Tree with print function
     */
   class Tree {

        private Node root;

        /**
         * Add string.
         * @param s string to add
         */
        public void add(String s) {
            Node n = new Node();
            n.cont = s;

            if(root == null)
                root = n;
            else
                recAdd(root,n);
        }

        /**
         * Add a node recursively.
         * @param current the current node
         * @param n the new node
         */
        private void recAdd(Node current, Node n) {
            if(n.cont.compareTo(current.cont) < 0) {
                if(current.left == null)
                    current.left = n;
                else
                    recAdd(current.left,n);
            }

            else if(n.cont.compareTo(current.cont) > 0) {
                if(current.right == null)
                    current.right = n;
                else
                    recAdd(current.right,n);
            }
        }

        /**
         * Prints the tree to standard output.
         */
        public  void print() {
            if(root != null)
                recPrint(root);
        }

        /**
         * Prints the tree recursively to standard output.
         * @param n
         */
        private void recPrint(Node n) {
            if(n.left != null)
                recPrint(n.left);
            
            System.out.println(n.cont);
            
            if(n.right != null)
                recPrint(n.right);
        }

        /**
         * Node
         */
        private class Node{
            String cont;
            Node left,right;
        }
    }