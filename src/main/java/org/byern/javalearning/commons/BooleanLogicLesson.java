package org.byern.javalearning.commons;

/**
 * Created by ByerN on 18.02.2017.
 */
public class BooleanLogicLesson {

    /*------------------------
     *  NOT
     *  ----------------------
     *  a               !a
     *  false           true
     *  true            false
     *------------------------
     *  AND
     *  a       b       a&&b
     *  ----------------------
     *  false   false   false
     *  false   true    false
     *  true    false   false
     *  true    true    true
     *------------------------
     *  OR
     *  a       b       a||b
     *  ----------------------
     *  false   false   false
     *  false   true    true
     *  true    false   true
     *  true    true    true
     *------------------------
     *  EX-OR
     *  a       b       a^b -> (a&&!b)||(!a&&b) -> a != b
     *  ----------------------
     *  false   false   false
     *  false   true    true
     *  true    false   true
     *  true    true    false
     *------------------------
     *  EX-NOR
     *  a       b       (!a&&!b)||(a&&b) -> a == b
     *  ----------------------
     *  false   false   true
     *  false   true    false
     *  true    false   false
     *  true    true    true
     *------------------------
     */
}
