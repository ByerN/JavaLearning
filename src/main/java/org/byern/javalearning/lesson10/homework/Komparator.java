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
        //orderFlag 1- Asceding; -1 - desceding

        if (o1==o2) {return 0;}
        else
        {
            if (o1.firstName==null) return -1*orderFlag;
            if (o2.firstName==null) return 1*orderFlag;
            if (o1.lastName==null) return -1*orderFlag;
            if (o2.lastName==null) return 1*orderFlag;
            if (o1.age==null) return -1*orderFlag;
            if (o2.age==null) return 1*orderFlag;


        if (o1.firstName.compareTo(o2.firstName)<0) return -1*orderFlag;
        if (o1.firstName.compareTo(o2.firstName)>0) return 1*orderFlag;
        if (o1.firstName.compareTo(o2.firstName)==0) return 0;

        }

        return 0;
    }
}
