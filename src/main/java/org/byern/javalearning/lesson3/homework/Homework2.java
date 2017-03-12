package org.byern.javalearning.lesson3.homework;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework2{//} implements java.io.Serializable{

    public static void main(String[] args) {
        /*
         * Simple text game example:
         *
         * wsad to move;
         *
         * 0 - floor -> You can walk on floor
         * 1 - wall -> Cannot pass here
         * 2 - player start point
         * 3 - key -> Collected key! (after key collect, it should be treated like floor)
         * 4 - door -> if key collected -> Opened. You won!; else -> Locked
         * 5 - trap -> you die
         *
         * Homework:
         * -Add 2 more levels.
         */
        Scanner scanner = new Scanner(System.in);
        //Game level:

        int[][][] maps = {{
                {0, 1, 4, 1},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {3, 0, 2, 5},
        },
        {
                {0, 1, 4, 1},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {3, 0, 2, 5},
        },
                {
                {0, 1, 4, 1},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {3, 0, 2, 5},
        }};

        int[][] map;


        //Search and set player starting point
        int playerX = 0;
        int playerY = 0;

        boolean keyCollected = false;
        boolean doorOpen = false;
        boolean moved = false;

        int level =0;


        if(new File("maps.txt").exists()){
            Frame_for_maps frame = load();
            keyCollected = frame.keyCollected;
            doorOpen = frame.doorOpen;
            maps = frame.maps;
            level = frame.level;
            playerX = frame.nextX;
            playerY = frame.nextY;
            moved = frame.moved;
        }


        for (int level_i = level ; level_i<3; level_i++){
            map = maps[level];


        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 2) {//starting position
                    if (moved) {
                        map[y][x] = 0;
                    }//changing to 0 if starting position has moved
                    else {

                        playerX = x;
                        playerY = y;
                        break;
                    }
                }
            }
        }

        while (!doorOpen) {
            //Render game level
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    if (x == playerX && y == playerY) {
                        System.out.print("@"); //Player
                    } else if (map[y][x] == 2 || (keyCollected && map[y][x] == 3)) {
                        //player starting position and collected key should not be visible
                        //that is why we nned to override the map!
                        System.out.print(0);
                    } else {
                        System.out.print(map[y][x]);
                    }
                }
                System.out.println();
            }

            System.out.println("Where do you want to go? (w -> up, s -> down, a -> left, d -> right, q -> quite, x -> save");
            char move = scanner.next().charAt(0);

            //calculate position after player move
            int nextX = playerX;
            int nextY = playerY;
            if (move == 'w') {
                nextY--;//Y is inverted (up is down)
            } else if (move == 's') {
                nextY++;
            } else if (move == 'a') {
                nextX--;
            } else if (move == 'd') {
                nextX++;
            } else if (move == 'x') {
   //             maps[level_i] = map;
     //           save(doorOpen, keyCollected, maps, level);
            }
            else if (move == 'q') {
                System.out.println("Quit!");
                return;
            }

            //if true -> don't move player
            boolean resetMove = false;

            //check if next move is out of array bound
            if (nextY < 0 ||
                    nextY >= map.length ||
                    nextX < 0 ||
                    nextX >= map[nextY].length) {
                System.out.println("Cannot pass here!");
                resetMove = true;
            } else {
                int nextField = map[nextY][nextX];

                if (nextField == 1) {//wall
                    System.out.println("Cannot pass here!");
                    resetMove = true;
                } else if (nextField == 0 || nextField == 2) {//floor or starting point
                    System.out.println("You passed through.");
                } else if (nextField == 3) {//key
                    if (!keyCollected) {//collect if not collected
                        keyCollected = true;
                        System.out.println("Collected key!");//You passed through.
                    } else {//if collected -> acts like floor
                        System.out.println("You passed through.");
                    }
                } else if (nextField == 4) {//door
                    if (!keyCollected) {//locked if key is not collected
                        System.out.println("It's locked!");
                        resetMove = true;
                    } else {//opens if key is collected
                        doorOpen = true;
                        System.out.println("Opened. You won!");
                    }
                } else if (nextField == 5) {//trap
                    System.out.println("It's a trap! You died...");
                    break;
                }
            }

            if (!resetMove) {//move player if we don't want to reset move
                playerX = nextX;
                playerY = nextY;
                moved = true;
            }
            if (move == 'x') {
                maps[level_i] = map;
                save(doorOpen, keyCollected, maps, level, nextX, nextY, moved);
            }//executing the save after move
        }
        //going to next level; cancelling door and key variables
            System.out.println("Congratulation!!!");
            System.out.println("You have passed to the next level");
        doorOpen=false;
        keyCollected=false;
        moved = false;
        }

    }




    private static void save(boolean doorOpen, boolean keyCollected, int[][][] maps, int level, int nextX, int nextY, boolean moved) {

        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("maps.txt"))) {
         oos.writeObject(new Frame_for_maps( doorOpen,  keyCollected,  maps,  level, nextX, nextY, moved));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        ObjectInputStream oos = new ObjectInputStream()file = "maps.txt";
    }

    private static Frame_for_maps load() {
        int[][][] maps;
        Frame_for_maps frame = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("maps.txt"))) {
                try {
                      frame = (Frame_for_maps) ois.readObject();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        ObjectInputStream oos = new ObjectInputStream()file = "maps.txt";

        return frame;
    }




}
