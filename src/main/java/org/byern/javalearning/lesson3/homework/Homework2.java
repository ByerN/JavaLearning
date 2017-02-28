//package org.byern.javalearning.lesson3.homework;

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
        int[][] mapLvl1 = {
                {0, 1, 4, 1},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {3, 0, 2, 5},
        };

        int[][] mapLvl2 = {
                {2, 1, 3, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 4, 5, 0},
                {0, 1, 5, 1, 0},
                {0, 0, 0, 0, 0},
        };

        int[][] mapLvl3 = {
                {4, 5, 5, 0, 0, 2},
                {0, 5, 0, 0, 5, 5},
                {0, 0, 0, 5, 0, 3},
                {0, 5, 5, 5, 0, 5},
                {0, 0, 0, 0, 0, 5},
        };

        int[][] map;

        System.out.println("Hello Player. You are marked as (2). Your task is to find key (3) and exit " +
                "through door (4). Have fun but beware of traps.");

        for (int level = 1; level < 4; level++) {
            //Search and set player starting point
            int playerX = 0;
            int playerY = 0;

            if (level == 1) {
                map = mapLvl1;
            } else if (level == 2) {
                map = mapLvl2;
            } else {
                map = mapLvl3;
            }

            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    if (map[y][x] == 2) {
                        playerX = x;
                        playerY = y;
                        break;
                    }
                }
            }

            boolean keyCollected = false;
            boolean doorOpen = false;


            while (!doorOpen) {
                //Render game level
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Level "+level+"\n");
                for (int y = 0; y < map.length; y++) {
                    for (int x = 0; x < map[y].length; x++) {
                        if (x == playerX && y == playerY) {
                            System.out.print("@"+" "); //Player
                        } else if (map[y][x] == 2 || (keyCollected && map[y][x] == 3)) {
                            //player starting position and collected key should not be visible
                            System.out.print(0+" ");
                        } else {
                            System.out.print(map[y][x]+" ");
                        }
                    }
                    System.out.println();
                }

				System.out.println();
                System.out.println("Where do you want to go? (w -> up, s -> down, a -> left, d -> right)");
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
                            System.out.println("Collected key!");
                        } else {//if collected -> acts like floor
                            System.out.println("You passed through.");
                        }
                    } else if (nextField == 4) {//door
                        if (!keyCollected) {//locked if key is not collected
                            System.out.println("It's locked!");
                            resetMove = true;
                        } else {//opens if key is collected
                            doorOpen = true;
                            if (level == 3) {
                                System.out.println("Congratulations. You've beaten the game.");
                            } else {
                                System.out.println("Opened. You can proceed to lower level.");
                            }
                        }
                    } else if (nextField == 5) {//trap
                        System.out.println("It's a trap! You died... Resetting level.");
                        level--;
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

}
