package org.byern.javalearning.lesson3.homework;

/**
 * Created by wojteks on 11/03/2017.
 */
public class Frame_for_maps implements java.io.Serializable {
    boolean doorOpen;
    boolean keyCollected ;
    int[][][] maps;
    int level;
    int nextX;
    int nextY;
    boolean moved;


    public Frame_for_maps(boolean doorOpen, boolean keyCollected, int[][][] maps, int level, int nextX, int nextY, boolean moved){
    this.doorOpen=doorOpen;
    this.keyCollected=keyCollected;
    this.maps=maps;
    this.level=level;
    this.nextX = nextX;
    this.nextY = nextY;
    this.moved = moved;
}
}