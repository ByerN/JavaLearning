package org.byern.javalearning.lesson11;

/**
 * Created by ByerN on 24.04.2017.
 */
public class NestedClassLesson {

    /*
     * Static nested class
     */
    static class StaticNestedClass {
        private int staticNestedClassVariable = 2;
    }

    /*
     * Nested class (inner class)
     * Inner class has access to it's enclosing class members (even private)
     */
    class NestedClass {
        private int innerClassVariable = 2;

        private void nestedClassMethod(){
            classVariable += 2;
        }
    }

    private int classVariable = 1;

    public void enclosingClassMethod(){
        classVariable += 2;
        NestedClass nestedClassObject = new NestedClass();
        nestedClassObject.innerClassVariable += 2;

    }

    public static void main(String[] args) {
        NestedClassLesson.StaticNestedClass staticNestedClassObject = new NestedClassLesson.StaticNestedClass();
        staticNestedClassObject.staticNestedClassVariable += 2;

        /*
         * This one below doesn't work because main is static context and NestedClass is not
         */
        //NestedClassLesson.NestedClass nestedClassObject = new NestedClassLesson.NestedClass();

        NestedClassLesson nestedClassLesson = new NestedClassLesson();
        NestedClassLesson.NestedClass nestedClass = nestedClassLesson.new NestedClass();
    }
}
