package org.byern.javalearning.lesson10.homework;


import java.util.Comparator;

public class ComparatorPerson implements Comparator<Person> {


  private boolean ascending = true;


  public ComparatorPerson(boolean ascending) {
    this.ascending = ascending;
  }



  @Override
  public int compare(Person person1, Person person2) {

    int result;

    if (person1.firstName == null && person2.firstName != null) {
      result = -1;
    } else if (person1.firstName != null && person2.firstName == null) {
      result = 1;
    } else if (person1.firstName == null && person2.firstName == null) {
      result = 0;
    } else {
      result = person1.firstName.compareTo(person2.firstName);
    }

    if (result == 0) {

      if (person1.lastName == null && person2.lastName != null) {
        result = -1;
      } else if (person1.lastName != null && person2.lastName == null) {
        result = 1;
      } else if (person1.lastName == null && person2.lastName == null) {
        result = 0;
      } else {
        result = person1.lastName.compareTo(person2.lastName);
      }

    }

    if (result == 0) {
      result = person1.age - person2.age;
    }

    return ascending ? result : result * -1;
  }
}
