package org.byern.javalearning.lesson10;

/**
 * Created by krzyspo on 10/04/2017.
 */
public class EqualsHashCodeLesson {

    /*
     * Equals and hashcode are methods of Object class.
     * It can be override in subclasses which is often practice in order
     * to add control of object comparing process.
     *
     * Let's take a look at documentation from Object class:
     */

    //Equals method documentation:
    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     *     {@code x}, {@code x.equals(x)} should return
     *     {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     *     {@code x} and {@code y}, {@code x.equals(y)}
     *     should return {@code true} if and only if
     *     {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     *     {@code x}, {@code y}, and {@code z}, if
     *     {@code x.equals(y)} returns {@code true} and
     *     {@code y.equals(z)} returns {@code true}, then
     *     {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     *     {@code x} and {@code y}, multiple invocations of
     *     {@code x.equals(y)} consistently return {@code true}
     *     or consistently return {@code false}, provided no
     *     information used in {@code equals} comparisons on the
     *     objects is modified.
     * <li>For any non-null reference value {@code x},
     *     {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param   obj   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     * @see     #hashCode()
     * @see     java.util.HashMap
     *
     * public boolean equals(Object obj)
     */

    //Hash code method documentation:
    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     *     an execution of a Java application, the {@code hashCode} method
     *     must consistently return the same integer, provided no information
     *     used in {@code equals} comparisons on the object is modified.
     *     This integer need not remain consistent from one execution of an
     *     application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     *     method, then calling the {@code hashCode} method on each of
     *     the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     *     according to the {@link java.lang.Object#equals(java.lang.Object)}
     *     method, then calling the {@code hashCode} method on each of the
     *     two objects must produce distinct integer results.  However, the
     *     programmer should be aware that producing distinct integer results
     *     for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return  a hash code value for this object.
     * @see     java.lang.Object#equals(java.lang.Object)
     * @see     java.lang.System#identityHashCode
     *
     *     public native int hashCode();
     */

    /*
     * Both of them says about some kind of contract between equals and hashcode.
     * General rule is to always override hashcode when overriding equals and vice-versa.
     * It's the only way to prevent unpredictable bugs when using other APIs for example collections.
     */

    /*
     * Below the result of ALT+INSERT -> generate equals() and hashCode()
     *
     * Keep in mind that that it's without refactor (if are without blocks).
     * It can be refactored.
     */
    public static class A {
        int a;
        int b;
        String c;

        public A(int a, int b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;

            A a1 = (A) o;

            if (a != a1.a) return false;
            if (b != a1.b) return false;
            return c != null ? c.equals(a1.c) : a1.c == null;
            //if all of A class properties are equal each other,it's true.
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;//31 as prime number
            result = 31 * result + (c != null ? c.hashCode() : 0);
            return result;//results in integer number hashing all properties
        }
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.equals(obj2));//false
        System.out.println(obj1.hashCode() == obj2.hashCode());//false

        A a1 = new A(1, 2, "A");
        A a2 = new A(1, 2, "A");

        System.out.println(a1.equals(a2));//true
        System.out.println(a1.hashCode() == a2.hashCode());//true

        System.out.println(new A(1, 2, "A").equals(new A(1, 2, null)));//false
        System.out.println(new A(1, 2, "A").hashCode() == new A(1, 2, null).hashCode());//false


        System.out.println(new A(1, 2, "A").equals(new A(1, 3, "A")));//false
        System.out.println(new A(1, 2, "A").hashCode() == new A(1, 3, "A").hashCode());//false
    }


}
