package games.fatsquirrel.entities;

import games.fatsquirrel.core.EntityContext;
import games.fatsquirrel.core.FlattenedBoard;
import games.fatsquirrel.core.XY;
import games.fatsquirrel.util.XYSupport;

public class GoodBeast extends Character {

    private static final int START_ENERGY = 200;
    private int nextStepCounter;

    public GoodBeast(int id, XY startPos) {
        super(id, START_ENERGY, startPos);
    }

    @Override
    public int getStartEnergy() {
        return START_ENERGY;
    }

    @Override
    public XY nextStep(EntityContext context) {
        if (nextStepCounter % 4 != 0)
            return getPosition();

        context.tryMove(this, XYSupport.getRandomMoveVector());
        PlayerEntity nearestPlayer = context.nearestPlayerEntity(getPosition());
        XY distance = getPosition().distanceFrom(nearestPlayer.getPosition());
        if ((distance.getX() > 6 && distance.getY() > 6) ||
                Math.abs(distance.getX()) == 0 && Math.abs(distance.getY()) == 0) {
            nextStepCounter++;
            return getPosition();
        }
        //MoveCommand moveCommand;
        int deltaX = 0;
        int deltaY;
        if (getPosition().getX() > nearestPlayer.getPosition().getX()) // Move left, decrement x
            deltaX = 1;
        else if (getPosition().getX() < nearestPlayer.getPosition().getX())
            deltaX = -1;
        else if (getPosition().getX() == nearestPlayer.getPosition().getX())
            deltaX = 0;
        if (getPosition().getY() > nearestPlayer.getPosition().getY())
            deltaY = -1;
        else if (getPosition().getY() < nearestPlayer.getPosition().getY())
            deltaY = 1;
        else
            deltaY = 0;

        XY nextStep = new XY(deltaX, deltaY);
        context.tryMove(this, XY.getRandomMoveVector());
        return XY.getRandomMoveVector();
    }
}
