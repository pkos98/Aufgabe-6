package games.fatsquirrel.entities;

import games.fatsquirrel.core.EntityContext;
import games.fatsquirrel.core.XY;
import games.fatsquirrel.util.XYSupport;

public class BadBeast extends Character {

    private int biteCounter = 0;
    private int nextStepCounter = 0;
    private static final int START_ENERGY = -150;

    public BadBeast(int id, XY startPos) {
        super(id, START_ENERGY, startPos);
    }

    @Override
    public int getStartEnergy() {
        return START_ENERGY;
    }

    public boolean bite() {
        if (biteCounter == 6)
            return false;
        biteCounter++;
        return true;
    }

    @Override
    public XY nextStep(EntityContext context) {
        if (nextStepCounter % 4 != 0)
            return getPosition();

        PlayerEntity nearestPlayer = context.nearestPlayerEntity(getPosition());
        XY distance = getPosition().distanceFrom(nearestPlayer.getPosition());
        if ((distance.getX() > 6 && distance.getY() > 6) ||
                distance.getX() == 0 && distance.getY() == 0) {
            nextStepCounter++;
            return getPosition();
        }
        context.tryMove(this, XYSupport.getRandomMoveVector());
        return getPosition();
    }
}
