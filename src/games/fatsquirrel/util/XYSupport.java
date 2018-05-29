package games.fatsquirrel.util;

import games.fatsquirrel.console.GameCommandType;
import games.fatsquirrel.core.EntityContext;
import games.fatsquirrel.core.XY;

import java.util.Random;

public class XYSupport {

    private static final Random random = new Random();

    public static XY getRandomMoveVector() {
        int deltaX = -1 + random.nextInt(3);
        int deltaY = -1 + random.nextInt(3);
        return new XY(deltaX, deltaY);
    }

    public static XY getRandomEmptyPosition(int width, int heigth, EntityContext context) {
        XY randomPos = getRandomPosition(width, heigth);
        while (context.getEntityType(randomPos) != null)
            randomPos = getRandomPosition(width, heigth);
        return randomPos;
    }

    public static XY add(XY a, XY b) {
        return new XY(a.getX() + b.getX(), a.getY() + b.getY());
    }

    public static XY convertFromGameCommand(GameCommandType command) {
        switch (command) {

            case LEFT:
                return new XY(-1, 0);
            case UP:
                return new XY(0, 1);
            case DOWN:
                return new XY(0, -1);
            case RIGHT:
                return new XY(1, 0);
            default:
                return new XY(0, 0);
        }
    }

    private static XY getRandomPosition(int width, int height) {
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        return new XY(x, y);
    }

}
