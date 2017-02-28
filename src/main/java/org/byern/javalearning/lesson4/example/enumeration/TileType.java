package org.byern.javalearning.lesson4.example.enumeration;

/**
 * Created by ByerN on 26.02.2017.
 */
public enum TileType{
    FLOOR(0, true),
    WALL(1, false),
    STARTING_POINT(2, true),
    KEY(3, true),
    DOOR(4, false),
    TRAP(5, true);

    private final int id;
    private final boolean moveAllowed;

    TileType(int id, boolean moveAllowed) {
        this.id = id;
        this.moveAllowed = moveAllowed;
    }

    public static TileType getTileTypeById(int id){
        TileType result = WALL;
        for (TileType tileType : TileType.values()) {
            if (tileType.id == id) {
                result = tileType;
                break;
            }
        }
        return result;
    }

    public boolean isMoveAllowed() {
        return moveAllowed;
    }

    public int getId() {
        return id;
    }
}
