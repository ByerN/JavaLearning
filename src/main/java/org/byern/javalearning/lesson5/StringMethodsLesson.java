package org.byern.javalearning.lesson5;

/**
 * Created by ByerN on 01.03.2017.
 */
public class StringMethodsLesson {

    public static void main(String[] args) {
        /*
         * REMEMBER:
         * String is immutable.
         * https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html
         *
         * It means that it's state cannot be changed.
         * Invoking String methods are not changing this String but creating new one!
         */

        //https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
        System.out.println(String.format("%d      %d", 1, 2));

        //String from primitive and primitive from string:
        boolean booleanValue = Boolean.parseBoolean(String.valueOf(false));

        String example1 = "abcd";

        System.out.println(example1.equals("abcd"));// equals to other string -> false or true
        System.out.println(example1.charAt(0));// get character at index
        System.out.println(example1.compareTo("aaa"));// x==0 -> equal, x<0 -> lower, x>0 -> higher
        System.out.println(example1.compareToIgnoreCase("aaa"));//as above, ignoring case
        System.out.println(example1.contains("bc"));//true if contains provided string
        System.out.println(example1.endsWith("cd"));
        System.out.println(example1.startsWith("ab"));
        System.out.println(example1.isEmpty());
        System.out.println(example1.length());
        System.out.println(example1.endsWith("cd"));
        System.out.println(example1.matches(".*[c]a"));// true if matches regex
        //https://docs.oracle.com/javase/tutorial/essential/regex/

        System.out.println(example1.replaceAll("a", "b"));//replaces all "a" with "b" in this string
        System.out.println(example1.substring(0, 2));//divides string into substring (from-to)
        System.out.println(example1.toLowerCase());
        System.out.println(example1.toUpperCase());

        String simpleString= "a,c,a,s,f,g,h,j,k";
        String[] stringArray = simpleString.split(",");

        for (String item : stringArray){
            System.out.println(item);
        }

        System.out.println();

    }
}
