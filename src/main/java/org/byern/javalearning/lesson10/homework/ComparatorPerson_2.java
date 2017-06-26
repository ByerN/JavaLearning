package org.byern.javalearning.lesson10.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// http://stackoverflow.com/questions/1946668/sorting-using-comparator-descending-order-user-defined-classes
// http://stackoverflow.com/questions/1206073/sorting-a-collection-of-objects
//http://stackoverflow.com/questions/1206073/sorting-a-collection-of-objects

public class ComparatorPerson_2 implements Comparator<Person> {

  public enum Field {
    FIRST_NAME,
    LAST_NAME,
    AGE
  }

  private boolean ascending = true;
  private List<Field> fieldOrder = new ArrayList<>();

  public ComparatorPerson_2(boolean ascending, List<Field> fieldOrder) {
    this.fieldOrder = new ArrayList<>(fieldOrder);
    this.ascending = ascending;
  }


  @Override
  public int compare(Person person1, Person person2) {
    int result = 0;
    for (int n = 0; n < fieldOrder.size() && result == 0; n++) {
      switch (fieldOrder.get(n)) {
        case AGE:
          result = compareAge(person1, person2);
          break;
        case FIRST_NAME:
          result = compareFirstName(person1, person2);
          break;
        case LAST_NAME:
          result = compareLastName(person1, person2);
          break;
        default:
          break;
      }
    }
    return ascending ? result : result * -1;
  }

  private int compareLastName(Person person1, Person person2) {
    int result;
    if (person1.lastName == null && person2.lastName != null) {
      result = -1;
    } else if (person1.lastName != null && person2.lastName == null) {
      result = 1;
    } else if (person1.lastName == null && person2.lastName == null) {
      result = 0;
    } else {
      result = person1.lastName.compareTo(person2.lastName);
    }
    return result;
  }

  private int compareFirstName(Person person1, Person person2) {
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
    return result;
  }

  private int compareAge(Person person1, Person person2) {
    int result;
    result = person1.age - person2.age;
    return result;
  }


}
