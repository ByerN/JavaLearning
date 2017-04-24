package org.byern.javalearning.lesson10.homework;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ByerN on 11.04.2017.
 */
public class Homework2 {

    /*
     * Same as Homework1
     *
     * but user should be able to change the comparision order.
     * It means that programmer should be able to say that only
     * lastName and age are compared.
     *
     * *It can be achieved by adding list with field names (String or better enum) and
     *  implementing comparision by looping through this array.
     *  w konstruktorze lista pól, które mają być sortowane
     * sortowanie zależne od kolejności na liście
     */

  public static void main(String[] args) {

    List<Person> personList = new ArrayList<>();
    personList.add(new Person("Thomas", "Moore", 30));
    personList.add(new Person("Anna", "Kaminer", 30));
    personList.add(new Person(null, "Edgar", 58));
    personList.add(new Person("Julia", "Papineau", 66));
    personList.add(new Person("David", "Anderson", 87));
    personList.add(new Person("Robert", "Jeffrey", 14));
    personList.add(new Person("Mark", "Armstrong", 10));
    personList.add(new Person("Kelly", "Smith", 60));
    personList.add(new Person(null, "Smith", 63));
    personList.add(new Person("Kelly", "Smith", 22));
    personList.add(new Person("Martin", "Wagner", 35));


    Collections.sort(personList, new ComparatorPerson_2(true,
            Arrays.asList(
                ComparatorPerson_2.Field.AGE,
                ComparatorPerson_2.Field.FIRST_NAME
            )
        )
    );
    System.out.println("\nPerson List is sorted ascending order");
    for (Person person : personList) {
      System.out.println(person);
    }
  }

}
