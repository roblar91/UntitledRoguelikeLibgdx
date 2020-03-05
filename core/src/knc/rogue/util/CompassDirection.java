package knc.rogue.util;

public enum CompassDirection {
    NORTHWEST(-1, 1),
    NORTH(0, 1),
    NORTHEAST(1, 1),
    EAST(1, 0),
    WEST(-1, 0),
    SOUTHWEST(-1, -1),
    SOUTH(0, -1),
    SOUTHEAST(1, -1),
    NONE(0, 0);

    public int dX;
    public int dY;

    CompassDirection(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }
}
