package org.byern.javalearning.lesson6.homework;

/**
 * Created by wojteks on 14/03/2017.
 */
public class Homework_2 {

    public static void main(String[] args) {

        String word1 = "kajak";
        String word2 = "dom";
        String word3 = "kobyla ma maly bok";
        String word4 = "Kobyla ma maly bok";
        String[] table = {word1, word2, word3, word4};


        for (String word : table) {
            if (isPolindrome(word)) {
                System.out.println("Polindrome detected:" + word);
            }
        }
    }

    private static boolean isPolindrome(String word) {

        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }


    // psvm + TAB
    //shift + F6
}
