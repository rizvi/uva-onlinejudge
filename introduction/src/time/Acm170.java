/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm170 {

    static class Card {

        public int value;
        public String label;
        public Card next;
        public boolean faceup = false;

        public Card(String label) {
            this.label = label;
            char digit = label.charAt(0);
            switch (digit) {
                case 'A':
                    this.value = 1;
                    break;
                case 'T':
                    this.value = 10;
                    break;
                case 'J':
                    this.value = 11;
                    break;
                case 'Q':
                    this.value = 12;
                    break;
                case 'K':
                    this.value = 13;
                    break;
                default:
                    this.value = digit - '0';
            }
        }
    }

    public static String play(Card[] piles) {
        int nextpile;
        int exposed = 1;
        boolean win = false;
        Card visit;
        Card previous;

        // 取第一張牌
        Card current = piles[12];
        current.faceup = true;
        piles[12] = piles[12].next;

        do {
            // 選新卡片
            previous = current;
            previous.next = null;
            nextpile = current.value - 1;
            current = piles[nextpile];
            if (!current.faceup) {
                // 翻面
                current.faceup = true;
                exposed++;
                piles[nextpile] = piles[nextpile].next;

                // 把舊牌塞到最下面
                visit = piles[nextpile];
                if (visit != null) {
                    while (visit.next != null) {
                        visit = visit.next;
                    }
                    visit.next = previous;
                } else {
                    piles[nextpile] = previous;
                }
            } else {
                win = true;
            }
        } while (!win);

        return String.format("%02d,%s", exposed, previous.label);
    }

    public static void main(String args[]) throws IOException {
        int i, j;
        Card[] piles = new Card[13];
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("170.txt")));
        String line = null;
        while (!(line = buff.readLine()).equals("#")) {
            for (i = 3; i >= 0; i--) {
                StringTokenizer st = new StringTokenizer(line);
                for (j = 12; j >= 0; j--) {
                    Card card = new Card(st.nextToken());
                    if (piles[j] != null) {
              
                        Card visited = piles[j];
                        while (visited.next != null) {
                            visited = visited.next;
                        }
                        visited.next = card;
                    } else {
                        // 頂端牌
                        piles[j] = card;
                    }
                }
                if (i > 0) {
                    line = buff.readLine();
                }
            }
        }
        System.out.println(play(piles));
        for (i = 0; i < 13; i++) {
            piles[i] = null;
        }

    }
}
