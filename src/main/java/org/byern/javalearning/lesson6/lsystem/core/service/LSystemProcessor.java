package org.byern.javalearning.lesson6.lsystem.core.service;

import org.byern.javalearning.lesson6.lsystem.core.constant.RuleConstants;

/**
 * Created by ByerN on 05.03.2017.
 */
public class LSystemProcessor {

    public static void main(String[] args) {
        LSystemProcessor processor = new LSystemProcessor();
        System.out.println(
                processor.processLSystem("abcde",
                        new String[][]{
                                {"a", "a"},
                                {"b", "b"},
                                {"c", "c"},
                                {"d", "d"}
                        }, 1)
        );
    }

    public String processLSystem(String word, String[][] rules, int iteration) {
        String result = word;
        String startingWord = word;

        for (int n = 0; n < iteration; n++) {
            result = "";
            for (char symbol : startingWord.toCharArray()) {
                String transformation = getTransformationBySymbol(rules, symbol);
                result += transformation != null ? transformation : symbol;
            }
            startingWord = result;
        }

        return result;
    }

    private String getTransformationBySymbol(String[][] rules, char symbol) {
        for (String[] rule : rules) {
            if (symbol == rule[RuleConstants.KEY_INDEX].charAt(0)) {
                return rule[RuleConstants.VALUE_INDEX];
            }
        }
        return null;
    }
}
