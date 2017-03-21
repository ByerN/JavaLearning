package org.byern.javalearning.lesson7;

/**
 * Created by ByerN on 19.03.2017.
 */
public class ClassLesson {

    private int privateIntValueInitialized = 2;
    private int privateIntValueNotInitialized; // default someValue -> 0

    private String privateStringValueInitialized = "some string Instance";
    private String privateStringValueNotInitialized; // default someValue -> null

    private static String privateStaticValue = "some string Static";

    /*
     * Final values has to be initialized.
     */
    private final String privateFinalStaticValue = "";

    int someValue;

    /*
     * Constructor is invoked when "new" operator is used.
     * Constructor is used to construct the class instance.
     *
     * Constructor without any parameters is called non-argument constructor.
     * It's default when there is no more defined.
     *
     * It looks like this one:
     */
    public ClassLesson() {
        //do something when constructing the object
        //final properties can be initialized here as well
    }
/* multiple constructors with same signature cannot be declared
    public ClassLesson() { // error
    }
  */

    /*
     * Programmer can create constructor with any parameters.
     */
    public ClassLesson(int someValue) {
        someValue = someValue;//doesn't work
        this.someValue = someValue;//"this" is used to indicate that it is a property of this specific instance
    }

    /*
         * Static methods can be invoked from static context.
         * Non-static methods needs a instance to be invoked.
         *
         * Same with fields.
         */
    public static void main(String[] args) {
        printStaticHelloWorld();//works -> static
        ClassLesson.printStaticHelloWorld();//works -> static
        //printInstanceHelloWorld();//error -> non static
        //ClassLesson.printInstanceHelloWorld();//error -> non static
        ClassLesson.printStaticHelloWorldUsingField();
        /*
         * "new" operator is used to create a class instance.
         */
        ClassLesson classLesson = new ClassLesson();
        classLesson.printStaticHelloWorld();//works -> bad practice. It's shadowing the invocation context
        classLesson.printInstanceHelloWorld();//works -> instance
        classLesson.printInstanceHelloWorldUsingField();//works -> instance

        //non-argument constructor used
        ClassLesson classLesson1 = new ClassLesson();
        ClassLesson classLesson2 = new ClassLesson();
        ClassLesson classLesson3 = new ClassLesson();
        ClassLesson classLesson4 = new ClassLesson();

        classLesson1.someValue = 1;
        classLesson2.someValue = 2;
        classLesson3.someValue = 3;
        classLesson4.someValue = 4;

        System.out.println("Print instance values: ");
        System.out.println(classLesson1.someValue);
        System.out.println(classLesson2.someValue);
        System.out.println(classLesson3.someValue);
        System.out.println(classLesson4.someValue);


        ClassLesson[] classLessons = new ClassLesson[]{
                //one argument constructor used
                new ClassLesson(1),
                new ClassLesson(2),
                new ClassLesson(3),
                new ClassLesson(4),
        };
        for (ClassLesson item : classLessons) {
            System.out.println(item.someValue);
        }
    }

    public static void printStaticHelloWorld() {
        System.out.println("Print static hello world!");
    }

    public void printInstanceHelloWorld() {
        System.out.println("Print instance hello world!");
    }

    public static void printStaticHelloWorldUsingField() {
        System.out.println("Print instance hello world!" + privateStaticValue);
        //instance field cannot be used
    }

    public void printInstanceHelloWorldUsingField() {
        System.out.println("Print static hello world! Field: " + privateStringValueInitialized);
        //static field can be used too
    }
}
