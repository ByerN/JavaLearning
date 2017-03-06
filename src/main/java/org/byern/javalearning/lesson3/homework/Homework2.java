package org.byern.javalearning.lesson3.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework2 {

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
        int level = 0;
        int[][][] map = {
                {
                        {0, 1, 4, 1},
                        {0, 1, 0, 1},
                        {1, 1, 0, 1},
                        {3, 0, 2, 5},
                },
                {
                        {0, 1, 4, 1},
                        {0, 0, 0, 1},
                        {0, 1, 0, 0},
                        {3, 0, 5, 2},
                },
                {
                        {2, 1, 4, 1},
                        {0, 0, 0, 1},
                        {0, 1, 0, 1},
                        {3, 0, 0, 5},
                }
        };

        //Search and set player starting point
        int playerX = 0;
        int playerY = 0;
        for (int y = 0; y < map[level].length; y++) {
            for (int x = 0; x < map[level][y].length; x++) {
                if (map[level][y][x] == 2) {
                    playerX = x;
                    playerY = y;
                    break;
                }
            }
        }


        boolean keyCollected = false;
        boolean doorOpen = false;


        while (!doorOpen||level<map.length){

            //Render game level
            for (int y = 0; y < map[level].length; y++) {
                for (int x = 0; x < map[level][y].length; x++) {
                    if (x == playerX && y == playerY) {
                        System.out.print("ツ"); //Player
                    } else if (map[level][y][x] == 2 || (keyCollected && map[level][y][x] == 3)) {
                        //player starting position and collected key should not be visible
                        System.out.print(0);
                    } else {
                        System.out.print(map[level][y][x]);
                    }
                }
                System.out.println();
            }

            System.out.println("Where do you want to go? (w -> up, s -> down, a -> left, d -> right");
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
            } else if (move == 'q') {
                System.out.println("Quit!");
                return;
            }

            //if true -> don't move player
            boolean resetMove = false;

            //check if next move is out of array bound
            if (nextY < 0 ||
                    nextY >= map[level].length ||
                    nextX < 0 ||
                    nextX >= map[level][nextY].length) {
                System.out.println("Cannot pass here!");
                resetMove = true;
            } else {
                int nextField = map[level][nextY][nextX];

                if (nextField == 1) {//wall
                    System.out.println("Cannot pass here!");
                    resetMove = true;
                } else if (nextField == 0 || nextField == 2) {//floor or starting point
                    System.out.println("You passed through.");
                } else if (nextField == 3) {//key
                    if (!keyCollected) {//collect if not collected
                        keyCollected = true;
                        System.out.println("Key is collected!");
                    } else {//if collected -> acts like floor
                        System.out.println("You passed through.");
                    }
                } else if (nextField == 4) {//door
                    if (!keyCollected) {//locked if key is not collected
                        System.out.println("It's locked!");
                        resetMove = true;
                    } else {
                        //opens if key is collected and current level is not the last
                        if (level+1<map.length){
                            doorOpen = true;
                            System.out.println("Door opened. You finished "+(level+1)+" level and you are moving to next "+(level+2)+" level!");
                            keyCollected = false;
                            doorOpen = false;
                            level++;

                            //Search and set player starting point
                            playerX = 0;
                            playerY = 0;
                            for (int y = 0; y < map[level].length; y++) {
                                for (int x = 0; x < map[level][y].length; x++) {
                                    if (map[level][y][x] == 2) {
                                        playerX = x;
                                        playerY = y;
                                        break;
                                    }
                                }
                            }
                            nextX=playerX;
                            nextY=playerY;
                        }
                        else {//opens if key is collected and current level is the last
                            doorOpen = true;
                            level++;
                            System.out.println("Door opened. You finished the last "+(level)+" level and you won the game!");
                        }
                    }
                } else if (nextField == 5) {//trap
                    System.out.println("It's a trap! You died...");
                    break;
                }
            }

            if (!resetMove) {//move player if we don't want to reset move
                playerX = nextX;
                playerY = nextY;
            }
        }

    }

}
