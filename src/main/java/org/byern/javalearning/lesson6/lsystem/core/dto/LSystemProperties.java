package org.byern.javalearning.lesson6.lsystem.core.dto;

import java.util.Properties;

/**
 * Created by ByerN on 05.03.2017.
 */
public class LSystemProperties {
    private String[][] rules;
    private Properties properties;

    public LSystemProperties(String[][] rules, Properties properties) {
        this.rules = rules;
        this.properties = properties;
    }

    public String[][] getRules() {
        return rules;
    }

    public Properties getProperties() {
        return properties;
    }
}
