package org.byern.javalearning.lesson4;

/**
 * Created by ByerN on 25.02.2017.
 */
public class SwitchLesson {

    public static void main(String[] args){
        /*
         * Switch statement is another option of flow control.
         * It's often used to replace if-else construction.
         *
         * Construction:
         * switch(variable){
         *  case variableValue1: // executes if variable has value equal to variableValue1
         *      //code
         *      break; //breaks whole switch -> optional. If not provided, next case will be executed too.
         *  case variableValue2:
         *      //code
         *      break;
         *  case variableValueN:
         *      //code
         *      break;
         *  default: // executed if none of previous blocks where executed. Optional.
         *      //default operation
         *      break;
         * }
         *
         * -variable can be char, String, enum, byte, short, int
         *
         * long var = 1L;
         * switch(var){ // won't compile
         *  case 1:
         *      break;
         *
         * }
         */


        String animal = "Cat";

        System.out.println("Switch example 1:");
        switch(animal){
            case "Cat":
                System.out.println("Meow!");
                break;
            case "Snake":
                System.out.println("Sssss!");
                break;
            default:
                System.out.println("I don't know this one :(");
                break;
        }

        /*
         * Same thing can be achieved with if like construction:
         */
        System.out.println("If-else equivalent:");
        if("Cat".equals(animal)){
            System.out.println("Meow!");
        } else if ("Snake".equals(animal)){
            System.out.println("Sssss!");
        } else {
            System.out.println("I don't know this one :(");
        }

        /*
         * Switch statement provides more clear solution for one value dependant code executing.
         *
         * Important thing is that how "break" works in this case.
         */

        System.out.println("Switch example 2 (without break):");
        switch(animal){
            case "Cat"://matched
                System.out.println("Meow!");//executed
            case "Snake"://not matched but executed jus like everything after it
                System.out.println("Sssss!");
            default:
                System.out.println("I don't know this one :(");
        }

        /*
         * If break will be omitted, everything after first match will be executed (up to next break).
         */

        System.out.println("Switch example 3 (without break- sensible usage 1):");
        switch(animal){
            case "Tiger":
            case "Cat":
                System.out.println("Meow!");
                break;
            case "Snake":
                System.out.println("Sssss!");
                break;
            default:
                System.out.println("I don't know this one :(");
                break;//this one looks useless but it makes code more clear
        }

        System.out.println("Switch example 4 (without break- sensible usage 2):");
        System.out.print("Hello ");
        animal = "Tiger";
        switch(animal){
            case "Tiger":
                System.out.print("big ");
            case "Cat":
                System.out.println("kitty!");
                break;
            case "Snake":
                System.out.println("snake!");
                break;
            default:
                System.out.println("unknown animal!");
                break;//this one looks useless but it makes code more clear
        }
        /*
         * We don't use code blocks for "case"
         *
         * It means that "case value:" and "break" should be an indicator of code block.
         *
         *
         This one works too, but it's not a good practice:
        switch(animal){
            case "Tiger":
            case "Cat": {
                System.out.println("Meow!");
                break;
            }
            case "Snake": {
                System.out.println("Sssss!");
                break;
            }
            default: {
                System.out.println("I don't know this one :(");
                break;
            }
        }

        * That's why last "break" makes construction clearer.
        *
        * Some important things:
        * -Code lines after case cannot be too long because it will be not readable.
        *   5-6 lines looks like sensible limit. More should be wrapped with method.
        * -Good practice is to always put "default" and do something with case that we didn't
        *   resolve.
        *
        */
    }
}
