package org.byern.javalearning.lesson4.example;

import org.byern.javalearning.lesson4.example.enumeration.GameState;
import org.byern.javalearning.lesson4.example.enumeration.Move;
import org.byern.javalearning.lesson4.example.enumeration.TileType;

import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class SelfDocumentingCodeExample {

    private static final String PLAYER_SIGN = "@";
    private static final char QUIT_CHARACTER = 'q';

    public static void main(String[] args) {

        //Game level:
        int[][][] map = {
                {
                        {0, 1, 4, 1},
                        {0, 1, 0, 1},
                        {1, 1, 0, 1},
                        {3, 0, 2, 5},
                },
                {
                        {1, 0, 4, 1},
                        {1, 0, 1, 1},
                        {1, 0, 1, 1},
                        {2, 0, 3, 5},
                },
                {
                        {1, 1, 1, 1, 1, 1, 4, 0},
                        {1, 1, 1, 1, 1, 2, 1, 0},
                        {3, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 5},
                },
        };

        playGame(map);
    }

    public static void playGame(int[][][] map) {
        int currentLevel = 0;
        Scanner scanner = new Scanner(System.in);
        GameState endGameState = playGame(scanner, map, currentLevel);
        endGame(endGameState);
    }

    private static GameState playGame(Scanner scanner, int[][][] map, int currentLevel) {
        GameState gameState = GameState.PLAYING;
        while (gameState == GameState.PLAYING) {

            gameState = playGameLevel(scanner, map[currentLevel], gameState);

            if(gameState == GameState.NEXT_LEVEL){
                currentLevel++;
                gameState = GameState.PLAYING;
                if(currentLevel >= map.length){
                    gameState = GameState.GAME_FINISHED;
                }
            }
        }
        return gameState;
    }

    private static GameState playGameLevel(Scanner scanner, int[][] currentLevel, GameState gameState) {

        int[] playerCoordinates = findPlayerStartingPoint(currentLevel);

        int playerX = playerCoordinates[0];
        int playerY = playerCoordinates[1];

        while (gameState == GameState.PLAYING ||
                gameState == GameState.PLAYING_WITH_KEY) {

            renderGameLevel(currentLevel, playerX, playerY, gameState);

            char moveKey = scanner.next().charAt(0);

            if (moveKey == QUIT_CHARACTER) {
                gameState = GameState.QUIT_GAME;
            } else {
                int nextX = playerX;
                int nextY = playerY;
                Move move = Move.getMoveByCharacter(moveKey);
                if (move != null) {
                    nextX += move.getXDiff();
                    nextY += move.getYDiff();

                    boolean moveAllowed;

                    if (checkMapBounds(currentLevel, nextX, nextY)) {
                        processWallMove();
                        moveAllowed = false;
                    } else {
                        int nextField = currentLevel[nextY][nextX];
                        TileType tileType = TileType.getTileTypeById(nextField);
                        moveAllowed = tileType.isMoveAllowed();
                        gameState = processGameState(gameState, tileType);
                    }

                    if (moveAllowed) {
                        playerX = nextX;
                        playerY = nextY;
                    }
                }
            }
        }
        return gameState;
    }

    private static void endGame(GameState gameState) {
        switch (gameState){
            case DEAD:
                System.out.println("Next time will be better...");
                break;
            case QUIT_GAME:
                System.out.println("Come back next time!");
                break;
            case GAME_FINISHED:
            default:
                System.out.println("Good game!");
                break;
        }
    }

    private static GameState processGameState(GameState gameState, TileType tileType) {
        GameState nextState = gameState;
        switch (tileType){
            case WALL:
                processWallMove();
                break;
            case FLOOR:
            case STARTING_POINT:
                processNormalMove();
                break;
            case KEY:
                nextState = processKeyMove(gameState);
                break;
            case DOOR:
                nextState = processDoorMove(gameState);
                break;
            case TRAP:
                nextState = processDead();
                break;
            default:
                break;
        }
        return nextState;
    }

    private static GameState processDead() {
        System.out.println("It's a trap! You died...");
        return GameState.DEAD;
    }

    private static GameState processDoorMove(GameState gameState) {
        GameState nextState = gameState;
        if (gameState != GameState.PLAYING_WITH_KEY) {
            processClosedDoor();
        } else {
            nextState = processDoorOpening();
        }
        return nextState;
    }

    private static GameState processDoorOpening() {
        System.out.println("Opened. You won level!");
        return GameState.NEXT_LEVEL;
    }

    private static void processClosedDoor() {
        System.out.println("It's locked!");
    }

    private static GameState processKeyMove(GameState gameState) {
        GameState nextState = gameState;
        if (gameState != GameState.PLAYING_WITH_KEY) {
            nextState = processCollectingKey();
        } else {
            processNormalMove();
        }
        return nextState;
    }

    private static GameState processCollectingKey() {
        System.out.println("Collected key!");
        return GameState.PLAYING_WITH_KEY;
    }

    private static void processNormalMove() {
        System.out.println("You passed through.");
    }

    private static void processWallMove() {
        System.out.println("Cannot pass here!");
    }

    private static boolean checkMapBounds(int[][] currentLevelMap, int nextX, int nextY) {
        return nextY < 0 ||
                nextY >= currentLevelMap.length ||
                nextX < 0 ||
                nextX >= currentLevelMap[nextY].length;
    }

    private static void renderGameLevel(int[][] currentLevelMap,
                                        int playerX,
                                        int playerY,
                                        GameState gameState) {
        for (int y = 0; y < currentLevelMap.length; y++) {
            for (int x = 0; x < currentLevelMap[y].length; x++) {
                if (x == playerX && y == playerY) {
                    renderPlayer();
                } else {
                    renderTile(currentLevelMap[y][x], gameState);
                }
            }
            System.out.println();
        }
        System.out.println("Where do you want to go? (w -> up, s -> down, a -> left, d -> right");
    }

    private static void renderTile(int tile, GameState gameState) {
        if (tile == TileType.STARTING_POINT.getId() ||
                (gameState == GameState.PLAYING_WITH_KEY && tile == TileType.KEY.getId())) {
            System.out.print(0);
        } else {
            System.out.print(tile);
        }
    }

    private static void renderPlayer() {
        System.out.print(PLAYER_SIGN);
    }

    private static int[] findPlayerStartingPoint(int[][] level) {
        int[] playerCoordinates = new int[2];
        boolean startingPointSet = false;
        for (int y = 0; y < level.length && !startingPointSet; y++) {
            for (int x = 0; x < level[y].length; x++) {
                if (level[y][x] == TileType.STARTING_POINT.getId()) {
                    playerCoordinates[0] = x;
                    playerCoordinates[1] = y;
                    startingPointSet = true;
                    break;
                }
            }
        }
        return playerCoordinates;
    }

}
