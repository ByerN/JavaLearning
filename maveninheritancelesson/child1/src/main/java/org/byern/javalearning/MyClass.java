package org.byern.javalearning;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by ByerN on 04.06.2017.
 */
@Getter
public class MyClass {

    public static void main(String[] args) {
        System.out.println(StringUtils.isBlank(""));
    }
}
