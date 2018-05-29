package games.fatsquirrel.core;

import java.util.Random;

public final class XY {

    private static Random random = new Random();
    private final int x, y;

    public static final XY ZERO_ZERO = new XY(0, 0);
    public static final XY RIGHT = new XY(1, 0);
    public static final XY LEFT = new XY(-1, 0);
    public static final XY UP = new XY(0, -1);
    public static final XY DOWN = new XY(0, 1);
    public static final XY RIGHT_UP = new XY(1, -1);
    public static final XY RIGHT_DOWN = new XY(1, 1);
    public static final XY LEFT_UP = new XY(-1, -1);
    public static final XY LEFT_DOWN = new XY(-1, 1);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public XY distanceFrom(XY b) {
        int x = getX() - b.getX();
        int y = getY() - b.getY();
        return new XY(x, y);
    }

    @Override
    public String toString() {
        return "X: " + x + " | Y:" + y;
    }

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double convertDistance(XY b) {
        if(b.getX() > b.getY())
            return b.getX();
        else
            return b.getY();
    }
}
