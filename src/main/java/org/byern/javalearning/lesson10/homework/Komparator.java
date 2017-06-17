package org.byern.javalearning.lesson10.homework;

import java.util.Comparator;

/**
 * Created by wojteks on 18/05/2017.
 */
public class Komparator implements Comparator<Homework0> {


    private final int orderFlag;

    public Komparator(int orderFlag) {
        this.orderFlag = orderFlag;
    }

    @Override
    public int compare(Homework0 o1, Homework0 o2) {
        //orderFlag       1  Asceding;
        //               -1  Desceding

        if (o1 == o2) {
            return 0;
        }



        if ((o1.getFirstName() == o2.getFirstName())) {
            if ((o1.getLastName() == o2.getLastName())) {
                if ((o1.getAge() == o2.getAge())) {
                    return 0;
                } else if (o1.getAge() == null) {
                    return -1 * orderFlag;
                } else if (o2.getAge() == null) {
                    return 1 * orderFlag;
                } else return (o1.getAge().compareTo(o2.getAge()));
            } else if (o1.getLastName() == null) {
                return -1 * orderFlag;
            } else if (o2.getLastName() == null) {
                return 1 * orderFlag;
            } else return (o1.getLastName().compareTo(o2.getLastName()));

        } else if (o1.getFirstName() == null) {
            return -1 * orderFlag;
        } else if (o2.getFirstName() == null) {
            return 1 * orderFlag;

        }

        else return (o1.getFirstName().compareTo(o2.getFirstName()));
    }

}
/*


        if ((o1.getFirstName() == null) && (o2.getFirstName() == null)) {

            if ((o1.getLastName() == null) && (o2.getLastName() == null)) {
                if ((o1.getAge() == null) && (o2.getAge() == null)) {
                    return 0;
                } else if (o1.getAge() == null) {
                    return -1 * orderFlag;
                } else if (o2.getAge() == null) {
                    return 1 * orderFlag;
                } else return (o2.getAge().compareTo(o1.getAge()));

            } else if (o1.getLastName() == null) {
                return -1 * orderFlag;
            } else if (o2.getLastName() == null) {
                return 1 * orderFlag;
            } else return (o2.getLastName().compareTo(o1.getLastName()));

        } else if (o1.getFirstName() == null) {
            return -1 * orderFlag;
        } else if (o2.getFirstName() == null) {
            return 1 * orderFlag;

        } else return (o2.getFirstName().compareTo(o1.getFirstName()));
    }
*/


//            return 0;
/*
            if (o2.getFirstName() == null) return 1 * orderFlag;
            if (o2.getFirstName() == null) return 1 * orderFlag;
            if (o1.getLastName() == null) return -1 * orderFlag;
            if (o2.getLastName() == null) return 1 * orderFlag;
            if (o1.getAge() == null) return -1 * orderFlag;
            if (o2.getAge() == null) return 1 * orderFlag;


            if (o1.getFirstName().compareTo(o2.getFirstName()) < 0) return -1 * orderFlag;
            if (o1.getFirstName().compareTo(o2.getFirstName()) > 0) return 1 * orderFlag;
            if (o1.getFirstName().compareTo(o2.getFirstName()) == 0) return 0;
*/


