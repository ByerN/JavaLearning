package org.byern.javalearning.lesson10.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ByerN on 11.04.2017.
 */
public class Homework1 {

    /*
     * Use class from Homework0 in this one.
     *
     * Create a program that sorts collection of this class instances (class created in Homework0)
     * in order provided in Homework0. It means that:
     *
     * first compare firstName
     * second compare lastName if firstNames are equal
     * compare age if equal firstNames and lastNames
     *
     * All of those are nullable.
     * Null is first in order.
     * It means that if
     * a1.firstName == "Joanna"
     * a2.firstName == null
     *
     * a2 is first and other fields are not compared.
     *
     * Implement it as separate comparator class (don't implement compareTo in this class).
     * Create a main method for testing with best example instances selected.
     *
     * Man should be able to select ascending or descending order. Could be provided as constructor argument
     * in comparator class.
     */

  public static void main(String[] args) {

    List<Person> personList = new ArrayList<>();
    personList.add(new Person("Thomas", "Moore", 42));
    personList.add(new Person("Thomas", "Kaminer", 30));
    personList.add(new Person(null, "Edgar", 58));
    personList.add(new Person("Julia", "Papineau", 66));
    personList.add(new Person("David", "Anderson", 87));
    personList.add(new Person("Robert", "Jeffrey", 14));
    personList.add(new Person("Mark", "Armstrong", 10));
    personList.add(new Person("Kelly", "Smith", 60));
    personList.add(new Person(null, "Smith", 63));
    personList.add(new Person("Kelly", "Smith", 22));
    personList.add(new Person("Martin", "Wagner", 35));


    //personsList.stream().sorted((p1, p2) -> p1.getFirstName().compareTo(p2.firstName)).collect(Collectors.toList());

//    personsList.sort((p1, p2) -> p1.getFirstName().compareTo(p2.firstName));

    Collections.sort(personList, new ComparatorPerson(true));
    System.out.println("\nPerson List is sorted ascending order");
    for(Person person : personList){
      System.out.println(person);
    }

    Collections.sort(personList, new ComparatorPerson(false));
    System.out.println("\nPerson List is sorted descending order");
    for(Person person : personList){
      System.out.println(person);
    }


    Collections.sort(personList, new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
      }

    });

    System.out.println("\nPerson List is sorted by age");
    for(Person person : personList){
      System.out.println(person);
    }
  }

}
