package org.byern.javalearning.lesson10;

import java.util.*;

/**
 * Created by ByerN on 10.04.2017.
 */
public class CollectionsLesson {

    /*
     * https://docs.oracle.com/javase/tutorial/collections/
     *
     * Collections is a common name of Java support for data structures.
     *
     * People often recognizes collections as interfaces from java collection api
     * and it's implementations. Let's define the class hierarchy:
     *
     * Interfaces:
     *  Collection
     *      Set
     *          SortedSet
     *      List
     *      Queue
     *      Deque
     *  Map
     *      SortedMap
     *
     *
     * Collections are used as containers in replacement of arrays.
     * "Collection" is an base interface for all other data structures (excluding Map)
     * "Map" is not a true collection but it's provided in Java collection api.
     *
     * Those data structures have specific implementation. Selection of the implementation
     * should be a mindful decision predicted by the usage.
     *
     * For example:
     * Most common implementation of List interface is ArrayList. But there is also for example a LinkedList.
     * Which one to use?
     * Let's take a look at stackoverflow answer:
     * http://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist
     *
     * The complexity of operations are the most important thing when selecting an implementation.
     * Other factors are for example concurrency support (about this one later).
     *
     * Let's check the most commonly used implementations:
     * https://docs.oracle.com/javase/tutorial/collections/implementations/index.html
     *
     * And now the simplification:
     * Set- container that allows only distinct values
     * List- container that allows all values (usually replacement for array)
     * Queue- container usually used as FiFo (First in- First out)
     * Deque- double ended queue
     * Map- special type of container which binds a value to the key
     *
     * What to use?
     * Most commonly used is List with implementation ArrayList.
     * If you want to have only distinct values, use Set with implementation HashSet (fastest but not-sortable)
     * If you want to bind key to value, use Map with implementation HashMap
     * If you want to have the most important thing to be fast to get, use queue (PriorityQueue if you want to specify priority)
     * If you want double ended queue use deque
     *
     *
     *
     *
     *
     */


    static class A implements Comparable<A> {
        private String name;

        public A(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            return name != null ? name.equals(a.name) : a.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public int compareTo(A o) {
            return this.getName().compareTo(o.getName());
        }
    }

    public static void main(String[] args) {
        List<A> arrayListA = new ArrayList<>();
        arrayListA.add(new A("A"));
        arrayListA.add(new A("B"));
        arrayListA.add(new A("C"));

        System.out.println(arrayListA.size()); // 3
        System.out.println(arrayListA.get(0).getName());//A
        System.out.println(arrayListA.get(1).getName());//B
        System.out.println(arrayListA.get(2).getName());//C
        //System.out.println(arrayListA.get(3).getName());//java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
        System.out.println(arrayListA.contains(new A("A")));//true
        System.out.println(arrayListA.indexOf(new A("B")));//1
        System.out.println(arrayListA.isEmpty());//false
        System.out.println(arrayListA.remove(new A("C")));//true (can be removed with index too)
        System.out.println(arrayListA.size()); // 2
        arrayListA.add(new A("C"));

        //Looping through collection:
        for (int n = 0; n < arrayListA.size(); n++) {
            System.out.println(arrayListA.get(n).getName());
        }

        for (A item : arrayListA) {
            System.out.println(item.getName());
        }

        Iterator<A> iterator = arrayListA.iterator();
        while (iterator.hasNext()) {
            A a = iterator.next();
            System.out.println(a.getName());
        }

        //cannot remove when iterating
        for (A item : arrayListA) {
            System.out.println(item.getName());
            //arrayListA.remove(item); //java.util.ConcurrentModificationException
        }

        System.out.println(arrayListA.size());//3
        //Do it using an iterator (for version- less readable)
        for (Iterator<A> iterator2 = arrayListA.iterator(); iterator2.hasNext(); iterator2 = arrayListA.iterator()) {
            A a = iterator2.next();
            System.out.println(a.getName());
            iterator2.remove();
        }
        System.out.println(arrayListA.size());//0


        arrayListA.add(new A("A"));
        arrayListA.add(new A("B"));
        arrayListA.add(new A("C"));
        //While loop works better for this case
        iterator = arrayListA.iterator();
        System.out.println(arrayListA.size());//3
        while (iterator.hasNext()) {
            A a = iterator.next();
            System.out.println(a.getName());
            iterator.remove();
        }
        System.out.println(arrayListA.size());//0


        //Create list from array
        List<A> list2 = new ArrayList<>(
                Arrays.asList(
                        new A[]{
                                new A("A"),
                                new A("B"),
                                new A("C"),
                                new A("A"),
                        }
                )
        );

        //Create set from List
        Set<A> set1 = new HashSet<>(list2);
        System.out.println(list2.size());//4
        System.out.println(set1.size());//3 -> duplicated new A("A") removed

        Collections.shuffle(list2);
        for (A item : list2) {
            System.out.println(item.getName());
        }//Random order

        Collections.sort(list2);
        for (A item : list2) {
            System.out.println(item.getName());
        }//AABC

        Map<String, A> map = new HashMap<>();
        map.put("A1", new A("A"));
        map.put("A2", new A("B"));
        map.put("A3", new A("C"));
        map.put("A4", new A("D"));

        System.out.println(map.get("A1").getName());//A
        System.out.println(map.get("A4").getName());//D

        //loop through values
        for (A a : map.values()){
            System.out.println(a.getName());
        }

        //loop through keys
        for (String key : map.keySet()){
            System.out.println(key);
        }

        //loop through key-value pairs
        for (Map.Entry<String, A> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue().getName());
        }

        System.out.println(map.containsKey("A1")); //true
        System.out.println(map.get("A1").getName()); //A -> hashcode method used. If duplicated hash -> equals used
    }
}
