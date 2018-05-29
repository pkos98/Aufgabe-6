package games.fatsquirrel.entities;

import games.fatsquirrel.core.XY;

import java.util.logging.Logger;

public abstract class PlayerEntity extends Character {

    private static final int START_ENERGY = 0;

    private boolean isParalyzed;
    private int paralyzeCounter = 0;
    private MasterSquirrel patron;
    private Logger logger = Logger.getLogger(getClass().getName());
    private final int PARALYZED_STEPS = 3;

    public MasterSquirrel getPatron() {
        return patron;
    }

    public PlayerEntity(int id, int startEnergy, XY startPos) {
        super(id, startEnergy, startPos);
    }

    public void paralyze() {

        isParalyzed = true;
        logger.info(this + " is paralyzed!");
    }

    protected boolean isParalyzed(boolean incrementCounter) {
        if (isParalyzed == false)
            return false;
        if (incrementCounter)
            paralyzeCounter++;
        if (paralyzeCounter == PARALYZED_STEPS) {
            isParalyzed = false;
            paralyzeCounter = 0;
            return false;
        }
        logger.info(this + " is still paralyzed!" + (PARALYZED_STEPS - paralyzeCounter) + " steps left!");
        return true;
    }

}
