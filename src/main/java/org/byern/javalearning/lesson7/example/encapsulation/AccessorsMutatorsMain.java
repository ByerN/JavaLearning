package org.byern.javalearning.lesson7.example.encapsulation;

/**
 * Created by ByerN on 26.03.2017.
 */
public class AccessorsMutatorsMain {

    private int a;
    private int b;
    private String someA;
    private String someB;
    private boolean aBoolean;
    private boolean bBoolean;

    //check how it's getter looks like.
    private boolean isBoolean;


    //Methods produced with: alt+insert -> Getter and Setter -> select all -> enter
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getSomeA() {
        return someA;
    }

    public void setSomeA(String someA) {
        this.someA = someA;
    }

    public String getSomeB() {
        return someB;
    }

    public void setSomeB(String someB) {
        this.someB = someB;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public boolean isbBoolean() {
        return bBoolean;
    }

    public void setbBoolean(boolean bBoolean) {
        this.bBoolean = bBoolean;
    }

    public boolean isBoolean() {
        return isBoolean;
    }

    public void setBoolean(boolean aBoolean) {
        isBoolean = aBoolean;
    }
}
