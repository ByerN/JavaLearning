package org.byern.javalearning.lesson4;

/**
 * Created by ByerN on 26.02.2017.
 */
public class EnumLesson {

    /*
     * Enums are usually declared in separated files with same filename as enum name.
     * For easier example, I will declare it as inner enums.
     *
     * More about inner enums/classes at OOP lessons.
     *
     * -enums can be compared with '==' operator and it's a recommended way.
     */
    enum Day { //enum name
        MONDAY, //enum values
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    enum DayComplex {
        MONDAY(1, WorkDayType.WORK),//CONST_NAME(dayNumberValue, dayTypeValue),
        TUESDAY(2, WorkDayType.WORK),
        WEDNESDAY(3, WorkDayType.WORK),
        THURSDAY(4, WorkDayType.WORK),
        FRIDAY(5, WorkDayType.WORK),
        SATURDAY(6, WorkDayType.HOME),
        SUNDAY(7, WorkDayType.HOME);

        public int dayNumber;
        public WorkDayType dayType;

        /*
         * Constructor is used when enum constant is initialized.
         */
        DayComplex(int dayNumber, WorkDayType dayType) { //constructor for enum
            this.dayNumber = dayNumber;
            this.dayType = dayType;
        }
    }

    enum WorkDayType {
        WORK,
        HOME
    }

    public static void main(String[] args) {
        /*
         * "enum" is a special data type that represents a fixed set of constant.
         *
         * Simple construction:
         *
         * enum EnumName{
         *  ENUM_VALUE_1,
         *  ENUM_VALUE_2,
         *  ENUM_VALUE_3;
         * }
         *
         * example:
         *
         * enum Day{
         *        MONDAY,
         *        TUESDAY,
         *        WEDNESDAY,
         *        THURSDAY,
         *        FRIDAY,
         *        SATURDAY,
         *        SUNDAY;
         * }
         *
         * Enum values should be named according to JAVA_CONSTANTS_NAMING_CONVENTION.
         *
         * Enum can be more complex -> example: DayComplex
         *
         * Usage of enum constant:
         * EnumName.ENUM_CONSTANT
         * EnumName.ENUM_CONSTANT.enumConstantProperty //getter should be used instead of public access
         * //more about access modifiers at OOP lessons
         *
         */
        System.out.println("Enum example 1:");
        System.out.println("DayComplex.FRIDAY= " + DayComplex.FRIDAY);//FRIDAY
        System.out.println("DayComplex.FRIDAY.dayNumber= " + DayComplex.FRIDAY.dayNumber);//1
        System.out.println("DayComplex.FRIDAY.FRIDAY.dayType= " + DayComplex.FRIDAY.dayType);//WORK

        /*
         * There are some methods that can be invoked from enum type:
         * ENUM_CONSTANT.name() -> returns enum constant's name as String
         * EnumType.valueOf(String) -> returns enum constant by name. Can cause exception
         * EnumType.values() -> returns an array with all enum values
         */

        String fridayName = DayComplex.FRIDAY.name();
        DayComplex fridayEnum = DayComplex.valueOf("FRIDAY");
        DayComplex[] allDays = DayComplex.values();

        System.out.println("Enum example 2:");
        System.out.println("DayComplex.FRIDAY.name()= " + fridayName);//FRIDAY
        System.out.println("DayComplex.valueOf(\"FRIDAY\")= " + fridayEnum);//FRIDAY
        System.out.println("DayComplex.values()= " + allDays);//[Lorg.byern.javalearning.lesson4.EnumLesson$DayComplex;@2cc7d960
        System.out.println("DayComplex.values()[0]= " + allDays[0]);//MONDAY

        /*
         * Iterate through enum constant:
         */
        System.out.println("Enum example 3 (iteration):");
        for (DayComplex day : DayComplex.values()) {
            System.out.println(day.dayNumber + ". " + day + " " + day.dayType);
        }

        /*
        for (int n = 0; n < DayComplex.values().length; n++) {
            DayComplex day = DayComplex.values()[n];
            System.out.println(day.dayNumber + ". " +
                    day + " " + day.dayType);
        }
        */

        /*
         * Enums are suitable for switch statement:
         */

        System.out.println("Enum example 4 (switch):");
        for (DayComplex day : DayComplex.values()) {
            System.out.println(day.dayNumber + ". " + day + " " + day.dayType);
            switch (day) {
                case MONDAY:
                    System.out.println("Eh... Not again");
                    break;
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                    System.out.println("Waiting for friday!");
                    break;
                case FRIDAY:
                    System.out.println("Yeah!");
                    break;
                case SATURDAY:
                case SUNDAY:
                default:
                    System.out.println("Fun!");
                    break;
            }
        }
    }
}
