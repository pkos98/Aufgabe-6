package games.fatsquirrel.entities;

import games.fatsquirrel.core.EntityContext;
import games.fatsquirrel.core.XY;
import games.fatsquirrel.util.XYSupport;

public class MiniSquirrel extends PlayerEntity {
    private static int START_ENERGY = 0;

    public MiniSquirrel(int id, XY startPos, MasterSquirrel master) {
        super(id, START_ENERGY, startPos);
    }

    @Override
    public int getStartEnergy() {
        return START_ENERGY;
    }

    @Override
    public XY nextStep(EntityContext entityContext) {
        entityContext.tryMove(this, XYSupport.getRandomMoveVector());
        return getPosition();
    }
}
