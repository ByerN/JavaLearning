package org.byern.javalearning.lesson10.homework;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Person {
  public String firstName;
  public String lastName;
  public int age;

  @Override
  public String toString() {

    if (this.getFirstName() == null) {
      return "Person(lastName=" + this.getLastName() + ", age=" + this.getAge() + ")";
    } else return "Person(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ")";
  }
}


