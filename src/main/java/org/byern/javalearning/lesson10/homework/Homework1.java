package org.byern.javalearning.lesson10.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ByerN on 11.04.2017.
 */
public class Homework1 {


    public static void main(String[] args) {
        Homework0 hm = new Homework0("Jan","Pan",13);
        Homework0 hm1 = new Homework0("Jam","Pan",13);
        Homework0 hm2 = new Homework0("Jan","Par",13);
        Homework0 hm3 = new Homework0("Jan","Pan",1);
        Homework0 hm4 = new Homework0("Jan","Pan",133);
        Homework0 hm5 = new Homework0("Jan",null,13);
        Homework0 hm6 = new Homework0(null,"Pan",13);
        Homework0 hm7 = new Homework0("Jan","Pan",null);
        Homework0 hm8 = new Homework0(null,"Par",13);


        List<Homework0> nieposortowanaLista = new ArrayList<Homework0>();
        nieposortowanaLista.add(hm);
        nieposortowanaLista.add(hm1);
       nieposortowanaLista.add(hm2);
        nieposortowanaLista.add(hm3);
        nieposortowanaLista.add(hm4);
        nieposortowanaLista.add(hm5);
        nieposortowanaLista.add(hm6);
        nieposortowanaLista.add(hm7);
        nieposortowanaLista.add(hm8);


        for (Homework0 tmp : nieposortowanaLista){
            System.out.println(tmp.toString());

        }

        System.out.println("");
        System.out.println("po sortowaniu");
        System.out.println("");
int orderFlag=1;

        Collections.sort(nieposortowanaLista, new Komparator(orderFlag));
        for (Homework0 tmp : nieposortowanaLista){
            System.out.println(tmp.toString());

        }
        //nieposortowanaLista.sort(Komparator<Homework0>);




    }


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

}
