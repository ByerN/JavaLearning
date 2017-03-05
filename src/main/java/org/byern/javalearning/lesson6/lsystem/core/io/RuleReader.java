package org.byern.javalearning.lesson6.lsystem.core.io;

import org.byern.javalearning.lesson6.lsystem.core.constant.RuleConstants;
import org.byern.javalearning.lesson6.lsystem.core.dto.LSystemProperties;
import org.byern.javalearning.lesson6.lsystem.core.exception.RuleReadingException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by ByerN on 05.03.2017.
 */
public class RuleReader {

    public static final String TEST_FILE_PATH = "data/lesson6/RuleFileTest";
    public static final String RULES_FIELD_NAME = "rules";
    public static final String PROPERTIES_FIELD_NAME = "properties";
    public static final String FIELD_DELIMITER = "=";
    public static final String RULES_DELIMITER = ",";
    public static final String RULE_NAME_TRANSFORM_DELIMITER = ":";

    public static void main(String[] args) throws RuleReadingException {
        RuleReader ruleReader = new RuleReader();
        String[][] rules = ruleReader.readFromFile(TEST_FILE_PATH).getRules();
        System.out.println(Arrays.deepToString(rules));
    }

    public LSystemProperties readFromFile(String filePath) throws RuleReadingException {
        String[][] rulesResult = new String[0][2];
        Properties properties = new Properties();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] fields = line.split(FIELD_DELIMITER);
                if (fields.length > 1) {
                    if (RULES_FIELD_NAME.equals(fields[0])) {
                        String[] ruleFields = fields[1].split(RULES_DELIMITER);
                        for (String ruleField : ruleFields) {
                            String[] rule = ruleField.split(RULE_NAME_TRANSFORM_DELIMITER);
                            validateRule(rule);
                            rulesResult = addRuleToArray(rulesResult, rule);
                        }
                    } else if (PROPERTIES_FIELD_NAME.equals(fields[0])) {
                        String[] propertiesFields = fields[1].split(RULES_DELIMITER);
                        for (String propertiesField : propertiesFields) {
                            String[] property = propertiesField.split(RULE_NAME_TRANSFORM_DELIMITER);
                            validateProperty(property);
                            properties.setProperty(property[0], property[1]);
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuleReadingException("File not found!", e);
        } catch (IOException e) {
            throw new RuleReadingException("Something bad happened!", e);
        }

        return new LSystemProperties(rulesResult, properties);
    }

    private String[][] addRuleToArray(String[][] result, String[] rule) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = rule;
        return result;
    }

    private void validateRule(String[] rule) throws RuleReadingException {
        if (rule.length != RuleConstants.RULE_ARRAY_LENGTH ||
                rule[RuleConstants.RULE_SYMBOL_INDEX].length() !=
                        RuleConstants.SYMBOL_LENGTH ||
                rule[RuleConstants.RULE_TRANSFORMATION_INDEX].length() <
                        RuleConstants.MIN_TRANSFORMATION_LENGTH) {
            throw new RuleReadingException("Invalid input: " + Arrays.deepToString(rule));
        }
    }

    private void validateProperty(String[] property) throws RuleReadingException {
        if (property.length != RuleConstants.RULE_ARRAY_LENGTH) {
            throw new RuleReadingException("Invalid input: " + Arrays.deepToString(property));
        }
    }
}
