package org.byern.javalearning.lesson4.homework;

import org.byern.javalearning.lesson4.example.SelfDocumentingCodeExample;
import org.byern.javalearning.lesson4.example.enumeration.TileType;

import java.util.Random;

/**
 * Created by ByerN on 26.02.2017.
 */
public class Homework4 {

    public static final int ROOM_MINIMAL_OFFSET = 2;
    public static final int WALL_SIZE = 1;

    public static void main(String[] args) {
        /*
         * Make a method returning array representing random generated game level
         * that can be used in a game from previous lessons and use:
         *
         * SelfDocumentingCodeExample.playGame(int[][][] map)
         *
         * to play it.
         *
         * int[][] generateRandomGameLevel(int width, int height)
         *
         * Ensure that game can be finished.
         */
        SelfDocumentingCodeExample.playGame(new int[][][]{generateRandomGameLevel(5, 5)});

    }

    /**
     * This method is generating random game level.
     * Minimal size is width = 5 and height = 5
     * <p>
     * If constraint is violated, throws IllegalArgumentException.
     *
     * @param width  width of the returned map
     * @param height height of the returned map
     * @return returns randomly generated map
     */
    public static int[][] generateRandomGameLevel(int width, int height) {
        int[][] map = new int[height][width];
        if (width < 5 && height < 5) {
            throw new IllegalArgumentException("Too small map");
        }
        Random random = new Random();

        makeRooms(map, width, height, random);

        int[] playerCoordinates = getRandomPoint(WALL_SIZE, width - WALL_SIZE, WALL_SIZE, height - WALL_SIZE, random);
        int[] trapCoordinates = getRandomPoint(WALL_SIZE, width - WALL_SIZE, WALL_SIZE, height - WALL_SIZE, random);
        int[] keyCoordinates = getRandomPoint(WALL_SIZE, width - WALL_SIZE, WALL_SIZE, height - WALL_SIZE, random);
        int[] doorCoordinates = getRandomPoint(WALL_SIZE, width - WALL_SIZE, WALL_SIZE, height - WALL_SIZE, random);
        randomizeIfNeeded(width, height, random, new int[][]{
                playerCoordinates,
                doorCoordinates,
                trapCoordinates,
                keyCoordinates
        });
        drawWays(map, playerCoordinates, trapCoordinates, keyCoordinates, doorCoordinates);
        drawActors(map, playerCoordinates, trapCoordinates, keyCoordinates, doorCoordinates);
        drawBorders(width, height, map);
        return map;
    }

    private static void drawWays(int[][] map, int[] playerCoordinates, int[] trapCoordinates, int[] keyCoordinates, int[] doorCoordinates) {
        drawAxis(map, playerCoordinates);
        drawAxis(map, trapCoordinates);
        drawAxis(map, keyCoordinates);
        drawAxis(map, doorCoordinates);
    }

    private static void drawActors(int[][] map, int[] playerCoordinates, int[] trapCoordinates, int[] keyCoordinates, int[] doorCoordinates) {
        draw(map, playerCoordinates[0], playerCoordinates[1], TileType.STARTING_POINT.getId());
        draw(map, trapCoordinates[0], trapCoordinates[1], TileType.TRAP.getId());
        draw(map, keyCoordinates[0], keyCoordinates[1], TileType.KEY.getId());
        draw(map, doorCoordinates[0], doorCoordinates[1], TileType.DOOR.getId());
    }

    private static void drawBorders(int width, int height, int[][] map) {
        drawVerticalWall(map, 0);
        drawVerticalWall(map, width - 1);
        drawHorizontalWall(map, 0);
        drawHorizontalWall(map, height - 1);
    }

    private static void makeRooms(int[][] map, int width, int height, Random random) {
        int yPointer = 0;
        while (yPointer < height) {
            yPointer = makeRowRooms(map, yPointer, width, height, random);
        }
    }

    private static int makeRowRooms(int[][] map, int startingPoint, int width, int height, Random random) {
        int roomHeight = ROOM_MINIMAL_OFFSET + random.nextInt(height / 2);
        int nextY = Math.min(startingPoint + roomHeight, height);

        drawHorizontalWall(map, nextY);
        makeColumnRooms(map, startingPoint, nextY, width, random);

        startingPoint = nextY;
        if (startingPoint + ROOM_MINIMAL_OFFSET >= height) {
            startingPoint = height;
        }
        return startingPoint;
    }

    private static void makeColumnRooms(int[][] map, int fromY, int toY, int width, Random random) {
        int xPointer = 0;
        while (xPointer < width) {
            int roomWidth = ROOM_MINIMAL_OFFSET + random.nextInt(width);
            int nextX = Math.min(xPointer + roomWidth, width);
            if (nextX + ROOM_MINIMAL_OFFSET >= width) {
                nextX = width;
            }

            drawVerticalWall(map, nextX, fromY, toY);
            xPointer = nextX;

        }
    }

    private static void randomizeIfNeeded(int width, int height, Random random, int[][] coords) {
        boolean changed;
        do {
            changed = false;
            for (int n = 0; n < coords.length; n++) {
                for (int m = 0; m < coords.length; m++) {
                    if (n != m && coords[n][0] == coords[m][0] && coords[n][1] == coords[m][1]) {
                        int[] randomPoint = getRandomPoint(
                                WALL_SIZE,
                                width - WALL_SIZE,
                                WALL_SIZE,
                                height - WALL_SIZE,
                                random
                        );
                        coords[n][0] = randomPoint[0];
                        coords[n][1] = randomPoint[1];
                        changed = true;
                    }
                }
            }
        } while (changed);
    }

    private static void drawAxis(int[][] map, int[] playerCoordinates) {
        drawVerticalFloor(map, playerCoordinates[0]);
        drawHorizontalFloor(map, playerCoordinates[1]);
    }

    private static int[] getRandomPoint(int fromX, int toX, int fromY, int toY, Random random) {
        int[] playerCoordinates = new int[2];
        playerCoordinates[0] = fromX + random.nextInt(toX - fromX);
        playerCoordinates[1] = fromY + random.nextInt(toY - fromY);
        return playerCoordinates;
    }

    private static void drawVerticalWall(int[][] map, int x) {
        drawVerticalWall(map, x, 0, map.length);
    }

    private static void drawVerticalWall(int[][] map, int x, int fromY, int toY) {
        drawVerticalLine(map, x, fromY, toY, TileType.WALL.getId());
    }

    private static void drawVerticalFloor(int[][] map, int x) {
        drawVerticalLine(map, x, 0, map.length, TileType.FLOOR.getId());
    }

    private static void drawVerticalLine(int[][] map, int x, int fromY, int toY, int value) {
        for (int y = fromY; y < toY; y++) {
            draw(map, x, y, value);
        }
    }


    private static void drawHorizontalWall(int[][] map, int y) {
        drawHorizontalLine(map, y, TileType.WALL.getId());
    }

    private static void drawHorizontalFloor(int[][] map, int y) {
        drawHorizontalLine(map, y, TileType.FLOOR.getId());
    }

    private static void drawHorizontalLine(int[][] map, int y, int value) {
        if (y >= 0 && y < map.length) {
            for (int x = 0; x < map[y].length; x++) {
                draw(map, x, y, value);
            }
        }
    }

    private static boolean isInBound(int[][] map, int x, int y) {
        return y >= 0 && y < map.length && x >= 0 && x < map[y].length;
    }

    private static void draw(int[][] map, int x, int y, int value) {
        if (isInBound(map, x, y)) {
            map[y][x] = value;
        }
    }
}
