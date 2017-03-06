package org.byern.javalearning.lesson6.lsystem.tree;

import org.byern.javalearning.lesson6.lsystem.core.constant.RuleConstants;
import org.byern.javalearning.lesson6.lsystem.core.dto.LSystemProperties;
import org.byern.javalearning.lesson6.lsystem.core.dto.Line;
import org.byern.javalearning.lesson6.lsystem.core.exception.RuleReadingException;
import org.byern.javalearning.lesson6.lsystem.core.io.RuleReader;
import org.byern.javalearning.lesson6.lsystem.core.service.LSystemProcessor;
import org.byern.javalearning.lesson6.lsystem.core.util.LineUtils;
import org.byern.javalearning.lesson6.lsystem.core.view.LinePrinter;
import org.byern.javalearning.lesson6.lsystem.tree.service.TreeGenerator;

import java.util.Scanner;

/**
 * Created by ByerN on 05.03.2017.
 */
public class TreeMain {
    public static final String RULE_FILE_PATH = "data/lesson6/";
    public static final String[] RULE_FILE_NAMES = {
            "PythagorasTreeRules",
            "Tree1Rules",
            "Tree2Rules",
            "HilbertCurveRules",
            "DragonCurveRules",
            "KochCurveRules",
            "KochSnowRules",
            "PentaDendriteCurveRules",
            "SierpinskiTriangleRules",
            "LeviDragonRules",
            "SpiralRules"
    };
    public static final int STARTING_ANGLE = -90;


    public static void main(String[] args) throws RuleReadingException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type width:");
        int width = scanner.nextInt();
        System.out.println("Type height:");
        int height = scanner.nextInt();

        boolean exit = false;
        while (!exit) {

            System.out.println("Select rule set:");
            for (int n = 0; n < RULE_FILE_NAMES.length; n++) {
                System.out.println(n + ":" + RULE_FILE_NAMES[n]);
            }
            System.out.println("Type 'q' to quit");

            String inputString = scanner.next();

            if (inputString.charAt(0) == 'q') {
                exit = true;
            } else {
                int ruleSetId;
                try {
                    ruleSetId = Integer.parseInt(inputString);
                    if (ruleSetId >= 0 && ruleSetId < RULE_FILE_NAMES.length) {
                        System.out.println("Type iteration number:");
                        int iteration = scanner.nextInt();
                        printLSystem(RULE_FILE_NAMES[ruleSetId], width, height, iteration);
                    } else {
                        System.out.println("Invalid!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid!");
                }

            }
        }
    }

    private static void printLSystem(String ruleFileName,
                                     int width,
                                     int height,
                                     int iteration) throws RuleReadingException {
        RuleReader ruleReader = new RuleReader();
        LinePrinter linePrinter = new LinePrinter();
        TreeGenerator generator = new TreeGenerator();
        LSystemProcessor lSystemProcessor = new LSystemProcessor();

        LSystemProperties lSystemProperties = ruleReader.readFromFile(
                RULE_FILE_PATH + ruleFileName
        );

        String startingWord = lSystemProperties.getProperties().getProperty(
                RuleConstants.STARTING_WORD_FIELD_NAME
        );
        String lSystemInput = lSystemProcessor.processLSystem(
                startingWord != null ? startingWord : "",
                lSystemProperties.getRules(),
                iteration
        );

        Line[] lines = generator.create(lSystemInput, STARTING_ANGLE, lSystemProperties.getProperties());

        LineUtils.scaleToSize(lines, width, height);

        linePrinter.printLines(lines, width, height);
    }


}
