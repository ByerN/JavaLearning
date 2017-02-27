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
        boolean nextLevel = true;
        int currentLevel = 1;

        //Game first level:
        int[][] map1 = {
                {0, 1, 4, 1},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {3, 0, 2, 5},
        };
        int[][] map2 = {
                {4, 0, 0, 1},
                {0, 1, 2, 0},
                {0, 1, 0, 1},
                {5, 0, 0, 3},
        };
        int[][] map3 = {
                {0, 0, 0, 3},
                {0, 1, 1, 5},
                {0, 1, 2, 4},
                {0, 0, 0, 1},
        };

        int[][] map = map1;//This solution is not scaling. Next level makes you use next case in switch

        while (nextLevel) {
            //Search and set player starting point
            int playerX = 0;
            int playerY = 0;
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
                for (int y = 0; y < map.length; y++) {
                    for (int x = 0; x < map[y].length; x++) {
                        if (x == playerX && y == playerY) {
                            System.out.print("@"); //Player
                        } else if (map[y][x] == 2 || (keyCollected && map[y][x] == 3)) {
                            //player starting position and collected key should not be visible
                            System.out.print(0);
                        } else {
                            System.out.print(map[y][x]);
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
                            System.out.println("Opened. You won!");
                            if (currentLevel == 3) {
                                System.out.println("You have finished the game!");
                                nextLevel = false;
                            } else {
                                System.out.println("Next level? Y/N");
                                nextLevel = scanner.next().equals("Y");
                                if (nextLevel) {
                                    switch (currentLevel) {
                                        case 1: map = map2; break;//don't put all in one line
                                        case 2: map = map3; break;//check what CTRL+L will do now
                                    }
                                    currentLevel++;
                                }
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
        System.out.println("Thank you for playing!");
    }
}
